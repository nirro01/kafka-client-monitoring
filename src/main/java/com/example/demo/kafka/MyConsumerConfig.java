package com.example.demo.kafka;

import io.micrometer.core.instrument.MeterRegistry;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.MicrometerConsumerListener;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class MyConsumerConfig {

    @Bean
    @Primary
    public ConsumerFactory<String, String> consumerFactory1(MeterRegistry meterRegistry) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        ConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(props);
        //consumerFactory.addListener(new MicrometerConsumerListener<>(meterRegistry));
        return consumerFactory;
    }

    @Bean
    @Primary
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory1(MeterRegistry meterRegistry) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory1(meterRegistry));
        return factory;
    }
}