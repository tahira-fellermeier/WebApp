package edu.fra.uas.service;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private String message;

    int count;

    public int increment(int count) {
        count++;
        return count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
