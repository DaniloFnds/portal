package config

import (
	"github.com/gocql/gocql"
	"log"
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
		log.Fatal(err)
	}

	return session
}
