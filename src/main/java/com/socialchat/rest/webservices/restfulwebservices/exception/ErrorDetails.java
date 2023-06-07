package com.socialchat.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
    //timestamp
    //error-details
    //message
    private LocalDateTime timestamp;
    private String message;
    private String errordetails;

    public ErrorDetails(LocalDateTime timestamp, String message, String errordetails) {
        this.timestamp = timestamp;
        this.message = message;
        this.errordetails = errordetails;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getErrordetails() {
        return errordetails;
    }
}
