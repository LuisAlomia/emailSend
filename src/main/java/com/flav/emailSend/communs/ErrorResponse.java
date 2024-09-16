package com.flav.emailSend.communs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private String code;
    private int statusCode;
    private HttpStatus status;
    private String message;
    private LocalDateTime timeStamp;
}
