package br.com.dhan.importacao.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ArquivoService {

    void salvar(final UUID idArquivoImportacao, MultipartFile file);
}
