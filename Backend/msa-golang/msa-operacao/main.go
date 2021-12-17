package main

import (
	"fmt"
	"log"
	"msa-config-go/config"
	"msa-operacao/router"
	"net/http"
	"os"
)

func main() {

	fmt.Println("Iniciando App")
	bootRouters := config.BootConfig(router.OperacaoRotas)
	port := os.Getenv("SERVER_PORT")
	if port == "" {
		port = "5000"
	}
	log.Println("SERVER_PORT: " + port)

	log.Fatal(http.ListenAndServe(":"+port, bootRouters))
}
