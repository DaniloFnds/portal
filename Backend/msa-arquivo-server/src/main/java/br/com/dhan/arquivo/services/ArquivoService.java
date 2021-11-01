package br.com.dhan.arquivo.services;

import br.com.dhan.arquivo.models.DadosArquivoDto;
import br.com.dhan.entity.ArquivoEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ArquivoService {

    void salvar(final UUID idArquivoImportacao, MultipartFile file);
}
