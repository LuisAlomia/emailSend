package com.flav.emailSend.user.domain.constans;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum UserErrorCatalog {

    USER_NOT_FOUNT("USER-001", HttpStatusCode.valueOf(404) ,HttpStatus.NOT_FOUND ,"user not found"),
    EMAIL_EXIST("USER-002", HttpStatusCode.valueOf(400) ,HttpStatus.BAD_REQUEST, "email already exist");

    private final String code;
    private final HttpStatus status;
    private final HttpStatusCode statusCode;
    private final String message;

    UserErrorCatalog(String code, HttpStatusCode statusCode, HttpStatus status, String message) {
        this.code = code;
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }
}
