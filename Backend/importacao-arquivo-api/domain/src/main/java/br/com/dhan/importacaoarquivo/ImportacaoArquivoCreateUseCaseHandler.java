package br.com.dhan.importacaoarquivo;

import br.com.dhan.importacaoarquivo.common.DomainComponent;
import br.com.dhan.importacaoarquivo.common.UseCaseHandler;
import br.com.dhan.importacaoarquivo.model.ImportacaoArquivo;
import br.com.dhan.importacaoarquivo.usercase.ImportacaoArquivoCreate;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class ImportacaoArquivoCreateUseCaseHandler implements UseCaseHandler<ImportacaoArquivo, ImportacaoArquivoCreate> {
    @Override
    public ImportacaoArquivo handler(ImportacaoArquivoCreate input) {
        return null;
    }
}
