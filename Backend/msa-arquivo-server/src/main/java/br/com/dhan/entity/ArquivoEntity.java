package br.com.dhan.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table("arquivo_upload")
@Data
@NoArgsConstructor
public class ArquivoEntity implements Serializable {

    @PrimaryKey
    private UUID id;

    @Column("localizacao_arquivo")
    private String localizacaoArquivo;

    @Column("nome_arquivo")
    private String nomeArquivo;

    @Column("id_arquivo_importacao")
    private UUID idArquivoImportacao;

    public ArquivoEntity(UUID id, String localizacaoArquivo, String nomeArquivo, UUID idArquivoImportacao) {
        this.id = id;
        this.localizacaoArquivo = localizacaoArquivo;
        this.nomeArquivo = nomeArquivo;
        this.idArquivoImportacao = idArquivoImportacao;
    }
}
