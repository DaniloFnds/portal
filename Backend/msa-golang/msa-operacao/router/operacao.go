package router

import (
	"msa-operacao/config"
	"msa-operacao/controllers"
	"net/http"
)

var OperacaoRotas = []config.Rota{
	{
		URI:                "/operacao",
		Metodo:             http.MethodGet,
		Funcao:             controllers.PegarUmaOperacao,
		RequerAutenticacao: false,
	},
}
