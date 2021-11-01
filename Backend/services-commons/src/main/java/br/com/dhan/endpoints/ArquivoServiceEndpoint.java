package br.com.dhan.endpoints;

import br.com.dhan.configurer.FeignConfiguer;
import br.com.dhan.endpoints.models.DadosArquivoService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.util.UUID;

//TODO implementar hystrix com fallback
@FeignClient(name = "arquivo-service", configuration = FeignConfiguer.class)
public interface ArquivoServiceEndpoint {

    @PostMapping(path = "${ARQUIVO_SERVICE_END_POINT}/{idArquivoImportacao}"
            , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<String> notificarNovoArquivo(@PathVariable("idArquivoImportacao") UUID idArquivoImportacao, @RequestPart("file") MultipartFile file);

}
