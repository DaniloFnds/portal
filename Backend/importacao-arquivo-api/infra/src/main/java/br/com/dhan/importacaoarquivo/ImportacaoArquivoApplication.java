package br.com.dhan.importacaoarquivo;

import br.com.dhan.importacaoarquivo.common.DomainComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@SpringBootApplication
        (exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})})
@EnableEurekaClient
@EnableFeignClients
public class ImportacaoArquivoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportacaoArquivoApplication.class, args);
    }

}
