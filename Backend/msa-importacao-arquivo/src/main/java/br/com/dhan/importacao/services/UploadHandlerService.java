package br.com.dhan.importacao.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface UploadHandlerService {

    void upload(final UUID idArquivoImportacao, MultipartFile file);
}
