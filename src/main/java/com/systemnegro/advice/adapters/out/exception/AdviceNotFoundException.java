package com.systemnegro.advice.adapters.out.exception;

public class AdviceNotFoundException extends RuntimeException{
    public AdviceNotFoundException() {
        super("Advice Not Found");
    }
}
