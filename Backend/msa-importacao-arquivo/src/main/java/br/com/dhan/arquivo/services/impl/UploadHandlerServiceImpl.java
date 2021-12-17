package br.com.dhan.arquivo.services.impl;

import br.com.dhan.arquivo.models.ImportacaoArquivoDto;
import br.com.dhan.arquivo.services.UploadHandlerService;
import br.com.dhan.endpoints.ArquivoServiceEndpoint;
import lombok.RequiredArgsConstructor;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadHandlerServiceImpl implements UploadHandlerService {

    private final ArquivoServiceEndpoint arquivoServiceEndpoint;

    //TODO tratar erros para notificar a importacao de arquivo, q o arquivo deu erro ao fazer upload
    @Async
    public void upload(final UUID idArquivoImportacao, MultipartFile file) {
        /*DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem(
                "arquivo", MediaType.TEXT_PLAIN_VALUE,
                true, mf.getOriginalFilename()
        );
        try (OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(mf.getInputStream(), os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }*/
        this.arquivoServiceEndpoint.notificarNovoArquivo(idArquivoImportacao, file);
    }
}
