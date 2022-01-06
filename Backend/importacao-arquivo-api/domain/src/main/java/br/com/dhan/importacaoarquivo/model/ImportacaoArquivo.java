package br.com.dhan.importacaoarquivo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
public class ImportacaoArquivo {

    private UUID id;

    private String nomeArquivo;
}
