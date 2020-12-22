package com.example.jmstest.controllers;

import com.example.jmstest.producers.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SendToQueueController {

    @Autowired
    private Producer producer;

    @GetMapping(path = "/send")
    public ResponseEntity<Void> send() {
        producer.sendMessageToOrderFinisher();

        return ResponseEntity.ok().build();
    }

}
