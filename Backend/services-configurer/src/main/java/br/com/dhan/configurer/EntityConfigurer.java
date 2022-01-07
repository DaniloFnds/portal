package br.com.dhan.configurer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan(basePackages = "br.com.dhan.entity")
@Configuration
@EnableCassandraRepositories(basePackages = "br.com.dhan.repositories")
@EnableTransactionManagement
@Slf4j
public class EntityConfigurer {
    public EntityConfigurer() {
        log.info("Class Loading {}", this.getClass());
    }
}
