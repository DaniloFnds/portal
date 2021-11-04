package br.com.dhan.importacao.services.impl;

import br.com.dhan.importacao.models.ImportacaoArquivoDto;
import br.com.dhan.importacao.services.ImportacaoArquivoService;
import br.com.dhan.importacao.services.UploadHandlerService;
import br.com.dhan.entity.ImportacaoArquivoEntity;
import br.com.dhan.repositories.ImportacaoArquivoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ImportacaoArquivoServiceImpl implements ImportacaoArquivoService {

    private final ImportacaoArquivoRepository arquivoRepository;
    private final UploadHandlerService uploadHandlerService;


    @Override
    public List<ImportacaoArquivoDto> loadImportacoesArquivo() {
        ModelMapper modelMapper = new ModelMapper();
        return this.arquivoRepository.findAll()
                .stream()
                .map(imp -> modelMapper.map(imp, ImportacaoArquivoDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public Optional<List<ImportacaoArquivoDto>> criarArquivo(String fundoId, List<MultipartFile> arquivos) {
        return Optional.of(
                arquivos.stream()
                        .map(mf -> {
                            ImportacaoArquivoEntity arquivoEntity = arquivoRepository.save(new ImportacaoArquivoEntity(
                                    UUID.randomUUID(), mf.getOriginalFilename(), "AGUARDANDO"
                            ));

                            this.uploadHandlerService.upload(arquivoEntity.getId(), mf);
                            return new ModelMapper().map(arquivoEntity, ImportacaoArquivoDto.class);
                        }).collect(Collectors.toList())
        );
    }
}
