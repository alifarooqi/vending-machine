package com.company;

public class SoldOutException extends RuntimeException {
    private String message;

    public SoldOutException(String msg){
        this.message = msg;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
