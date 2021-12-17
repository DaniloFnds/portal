package controllers

import (
	"log"
	"net/http"
)

func PegarUmaOperacao(w http.ResponseWriter, r *http.Request) {

	log.Println("Chamaram")
	w.Header().Set("Content-Type", "application/json")
	w.Write([]byte("Ola"))
}
