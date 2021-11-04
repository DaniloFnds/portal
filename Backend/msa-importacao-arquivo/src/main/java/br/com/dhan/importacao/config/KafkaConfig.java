package br.com.dhan.importacao.config;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.serialization.UUIDSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;
import java.util.UUID;

@Configuration
public class KafkaConfig {

    @Value("${KAFKA_SERVER}")
    private String kafkaBroker;


    @Bean
    public KafkaTemplate<String, UUID> kafkaTemplate() {
        return new KafkaTemplate<>(producerValidacaoFactory());
    }

    @Bean
    public ProducerFactory<String, UUID> producerValidacaoFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> properties = Maps.newHashMap();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.kafkaBroker);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, UUIDSerializer.class);
        // introduce a delay on the send to allow more messages to accumulate
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        return properties;
    }


}
