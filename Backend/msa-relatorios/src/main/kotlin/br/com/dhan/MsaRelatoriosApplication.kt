package br.com.dhan

import br.com.dhan.configurer.RootConfigurer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Import

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@Import(RootConfigurer::class)
@EnableEurekaClient
class MsaRelatoriosApplication

fun main(args: Array<String>) {
    runApplication<MsaRelatoriosApplication>(*args)
}
