package com.flav.emailSend.email.api.controllerExceptions;

import com.flav.emailSend.communs.ErrorResponse;
import com.flav.emailSend.email.domain.constans.EmailErrorCatalog;
import com.flav.emailSend.email.domain.exception.EmailException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class EmailControllerException {

    @ExceptionHandler(EmailException.class)
    ResponseEntity<ErrorResponse> handleError() {
        return ResponseEntity
                .status(EmailErrorCatalog.ERROR_LIST_CUSTOMER_EMAILS.getStatus().value())
                .body(ErrorResponse
                        .builder()
                        .code(EmailErrorCatalog.ERROR_LIST_CUSTOMER_EMAILS.getCode())
                        .statusCode(EmailErrorCatalog.ERROR_LIST_CUSTOMER_EMAILS.getStatus().value())
                        .status(EmailErrorCatalog.ERROR_LIST_CUSTOMER_EMAILS.getStatus())
                        .message(EmailErrorCatalog.ERROR_LIST_CUSTOMER_EMAILS.getMessage())
                        .timeStamp(LocalDateTime.now())
                        .build());
    }

}
