package edu.fra.uas.service;

import org.springframework.stereotype.Component;

@Component  // Klasse wird zum Bean, beim Start wird ein Instanz von Spring angelegt und verwaltet
            // kann überall verwendet werden, wenn durch Dependency Injection bereitgestellt 
public class MessageService {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
