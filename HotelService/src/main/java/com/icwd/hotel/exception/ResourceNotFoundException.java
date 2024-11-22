package com.icwd.hotel.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException()
    {
        super("Resource not found in the database");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
