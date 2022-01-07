package br.com.dhan.importacaoarquivo.domain.port;

import br.com.dhan.importacaoarquivo.domain.ImportacaoArquivo;
import br.com.dhan.importacaoarquivo.domain.dto.ImportacaoArquivoCreateRequest;

public interface ImportacaoArquivoPort {

    ImportacaoArquivo criar(ImportacaoArquivoCreateRequest request);
}
