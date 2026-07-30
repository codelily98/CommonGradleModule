package com.togate.framework.web.autoconfigure;

import com.togate.framework.core.error
    .TogateErrorCode;
import com.togate.framework.core.error
    .TogateException;
import com.togate.framework.web.response
    .TogateResponse;
import com.togate.framework.web.response
    .TogateResponseFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation
    .ExceptionHandler;
import org.springframework.web.bind.annotation
    .RestControllerAdvice;

@RestControllerAdvice
public class TogateExceptionHandler {

    private final TogateResponseFactory responseFactory;

    public TogateExceptionHandler(
        TogateResponseFactory responseFactory
    ) {
        this.responseFactory = responseFactory;
    }

    @ExceptionHandler(TogateException.class)
    public ResponseEntity<TogateResponse<Void>>
        handleTogateException(
            TogateException exception
        ) {

        var errorCode = exception.getErrorCode();

        var response = responseFactory.failure(
            errorCode,
            exception.getMessage(),
            exception.getDetails()
        );

        return ResponseEntity
            .status(errorCode.httpStatus())
            .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<TogateResponse<Void>>
        handleUnexpectedException(
            Exception exception
        ) {

        var errorCode =
            TogateErrorCode.INTERNAL_SERVER_ERROR;

        var response = responseFactory.failure(
            errorCode,
            errorCode.message(),
            java.util.Map.of()
        );

        return ResponseEntity
            .status(errorCode.httpStatus())
            .body(response);
    }
}