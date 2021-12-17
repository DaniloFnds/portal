package br.com.dhan.arquivo.controller;

import br.com.dhan.arquivo.models.DadosArquivoDto;
import br.com.dhan.arquivo.services.ArquivoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/arquivos", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@CrossOrigin("*")
@Slf4j
public class ArquivoServiceController {

    private final ArquivoService arquivoService;

    @Autowired
    public ArquivoServiceController(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

    @Operation(description = "Guardar o arquivo com o ID da importacao")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Quando é salvo com sucesso", content = @Content)})
    @PostMapping(value = "/{idArquivoImportado}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void gravarNovoArquivo(@PathVariable("idArquivoImportado") final UUID idArquivoImportado, @RequestPart("file") MultipartFile file) {
        this.arquivoService.salvar(idArquivoImportado, file);
    }
}
