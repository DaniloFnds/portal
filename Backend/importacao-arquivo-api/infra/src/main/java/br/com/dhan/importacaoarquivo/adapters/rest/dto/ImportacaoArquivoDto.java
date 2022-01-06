package br.com.dhan.importacaoarquivo.adapters.rest.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ImportacaoArquivoDto {

    private UUID id;
    private String nomeArquivo;
}
