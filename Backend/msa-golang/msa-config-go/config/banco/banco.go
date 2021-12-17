package banco

import (
	"github.com/gocql/gocql"
	"log"
	"msa-config-go/config"
	"time"
)

func GetSession() *gocql.Session {

	cluster := gocql.NewCluster(config.DbCassandraPublicIpC1, config.DbCassandraPublicIpC2, config.DbCassandraPublicIpC3)
	cluster.Consistency = gocql.Quorum
	cluster.ProtoVersion = 4
	cluster.ConnectTimeout = time.Second * 10
	cluster.Authenticator = gocql.PasswordAuthenticator{Username: config.DbCassandraUsername, Password: config.DbCassandraPassword}
	cluster.Keyspace = config.DbCassandraKeySpace
	session, err := cluster.CreateSession()
	if err != nil {
		log.Fatal(err)
	}

	return session
}
