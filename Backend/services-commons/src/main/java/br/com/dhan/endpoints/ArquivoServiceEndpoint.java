package br.com.dhan.endpoints;

import br.com.dhan.configurer.FeignConfiguer;
import br.com.dhan.endpoints.models.RetornoInvalido;
import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

//TODO implementar hystrix com fallback

@FeignClient(name = "arquivo-service", configuration = FeignConfiguer.class, fallbackFactory = ArquivoServiceEndpoint.ArquivoServiceFallBackFactory.class)
public interface ArquivoServiceEndpoint {

    @PostMapping(path = "${ARQUIVO_SERVICE_END_POINT}/{idArquivoImportacao}"
            , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Enviar para o servidor de arquivo o binario do arquivo, para ser armazenado"
            , parameters = {
            @Parameter(name = "idArquivoImportacao", description = "id da importacao de arquivo, para servir como referencia"),
            @Parameter(name = "file", description = "part file do arquivo que será feito a importacao")})
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Quando é salvo com sucesso", content = @Content),
            @ApiResponse(responseCode = "500", description = "Ocorrer algum problema ao salvar o arquivo")})
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> notificarNovoArquivo(@PathVariable("idArquivoImportacao") UUID idArquivoImportacao
            , @RequestPart("file") MultipartFile file);


    @Component
    class ArquivoServiceFallBackFactory implements FallbackFactory<ArquivoServiceEndpoint> {
        @Override
        public ArquivoServiceEndpoint create(Throwable cause) {
            return (idArquivoImportacao, file)
                    -> ResponseEntity.internalServerError().body(new RetornoInvalido("ERRO_AO_SALVAR"));
        }
    }
}
