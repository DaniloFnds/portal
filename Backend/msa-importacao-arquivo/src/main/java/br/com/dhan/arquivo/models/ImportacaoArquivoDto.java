package br.com.dhan.arquivo.models;

import lombok.Data;

import java.util.UUID;

@Data
public class ImportacaoArquivoDto {

    private UUID id;
    private String nomeArquivo;
}
