package config

import (
	"fmt"
	"github.com/gorilla/mux"
	"net/http"
)

type Rota struct {
	URI                string
	Metodo             string
	Funcao             func(w http.ResponseWriter, r *http.Request)
	RequerAutenticacao bool
}

//ConfigurarRotas configura todas as rotas passadas como parametro
func ConfigurarRotas(r *mux.Router, rotas []Rota) *mux.Router {

	for _, rota := range rotas {
		fmt.Println("Rota Criada: ", rota)
		r.HandleFunc(rota.URI, rota.Funcao).Methods(rota.Metodo)
	}
	return r
}
