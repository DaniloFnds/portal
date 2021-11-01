package br.com.dhan.arquivo.services.impl;

import br.com.dhan.arquivo.models.DadosArquivoDto;
import br.com.dhan.arquivo.services.ArquivoService;
import br.com.dhan.configurer.PropertiesResolver;
import br.com.dhan.entity.ArquivoEntity;
import br.com.dhan.repositories.ArquivoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ArquivoServiceImpl implements ArquivoService {

    private final ArquivoRepository arquivoRepository;
    private final PropertiesResolver propertiesResolver;

    @Override
    public void salvar(final UUID idArquivoImportacao, final MultipartFile file) {
        String path = construirPasta(idArquivoImportacao);
        depositarArquivo(path, file);
        this.arquivoRepository.save(
                new ArquivoEntity(
                        UUID.randomUUID(), path, file.getOriginalFilename(), idArquivoImportacao
                )
        );
    }

    private void depositarArquivo(String path, MultipartFile file) {
        try (FileOutputStream fios = new FileOutputStream(new File(path, Optional.ofNullable(file.getOriginalFilename()).orElse(file.getName())))) {
            IOUtils.write(file.getBytes(), fios);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    private String construirPasta(UUID idArquivoImportacao) {
        String pathStorage = this.propertiesResolver.getPATH_STORAGE_FILE_IMPORTACAO();
        File file = new File(pathStorage, idArquivoImportacao.toString());
        file.mkdirs();
        return file.getAbsolutePath();
    }
}
