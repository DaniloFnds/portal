package domain

type Operacao struct {
	Id                 string  `json:"id,omitempty"`
	NomeFundo          string  `json:"nomeFundo,omitempty"`
	NomeArquivo        string  `json:"nomeArquivo,omitempty"`
	NomeCedente        string  `json:"nomeCedente,omitempty"`
	ValorTransferencia float64 `json:"valorTransferencia,omitempty"`
	ValorTed           float64 `json:"valorTed,omitempty"`
	Situacao           string  `json:"situacao,omitempty"`
}
