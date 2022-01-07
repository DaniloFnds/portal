package br.com.dhan.importacaoarquivo.adapter.jpa;

import br.com.dhan.importacaoarquivo.domain.ImportacaoArquivo;
import br.com.dhan.importacaoarquivo.domain.dto.ImportacaoArquivoCreateRequest;
import br.com.dhan.importacaoarquivo.domain.port.ImportacaoArquivoPort;
import org.springframework.stereotype.Service;

@Service
public class ImportacaoArquivoDataAdapter implements ImportacaoArquivoPort {

    @Override
    public ImportacaoArquivo criar(ImportacaoArquivoCreateRequest request) {
        return null;
    }
}
