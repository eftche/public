package com.feutche.test.boot.server;

public class ServerMessage {
    private String message;

    public ServerMessage(String message) {
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
        return "ServerMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
