package router

import (
	"msa-config-go/router"
	"msa-operacao/controllers"
	"net/http"
)

var OperacaoRotas = []router.Rota{
	{
		URI:                "/operacao",
		Metodo:             http.MethodGet,
		Funcao:             controllers.PegarUmaOperacao,
		RequerAutenticacao: false,
	},
}
