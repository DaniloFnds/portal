package services

import (
	"encoding/json"
	"msa-operacao/config"
	"msa-operacao/domain"
	"msa-operacao/publisher"
	"msa-operacao/repositorio"
)

//GetOperacao retorna uma operacao do repositorio
func GetOperacao(idOperacao string) (*domain.Operacao, error) {
	return repositorio.GetOne(config.GetSession(), idOperacao)
}

//AprovarOperacao Aprovar uma operacao e disparar mensagem de aprovacao
func AprovarOperacao(idOperacao string) (bool, error) {
	operacao, err := GetOperacao(idOperacao)
	if err != nil {
		return false, err
	}

	payload, err := json.Marshal(operacao)

	if err != nil {
		return false, err
	}

	err = publisher.PublicarAprovacao(payload)

	if err != nil {
		return false, err
	}

	return true, nil
}

func CriarOperacao(operacao *domain.Operacao) error {
	return repositorio.Save(config.GetSession(), operacao)
}
