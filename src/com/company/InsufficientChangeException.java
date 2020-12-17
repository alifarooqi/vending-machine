package com.company;

public class InsufficientChangeException extends RuntimeException {
    private String message;

    public InsufficientChangeException(String msg){
        this.message = msg;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
