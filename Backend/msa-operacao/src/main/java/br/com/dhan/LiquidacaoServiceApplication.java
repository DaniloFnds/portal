package br.com.dhan;

import br.com.dhan.configurer.RootConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
        (exclude = {DataSourceAutoConfiguration.class})
@Import({RootConfigurer.class})
public class LiquidacaoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiquidacaoServiceApplication.class, args);
    }

}
