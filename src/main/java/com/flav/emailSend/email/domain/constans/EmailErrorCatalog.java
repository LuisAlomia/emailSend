package com.flav.emailSend.email.domain.constans;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum EmailErrorCatalog {
    ERROR_LIST_CUSTOMER_EMAILS("EMAIL_001", HttpStatusCode.valueOf(400), HttpStatus.NOT_FOUND, "Error list customer emails is empty");

    private final String code;
    private final HttpStatusCode statusCode;
    private final HttpStatus status;
    private final String message;

    EmailErrorCatalog(String code, HttpStatusCode statusCode, HttpStatus status, String message) {
        this.code = code;
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }
}
