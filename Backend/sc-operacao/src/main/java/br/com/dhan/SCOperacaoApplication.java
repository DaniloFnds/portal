package br.com.dhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar
public class SCOperacaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SCOperacaoApplication.class, args);
    }

}
