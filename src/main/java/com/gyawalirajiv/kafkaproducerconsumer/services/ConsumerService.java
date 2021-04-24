package com.gyawalirajiv.kafkaproducerconsumer.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyawalirajiv.kafkaproducerconsumer.domain.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ConsumerService {

    @Value("${message.topic}")
    @KafkaListener(topics = "${message.topic}", groupId = "group_id")
    public void consumeMessage(String stringMessage) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Message message = objectMapper.readValue(stringMessage, Message.class);
            System.out.println(message);
//            System.out.println("It took " + (Instant.now().getEpochSecond() - message.getCreationTime().getEpochSecond()) + "to deliver this message.");
        } catch (JsonProcessingException e) {}
    }

}
