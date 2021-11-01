package br.com.dhan.configurer;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PropertiesResolver {

    @Value("${STORAGE_PATH_IMPORTACAO_ARQUIVO}")
    private String PATH_STORAGE_FILE_IMPORTACAO;
}
