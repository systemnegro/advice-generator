package com.systemnegro.advice.adapters.out.exception;

public class ApiCommunicationException extends RuntimeException {
    public ApiCommunicationException() {
        super("Erro de comunicação com a API");
    }
}
