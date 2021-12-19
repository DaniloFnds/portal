package config

import (
	"encoding/json"
	"fmt"
	"github.com/gorilla/mux"
	"github.com/joho/godotenv"
	"log"
	"net/http"
	"os"
	"strconv"
)

var (
	DbCassandraPublicIpC1 = ""
	DbCassandraPublicIpC2 = ""
	DbCassandraPublicIpC3 = ""
	DbCassandraUsername   = ""
	DbCassandraPassword   = ""
	DbCassandraKeySpace   = ""
	ServerPorta           = 0
)

// CarregarConfig carrega as variavies de ambiente
func carregarEnvConfig() {

	var erro error

	if erro = godotenv.Load(); erro != nil {
		log.Fatal(erro)
	}

	if ServerPorta, erro = strconv.Atoi(os.Getenv("SERVER.PORT")); erro != nil {
		ServerPorta = 5000
	}

	DbCassandraPublicIpC1 = os.Getenv("DB_CASSANDRA_PUBLICIP_C1")
	DbCassandraUsername = os.Getenv("DB_CASSANDRA_USERNAME")
	DbCassandraPassword = os.Getenv("DB_CASSANDRA_PASSWORD")
	DbCassandraKeySpace = os.Getenv("DB_CASSANDRA_KEYSPACE")

}

// BootConfig Metodo para inicializar todos config init
func BootConfig(rotas []Rota) *mux.Router {
	log.Println("Iniciando carregamento as variaveis de Config")
	carregarEnvConfig()

	fmt.Println("Tentando abrir Session com o banco", GetSession())

	log.Println("Incluindo rota de heapth-api")
	rotas = append(rotas, incluirRotaHealth())

	log.Println("Carregando Rotas")
	return ConfigurarRotas(gerarRouterMux(), rotas)
}

func incluirRotaHealth() Rota {
	return Rota{
		URI: "/health",
		Funcao: func(w http.ResponseWriter, r *http.Request) {
			log.Println("Health Requested")
			w.Header().Set("Content-Type", "application/json")
			w.WriteHeader(http.StatusOK)
			ok, err := json.Marshal(map[string]string{"status": "OK"})
			if err != nil {
				log.Fatal(err)
			}
			w.Write(ok)
		}, Metodo: http.MethodGet,
		RequerAutenticacao: false,
	}
}

func gerarRouterMux() *mux.Router {
	return mux.NewRouter()
}
