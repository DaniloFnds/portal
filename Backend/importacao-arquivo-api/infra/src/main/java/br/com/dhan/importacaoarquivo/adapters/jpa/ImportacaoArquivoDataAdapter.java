package br.com.dhan.importacaoarquivo.adapters.jpa;

import br.com.dhan.importacaoarquivo.adapters.jpa.repository.ImportacaoArquivoRepository;
import br.com.dhan.importacaoarquivo.model.ImportacaoArquivo;
import br.com.dhan.importacaoarquivo.port.ImportacaoArquivoPort;
import br.com.dhan.importacaoarquivo.usercase.ImportacaoArquivoCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImportacaoArquivoDataAdapter implements ImportacaoArquivoPort {

    private final ImportacaoArquivoRepository importacaoArquivoRepository;

    @Override
    public ImportacaoArquivo create(ImportacaoArquivoCreate importacaoArquivoCreate) {
        return null;
    }
}
