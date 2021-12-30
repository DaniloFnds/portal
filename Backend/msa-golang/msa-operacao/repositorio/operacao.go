package repositorio

import (
	"errors"
	"github.com/gocql/gocql"
	"msa-operacao/domain"
)

func GetOne(session *gocql.Session, id string) (*domain.Operacao, error) {

	var idOperacao string
	var nomeFundo string
	var nomeArquivo string
	var nomeCedente string
	var valorTransferencia float64
	var valorTed float64
	var situacao string

	uuid, err := gocql.ParseUUID(id)
	if err != nil {
		return nil, errors.New("Erro ao converter para UUID")
	}

	if err := session.Query(`SELECT id, nome_fundo, nome_arquivo, nome_cedente, valor_transferencia, valor_ted, situacao FROM operacao_recebivel WHERE id = ?`,
		uuid).Consistency(gocql.One).Scan(&idOperacao, &nomeFundo, &nomeArquivo, &nomeCedente, &valorTransferencia, &valorTed, &situacao); err != nil {
		return nil, err
	}

	return &domain.Operacao{Id: idOperacao, NomeFundo: nomeFundo, NomeArquivo: nomeArquivo,
		NomeCedente: nomeCedente, ValorTransferencia: valorTransferencia, ValorTed: valorTed, Situacao: situacao}, nil
}

func Save(session *gocql.Session, operacao *domain.Operacao) error {
	if operacao.Id != "" {
		existeOperacao, err := GetOne(session, operacao.Id)
		if err != nil {
			return err
		}

		if existeOperacao.NomeArquivo != "" {
			return errors.New("operação passada com ID e já existe uma operacao")
		}
	}

	uuid, err := gocql.RandomUUID()
	if err != nil {
		return err
	}

	err = session.Query(`insert into operacao_recebivel (id, nome_arquivo, nome_cedente, nome_fundo, situacao, valor_ted, valor_transferencia)
					VALUES ( ?, ?, ?, ?, ?, ?, ?)`,
		uuid, operacao.NomeArquivo, operacao.NomeCedente, operacao.NomeFundo, "AGUARDANDO_APROVACAO_CONSULTORIA", operacao.ValorTed, operacao.ValorTransferencia).Exec()

	if err != nil {
		return err
	}

	return nil
}

func FindAll(session *gocql.Session) ([]domain.Operacao, error) {
	scanner := session.Query(`SELECT id, nome_arquivo, nome_cedente, nome_fundo, situacao, valor_ted, valor_transferencia
										FROM operacao_recebivel`).Consistency(gocql.One).Iter().Scanner()

	operacoes := make([]domain.Operacao, 0)

	for scanner.Next() {
		var operacao = domain.Operacao{}
		err := scanner.Scan(&operacao.Id, &operacao.NomeArquivo, &operacao.NomeCedente, &operacao.NomeFundo, &operacao.Situacao, &operacao.ValorTed, &operacao.ValorTransferencia)
		if err != nil {
			return nil, err
		}
		operacoes = append(operacoes, operacao)
	}

	if len(operacoes) == 0 {
		return nil, nil
	}

	return operacoes, nil

}
