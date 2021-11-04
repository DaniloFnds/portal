package br.com.dhan.importacao.services.impl;

import br.com.dhan.importacao.services.SendEventValidacaoArquivo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SendEventValidacaoArquivoImpl implements SendEventValidacaoArquivo {

    @Override
    public void send(UUID idArquivoValidacao) {

    }
}
