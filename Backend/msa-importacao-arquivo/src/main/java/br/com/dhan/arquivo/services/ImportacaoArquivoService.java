package br.com.dhan.arquivo.services;

import br.com.dhan.arquivo.models.ImportacaoArquivoDto;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

public interface ImportacaoArquivoService {

    List<ImportacaoArquivoDto> loadImportacoesArquivo();

    Optional<List<ImportacaoArquivoDto>> criarArquivo(final String fundoId, final List<MultipartFile> arquivos);
}
