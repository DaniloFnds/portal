package repositorio

import (
	"errors"
	"github.com/gocql/gocql"
)

type Operacao struct {
	Id                 gocql.UUID `json:"id,omitempty"`
	NomeFundo          string     `json:"nomeFundo,omitempty"`
	NomeArquivo        string     `json:"nomeArquivo,omitempty"`
	NomeCedente        string     `json:"nomeCedente,omitempty"`
	ValorTransferencia float64    `json:"valorTransferencia,omitempty"`
	ValorTed           float64    `json:"valorTed,omitempty"`
	Situacao           string     `json:"situacao,omitempty"`
}

func (operacao *Operacao) GetOne(session *gocql.Session, id string) (*Operacao, error) {

	var idOperacao gocql.UUID
	var nomeFundo string
	var nomeArquivo string
	var nomeCedente string
	var valorTransferencia float64
	var valorTed float64
	var situacao string

	uuid, err := gocql.ParseUUID(id)
	if err != nil {
		return nil, err
	}

	if uuid.Timestamp() == 0 {
		return nil, errors.New("Invalid UUID")
	}

	if err = session.Query(`SELECT id, nome_fundo, nome_arquivo, nome_cedente, valor_transferencia, valor_ted, situacao WHERE id = ?`,
		uuid).Consistency(gocql.One).Scan(&idOperacao, &nomeFundo, &nomeArquivo, &nomeCedente, &valorTransferencia, &valorTed, &situacao); err != nil {
		return nil, err
	}

	return &Operacao{idOperacao, nomeFundo, nomeArquivo,
		nomeCedente, valorTransferencia, valorTed, situacao}, nil
}
