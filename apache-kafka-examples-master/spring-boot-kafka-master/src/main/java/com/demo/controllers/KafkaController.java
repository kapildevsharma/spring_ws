package com.demo.controllers;

import com.demo.engine.Producer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    private static Log log = LogFactory.getLog("producer");
    
    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("message") String message) {
    	log.info("RequestParam message in get mapping:" + message);
        this.producer.sendMessage(message);
        return "Message sent to Kafka topic successfully";

    }
    
    @PostMapping(value = "/publish")
    public void sendMsgeessageToKafkaTopic(@RequestParam("message") String message) {
    	
    	log.info("RequestParam message in post mapping:" + message);
        this.producer.sendMessage(message);
    }
}
