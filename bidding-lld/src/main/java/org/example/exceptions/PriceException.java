package org.example.exceptions;

public class PriceException extends Exception{
    private String message;

    public PriceException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
