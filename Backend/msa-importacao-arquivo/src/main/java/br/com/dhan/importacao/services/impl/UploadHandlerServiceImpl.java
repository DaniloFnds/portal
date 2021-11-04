package br.com.dhan.importacao.services.impl;

import br.com.dhan.entity.ImportacaoArquivoEntity;
import br.com.dhan.feign.endpoints.ArquivoServiceEndpoint;
import br.com.dhan.feign.models.RetornoInvalido;
import br.com.dhan.importacao.services.UploadHandlerService;
import br.com.dhan.repositories.ImportacaoArquivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadHandlerServiceImpl implements UploadHandlerService {

    private final ArquivoServiceEndpoint arquivoServiceEndpoint;
    private final ImportacaoArquivoRepository importacaoArquivoRepository;

    @Async
    public void upload(final UUID idArquivoImportacao, MultipartFile file) {
        try {
            ResponseEntity<?> responseEntity = this.arquivoServiceEndpoint.notificarNovoArquivo(idArquivoImportacao, file);
            if (HttpStatus.INTERNAL_SERVER_ERROR.equals(responseEntity.getStatusCode())) {
                Object body = responseEntity.getBody();
                if (body instanceof RetornoInvalido retornoInvalido) {
                    if (!"TENTAR_NOVAMENTE".equals(retornoInvalido.motivo())) {
                        final Optional<ImportacaoArquivoEntity> importacaoArquivo = importacaoArquivoRepository.findById(idArquivoImportacao);
                        importacaoArquivo.ifPresent(i -> {
                            i.setStatus("OCORREU_ERRO_AO_SALVAR_ARQUIVO");
                            importacaoArquivoRepository.save(i);
                        });
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
