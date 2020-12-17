package com.company;

public class KeyNotFoundException extends RuntimeException {
    private String message;

    public KeyNotFoundException(String msg){
        this.message = msg;
    }

    @Override
    public String getMessage(){
        return this.message;
    }

}
