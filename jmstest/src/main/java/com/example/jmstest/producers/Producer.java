package com.example.jmstest.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    private String message = "{\"description\" : \"Works!\"}";

    public void sendMessageToOrderFinisher(){
            jmsTemplate.convertAndSend("bitz-pix-webhooks_bitz-pix-keys", message);
    }

}
