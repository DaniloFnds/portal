package br.com.dhan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table("importacao_arquivo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportacaoArquivoEntity implements Serializable {

    @PrimaryKey
    private UUID id;

    @Column("nome_arquivo")
    private String nomeArquivo;

    @Column("status")
    private String status;

}
