package edu.fra.uas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.service.MessageService;

@Component //wird zum Bean
public class BeanController {
    
    @Autowired
    private MessageService messageService;

    public String putMessage(String message) {
        messageService.setMessage(" put messgae: " + message); //setMessage Methode der Klasse MessageService wird aufgerufen
        return messageService.getMessage();
    }

}
