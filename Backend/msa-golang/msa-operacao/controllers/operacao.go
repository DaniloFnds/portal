package controllers

import (
	"encoding/json"
	"errors"
	"github.com/gofiber/fiber"
	"github.com/gorilla/mux"
	"github.com/streadway/amqp"
	"io/ioutil"
	"log"
	"msa-operacao/config"
	"msa-operacao/handler"
	"msa-operacao/repositorio"
	"net/http"
	"os"
)

//PegarOperacoes devolve todas as operacoes
func PegarOperacoes(w http.ResponseWriter, r *http.Request) {
	operacoes, err := new(repositorio.Operacao).FindAll(config.GetSession())
	if operacoes == nil {
		w.WriteHeader(http.StatusNoContent)
		return
	}

	if err != nil {
		handler.Error(w, http.StatusInternalServerError, err)
		return
	}
	handler.JSON(w, http.StatusOK, operacoes)
}

//PegarUmaOperacao devolve uma operacao
func PegarUmaOperacao(w http.ResponseWriter, r *http.Request) {
	parametros := mux.Vars(r)

	idOperacao := parametros["id-operacao"]

	if idOperacao == "" {
		handler.Error(w, http.StatusBadRequest, errors.New("parametro id nao encontrado"))
		return
	}

	operacao, err := new(repositorio.Operacao).GetOne(config.GetSession(), idOperacao)

	if err != nil {
		handler.Error(w, http.StatusInternalServerError, err)
		return
	}
	log.Println("Retornando Busca de operacao")
	handler.JSON(w, http.StatusOK, operacao)
}

// CriarOperacao cria uma nova operacao
func CriarOperacao(w http.ResponseWriter, r *http.Request) {
	payload, err := ioutil.ReadAll(r.Body)
	if err != nil {
		handler.Error(w, http.StatusInternalServerError, err)
		return
	}

	operacao := new(repositorio.Operacao)
	err = json.Unmarshal(payload, operacao)
	if err != nil {
		handler.Error(w, http.StatusBadRequest, err)
		return
	}

	err = operacao.Save(config.GetSession())

	if err != nil {
		handler.Error(w, http.StatusInternalServerError, err)
		return
	}
	w.WriteHeader(http.StatusCreated)
}

//AprovarOperacao aprovar uma operacao
func AprovarOperacao(w http.ResponseWriter, r *http.Request) {
	amqpurl := os.Getenv("AMQP_SERVER_URL")
	connectRabbit, err := amqp.Dial(amqpurl)
	if err != nil {
		panic(err)
	}

	defer connectRabbit.Close()

	channel, err := connectRabbit.Channel()
	if err != nil {
		panic(err)
	}

	defer channel.Close()

	_, err = channel.QueueDeclare(
		"QueueService1",
		true,
		false,
		false,
		false,
		nil,
	)

	if err != nil {
		panic(err)
	}

	app := fiber.New()

	/*	app.Use(
		logger.New(),
	)*/

	app.Get("/send", func(ctx *fiber.Ctx) {
		publishing := amqp.Publishing{
			ContentType: "text/plain",
			Body:        []byte(ctx.Query("ola mundo")),
		}

		err = channel.Publish(
			"",
			"QueueService1",
			false,
			false,
			publishing,
		)

		if err != nil {
			panic(err)
		}
	})

	log.Fatal(app.Listen(":3000"))

}
