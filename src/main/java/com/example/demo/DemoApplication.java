package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {
	@Autowired
	KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Scheduled(fixedDelay = 5000L)
	public void test() {
		kafkaListenerEndpointRegistry.getListenerContainerIds();
		//kafkaListenerEndpointRegistry.getListenerContainer();
		System.out.println("test");
	}


}
