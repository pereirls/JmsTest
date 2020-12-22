package com.example.jmstest.listeners;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

import com.example.jmstest.domains.Messages;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service

public class Listener {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @JmsListener(destination = "bitz-pix-webhooks_bitz-pix-keys")
    public void orderValidator(String message) throws JsonProcessingException {
           Messages messages1 =  objectMapper.readValue(message, Messages.class);

        LOGGER.log(Level.ALL, messages1.getDescription());
        System.out.println(messages1.getDescription());
    }
}
