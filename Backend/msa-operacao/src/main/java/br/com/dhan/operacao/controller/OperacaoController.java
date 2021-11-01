package br.com.dhan.operacao.controller;

import br.com.dhan.entity.OperacaoRecebivel;
import br.com.dhan.repositories.OperacaoRecebivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/operacao")
@CrossOrigin("*")
public class OperacaoController {

    private final OperacaoRecebivelRepository operacaoRecebivelRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public OperacaoController(OperacaoRecebivelRepository operacaoRecebivelRepository, RestTemplate restTemplate) {
        this.operacaoRecebivelRepository = operacaoRecebivelRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<List<OperacaoRecebivel>> consultarOperacoes() {
        List<OperacaoRecebivel> operacaoRecebivels = this.operacaoRecebivelRepository.findAll();


        ResponseEntity<String> forEntity = this.restTemplate.getForEntity("http://importacao-arquivo-service/api/v1/importacoes/arquivos", String.class);
        System.out.println(forEntity);

        if (operacaoRecebivels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(operacaoRecebivels, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OperacaoRecebivel> findOperacaoById(@PathVariable("id") final UUID id) {
        return this.operacaoRecebivelRepository.findById(id)
                .map(recebivel -> new ResponseEntity<>(recebivel, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));

    }

}
