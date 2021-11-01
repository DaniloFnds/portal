package br.com.dhan.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Table("operacao_recebivel")
@Getter @Setter
public class OperacaoRecebivel implements Serializable {

    @PrimaryKey
    private UUID id;

    private String nomeFundo;

    private String nomeArquivo;

    private String nomeCedente;

    private BigDecimal valorTransferencia;

    private BigDecimal valorTed;

    private String situacao;

}
