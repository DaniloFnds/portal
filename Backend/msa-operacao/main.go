package main

import (
	"context"
	"fmt"
	"log"
	"msa-operacao/config"
	"msa-operacao/router"
	"net/http"
	"os"
	"os/signal"
	"time"
)

func main() {

	fmt.Println("Iniciando App")
	bootRouters := config.BootConfig(router.OperacaoRotas)
	port := os.Getenv("SERVER_PORT")
	if port == "" {
		port = "5000"
	}
	log.Println("SERVER_PORT: " + port)

	serv := &http.Server{
		Addr:         ":" + port,
		Handler:      bootRouters,
		ReadTimeout:  1 * time.Second,   // tempo q o server demora para retornar algo
		WriteTimeout: 1 * time.Second,   //tempo q o server demora para responder uma escrita
		IdleTimeout:  120 * time.Second, //tempo q o cliente pode ficar ocioso ccom uma conexao aberta com o server
	}

	go func() {
		log.Fatal(serv.ListenAndServe())
	}()

	//tratar o sinal de fechada do app
	sigChan := make(chan os.Signal)
	signal.Notify(sigChan, os.Interrupt)
	signal.Notify(sigChan, os.Kill)

	sig := <-sigChan
	log.Println("Interropendo aplicacao por ", sig)

	//criar um shutdown, para esperar as requisicoes terminar
	deadline, cancelFunc := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancelFunc()

	log.Fatal(serv.Shutdown(deadline))
}
