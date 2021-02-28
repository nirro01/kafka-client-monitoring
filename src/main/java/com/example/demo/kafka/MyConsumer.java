package com.example.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    @KafkaListener(topics = "topic1", containerFactory = "kafkaListenerContainerFactory1")
    public void listenTopic1(String message) {
        System.out.println("Received Message in group foo: " + message);
    }

    @KafkaListener(topics = "topic2", containerFactory = "kafkaListenerContainerFactory2")
    public void listenTopic2(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
