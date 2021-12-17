package br.com.dhan.arquivo.services;

import br.com.dhan.arquivo.models.ImportacaoArquivoDto;
import br.com.dhan.entity.ImportacaoArquivoEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface UploadHandlerService {

    void upload(final UUID idArquivoImportacao, MultipartFile file);
}
