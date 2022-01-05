package br.com.dhan.configurer;

import com.datastax.oss.driver.api.core.CqlSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.SessionFactoryFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@Slf4j
public class CassandraConfig extends AbstractCassandraConfiguration {

    public CassandraConfig() {
        log.info("Carregando Cassandra Config");
    }

    @Value("${portal.cassandra.key-space-name}")
    private String keySpaceName;

    @Value("${portal.cassandra.contact-points:localhost}")
    private String contactPoints;

    @Value("${portal.cassandra.local-data-center:datacenter1}")
    private String localDataCenter;

    @Override
    protected String getKeyspaceName() {
        return this.keySpaceName;
    }

    public String getContactPoints() {
        return this.contactPoints;
    }

    @Override
    protected String getLocalDataCenter() {
        return this.localDataCenter;
    }

    @Bean
    @Primary
    public CqlSessionFactoryBean session() {

        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints(getContactPoints());
        session.setKeyspaceName(getKeyspaceName());
        session.setLocalDatacenter(getLocalDataCenter());
        return session;
    }

    @Bean
    @Primary
    public SessionFactoryFactoryBean sessionFactory(CqlSession session, CassandraConverter converter) {
        SessionFactoryFactoryBean sessionFactory = new SessionFactoryFactoryBean();
        sessionFactory.setSession(session);
        sessionFactory.setConverter(converter);
        sessionFactory.setSchemaAction(SchemaAction.NONE);
        return sessionFactory;
    }

    @Bean
    @Primary
    public CassandraMappingContext mappingContext(CqlSession cqlSession) {

        CassandraMappingContext mappingContext = new CassandraMappingContext();
        mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cqlSession));
        return mappingContext;
    }

    @Bean
    @Primary
    public CassandraConverter converter(CassandraMappingContext mappingContext) {
        return new MappingCassandraConverter(mappingContext);
    }

    @Bean
    public CassandraOperations cassandraTemplate(SessionFactory sessionFactory, CassandraConverter converter) {
        return new CassandraTemplate(sessionFactory, converter);
    }

}