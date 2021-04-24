package com.gyawalirajiv.kafkaproducerconsumer.services;

import com.gyawalirajiv.kafkaproducerconsumer.domain.Message;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ProducerService {

    @Value("${message.topic}")
    String topicName;

    @Autowired
    KafkaTemplate<String, Message> kafkaTemplate;

    public void sendMessage(Message message){
//        message.setCreationTime(Instant.now());
        this.kafkaTemplate.send(topicName, message);
    }

}
