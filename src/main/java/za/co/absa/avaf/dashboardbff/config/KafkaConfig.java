package za.co.absa.avaf.dashboardbff.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaConsumerFactoryCustomizer;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import za.co.absa.avaf.schema.payout.Remittance;


@Configuration
@AllArgsConstructor
public class KafkaConfig {

    private final ObjectMapper objectMapper;
    private final KafkaProperties properties;
    private final ObjectProvider<DefaultKafkaProducerFactoryCustomizer> producerCustomizers;
    private final ObjectProvider<DefaultKafkaConsumerFactoryCustomizer> consumerCustomizers;

    @Bean
    @Primary
    public KafkaTemplate<String, ?> template() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public KafkaTemplate<String, ?> jsonTemplate() {
        return new KafkaTemplate<>(jsonProducerFactory());
    }

    @Bean
    public KafkaTemplate<String, String> stringTemplate() {
        return new KafkaTemplate<>(stringProducerFactory());
    }

    @Bean
    @Primary
    public ProducerFactory<String, ?> producerFactory() {
        return producerFactory(null);
    }

    @Bean
    public ProducerFactory<String, ?> jsonProducerFactory() {
        return producerFactory(new CustomJsonSerializer());
    }

    @Bean
    public ProducerFactory<String, String> stringProducerFactory() {
        return producerFactory(new StringSerializer());
    }

    @Bean
    @Primary
    public ConsumerFactory<String, ?> consumerFactory() {
        return consumerFactory(null);
    }

    @Bean
    public ConsumerFactory<String, ?> jsonConsumerFactory() {
        return consumerFactory(new CustomJsonDeserializer());
    }

    @Bean
    public ConsumerFactory<String, ?> remittanceConsumerFactory() {
        return consumerFactory(new CustomJsonDeserializer(Remittance.class));
    }

    @Bean
    @Primary
    public ConcurrentKafkaListenerContainerFactory<String, ?> containerFactory(
            final ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
        return containerFactory(consumerFactory(), configurer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ?> jsonContainerFactory(
            final ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
        return containerFactory(jsonConsumerFactory(), configurer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ?> remittanceContainerFactory(
            final ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
        return containerFactory(remittanceConsumerFactory(), configurer);
    }

    private <V> ProducerFactory<String, V> producerFactory(final Serializer serializer) {
        DefaultKafkaProducerFactory factory = new DefaultKafkaProducerFactory<>(
                properties.buildProducerProperties(), new StringSerializer(),
                serializer);
        producerCustomizers.orderedStream().forEach(c -> c.customize(factory));
        return factory;
    }

    private <V> ConsumerFactory<String, V> consumerFactory(final Deserializer deserializer) {
        DefaultKafkaConsumerFactory factory = new DefaultKafkaConsumerFactory<>(
                properties.buildConsumerProperties(), new StringDeserializer(),
                deserializer == null ? null : new ErrorHandlingDeserializer<>(deserializer));
        consumerCustomizers.orderedStream().forEach(c -> c.customize(factory));
        return factory;
    }

    private <V> ConcurrentKafkaListenerContainerFactory<String, V> containerFactory(
            final ConsumerFactory consumerFactory,
            final ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory<>();
        configurer.configure(factory, consumerFactory);
        return factory;
    }

    class CustomJsonSerializer extends JsonSerializer {

        CustomJsonSerializer() {
            super(KafkaConfig.this.objectMapper);
        }
    }

    class CustomJsonDeserializer extends JsonDeserializer {

        CustomJsonDeserializer() {
            this(null);
        }

        CustomJsonDeserializer(final Class<?> type) {
            super(type, KafkaConfig.this.objectMapper);
            addTrustedPackages("*");
        }
    }
}
