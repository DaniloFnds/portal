package br.com.dhan;

import br.com.dhan.configurer.RootConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
        (exclude = {DataSourceAutoConfiguration.class})
@Import({RootConfigurer.class})
@EnableEurekaClient
public class ArquivoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArquivoServiceApplication.class, args);
    }

}
