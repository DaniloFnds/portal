package config

import (
	"github.com/gocql/gocql"
	"log"
	"os"
	"strconv"
	"time"
)

func GetSession() *gocql.Session {

	cluster := gocql.NewCluster(DbCassandraPublicIpC1, DbCassandraPublicIpC2, DbCassandraPublicIpC3)
	cluster.Consistency = gocql.Quorum
	cluster.ProtoVersion = 4
	cluster.ConnectTimeout = time.Second * 10
	cluster.Authenticator = gocql.PasswordAuthenticator{Username: DbCassandraUsername, Password: DbCassandraPassword}
	cluster.Keyspace = DbCassandraKeySpace
	session, err := cluster.CreateSession()
	if err != nil {
		getenv := os.Getenv("SHOULD_ERROR_BY_CHECKING_CONNECTION_DB")
		if getenv != "" {
			ok, errParse := strconv.ParseBool(getenv)
			if errParse == nil {
				if ok {
					log.Fatal(err)
				} else {
					log.Println("Ocorreu erro ao conectar ao banco de dados")
				}
			} else {
				log.Println(errParse)
			}
		}
	}

	return session
}
