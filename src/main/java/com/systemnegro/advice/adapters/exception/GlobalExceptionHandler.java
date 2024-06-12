package com.systemnegro.advice.adapters.exception;


import com.systemnegro.advice.adapters.out.exception.AdviceNotFoundException;
import com.systemnegro.advice.adapters.out.exception.ApiCommunicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGlobalException(Exception unexpectedError) {
        String message = "Ops! Ocorreu um erro inesperado.";
        logger.error(message, unexpectedError);
        return ResponseEntity.internalServerError().body(new ApiError(message));
    }

    @ExceptionHandler(ApiCommunicationException.class)
    public ResponseEntity<ApiError> handleApiCommunicationException(ApiCommunicationException httpError) {
        logger.error(httpError.getMessage(), httpError);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ApiError(httpError.getMessage()));
    }

    @ExceptionHandler(AdviceNotFoundException.class)
    public ResponseEntity<ApiError> handleAdviceNotFoundException(AdviceNotFoundException domainError) {
        logger.error(domainError.getMessage(), domainError);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(domainError.getMessage()));
    }

    public record ApiError(String message) {
    }


}
