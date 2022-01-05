package publisher

import (
	"errors"
	"github.com/rabbitmq/amqp091-go"
	"github.com/wagslane/go-rabbitmq"
	"log"
	"os"
)

// PublicarAprovacao serve para publicar no broker q ocorre uma aprovacao da operacao
func PublicarAprovacao(payload []byte) error {

	urlAmqp := os.Getenv("AMQP_SERVER_URL")

	if urlAmqp == "" {
		log.Println("variavel AMQP_SERVER_URL nao encontrada")
		return errors.New("messageria offline")
	}

	publisher, err := rabbitmq.NewPublisher(urlAmqp, amqp091.Config{}, rabbitmq.WithPublisherOptionsLogging)
	if err != nil {
		return err
	}

	err = publisher.Publish(payload, []string{"rk_aprovar_operacao"},
		rabbitmq.WithPublishOptionsContentType("application/json"),
	)

	if err != nil {
		return err
	}

	return nil
}
