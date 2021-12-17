package br.com.dhan.arquivo.services.impl;

import br.com.dhan.arquivo.models.ImportacaoArquivoDto;
import br.com.dhan.arquivo.services.ImportacaoArquivoService;
import br.com.dhan.arquivo.services.UploadHandlerService;
import br.com.dhan.endpoints.ArquivoServiceEndpoint;
import br.com.dhan.endpoints.models.DadosArquivoService;
import br.com.dhan.entity.ImportacaoArquivoEntity;
import br.com.dhan.repositories.ImportacaoArquivoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import reactor.core.publisher.Flux;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
                                    UUID.randomUUID(), mf.getOriginalFilename()
                            ));

                            this.uploadHandlerService.upload(arquivoEntity.getId(), mf);
                            return new ModelMapper().map(arquivoEntity, ImportacaoArquivoDto.class);
                        }).collect(Collectors.toList())
        );
    }
}
