package com.gyawalirajiv.kafkaproducerconsumer.controller;

import com.gyawalirajiv.kafkaproducerconsumer.domain.Message;
import com.gyawalirajiv.kafkaproducerconsumer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    @Autowired
    ProducerService producerService;

    @PostMapping
    public void messageToKafka(@RequestBody Message message){
        producerService.sendMessage(message);
    }

}
