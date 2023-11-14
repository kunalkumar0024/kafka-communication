package com.publisher.controller;

import com.publisher.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PublisherController {

    @Autowired
    private KafkaService kafkaService;

    private Logger logger = LoggerFactory.getLogger(PublisherController.class);
    @PostMapping("/send")
    public ResponseEntity<?> sendRequest(){
     for(int i =1; i<=5; i++) {
         String data = String.valueOf(Math.random());
         this.kafkaService.sendRequest(data);
         logger.info("Request published with request body " + data);
     }
        return new ResponseEntity<>("Request Sent",HttpStatus.OK);
    }

}
