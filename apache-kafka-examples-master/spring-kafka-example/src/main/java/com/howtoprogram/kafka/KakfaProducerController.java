package com.howtoprogram.kafka;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KakfaProducerController {

    private final Producer producer;

    private static Log log = LogFactory.getLog("producer");
    
    @Autowired
    KakfaProducerController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
    	log.info("RequestParam message in get mapping:" + message);
        this.producer.sendMessage(message);
    }
    
    @PostMapping(value = "/publish")
    public void sendMsgeessageToKafkaTopic(@RequestParam("message") String message) {
    	
    	log.info("RequestParam message in post mapping:" + message);
        this.producer.sendMessage(message);
    }
}
