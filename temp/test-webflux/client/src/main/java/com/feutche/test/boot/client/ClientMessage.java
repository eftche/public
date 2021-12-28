package com.feutche.test.boot.client;

public class ClientMessage {
    private String message;

    public ClientMessage() {
    }

    public ClientMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ClientMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
