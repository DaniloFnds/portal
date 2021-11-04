package br.com.dhan.importacao.services;

import br.com.dhan.importacao.models.ImportacaoArquivoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ImportacaoArquivoService {

    List<ImportacaoArquivoDto> loadImportacoesArquivo();

    Optional<List<ImportacaoArquivoDto>> criarArquivo(final String fundoId, final List<MultipartFile> arquivos);
}
