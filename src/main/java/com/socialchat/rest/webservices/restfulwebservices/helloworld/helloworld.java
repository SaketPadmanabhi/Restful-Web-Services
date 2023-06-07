package com.socialchat.rest.webservices.restfulwebservices.helloworld;

public class helloworld {
    private String message;

    public helloworld(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "helloworld{" +
                "message='" + message + '\'' +
                '}';
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
