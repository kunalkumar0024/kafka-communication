package com.subscriber.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaConfig {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaConfig(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @KafkaListener(topics = "testing-topic", groupId = "group-1")
    public void receiveRequest(String value) {
        System.out.println(value);

//        for(int i = 1; i<=5; i++ ) {
//            String response = "response";
//            this.kafkaTemplate.send("testing-topic", response);
//        }
    }
}
