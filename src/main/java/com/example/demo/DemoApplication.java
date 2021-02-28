package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {
	@Autowired
	KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



}
