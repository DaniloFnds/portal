package router

import (
	"msa-operacao/config"
	"msa-operacao/controllers"
	"net/http"
)

var OperacaoRotas = []config.Rota{
	{
		URI:                "/operacoes",
		Metodo:             http.MethodGet,
		Funcao:             controllers.PegarOperacoes,
		RequerAutenticacao: false,
	},
	{
		URI:                "/operacoes/{id-operacao}",
		Metodo:             http.MethodGet,
		Funcao:             controllers.PegarUmaOperacao,
		RequerAutenticacao: false,
	},
	{
		URI:                "/operacoes",
		Metodo:             http.MethodPost,
		Funcao:             controllers.CriarOperacao,
		RequerAutenticacao: false,
	},
	{
		URI:                "/operacoes/{id-operacao}/aprovar",
		Metodo:             http.MethodPost,
		Funcao:             controllers.AprovarOperacao,
		RequerAutenticacao: false,
	},
}
