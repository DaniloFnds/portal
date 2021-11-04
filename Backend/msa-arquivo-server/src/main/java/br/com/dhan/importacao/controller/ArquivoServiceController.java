package br.com.dhan.importacao.controller;

import br.com.dhan.importacao.services.ArquivoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/arquivos", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@CrossOrigin("*")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ArquivoServiceController {

    private final ArquivoService arquivoService;

    @Operation(description = "Guardar o arquivo com o ID da importacao")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Quando é salvo com sucesso", content = @Content),
            @ApiResponse(responseCode = "500", description = "Ocorrer algum problema ao salvar o arquivo")})
    @PostMapping(value = "/{idArquivoImportado}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> notificarNovoArquivo(@PathVariable("idArquivoImportado") final UUID idArquivoImportado
            , @RequestPart("file") MultipartFile file) {
        this.arquivoService.salvar(idArquivoImportado, file);
        return ResponseEntity.ok().build();
    }
}
