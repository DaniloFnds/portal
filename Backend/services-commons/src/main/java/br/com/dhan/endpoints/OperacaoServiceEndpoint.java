package br.com.dhan.endpoints;

import br.com.dhan.configurer.FeignConfiguer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "operacao-service",
        url = "http://localhost:${OPERACAO_SERVICE_PORT}"
        , configuration = FeignConfiguer.class)
public interface OperacaoServiceEndpoint {


    @GetMapping(path = "/health")
    ResponseEntity<String> health();

}
