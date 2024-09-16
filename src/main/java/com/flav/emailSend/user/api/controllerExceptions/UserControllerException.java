package com.flav.emailSend.user.api.controllerExceptions;

import com.flav.emailSend.communs.ErrorResponse;
import com.flav.emailSend.user.domain.constans.UserErrorCatalog;
import com.flav.emailSend.user.domain.exception.UserExist;
import com.flav.emailSend.user.domain.exception.UserNotFount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class UserControllerException {

    @ExceptionHandler(UserNotFount.class)
    public ResponseEntity<ErrorResponse> handleError() {
        return ResponseEntity
                .status(UserErrorCatalog.USER_NOT_FOUNT.getStatusCode().value())
                .body(ErrorResponse
                        .builder()
                        .code(UserErrorCatalog.USER_NOT_FOUNT.getCode())
                        .statusCode(UserErrorCatalog.USER_NOT_FOUNT.getStatusCode().value())
                        .status(UserErrorCatalog.USER_NOT_FOUNT.getStatus())
                        .message(UserErrorCatalog.USER_NOT_FOUNT.getMessage())
                        .timeStamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler(UserExist.class)
    public ResponseEntity<ErrorResponse> handlerError() {
        return ResponseEntity
                .status(UserErrorCatalog.EMAIL_EXIST.getStatusCode().value())
                .body(ErrorResponse
                        .builder()
                        .code(UserErrorCatalog.EMAIL_EXIST.getCode())
                        .statusCode(UserErrorCatalog.EMAIL_EXIST.getStatusCode().value())
                        .status(UserErrorCatalog.EMAIL_EXIST.getStatus())
                        .message(UserErrorCatalog.EMAIL_EXIST.getMessage())
                        .timeStamp(LocalDateTime.now())
                        .build());
    }
}
