package br.com.dhan;

import br.com.dhan.configurer.RootConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
        (exclude = {DataSourceAutoConfiguration.class})
@Import({RootConfigurer.class})
@EnableEurekaClient
@EnableFeignClients
public class ImportacaoArquivoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportacaoArquivoApplication.class, args);
    }

}
