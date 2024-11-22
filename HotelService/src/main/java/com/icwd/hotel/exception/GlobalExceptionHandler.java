package com.icwd.hotel.exception;


import com.icwd.hotel.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String message= ex.getMessage();
        ApiResponse response = ApiResponse.builder()
                .message(message)
                .success(true)
                .status(HttpStatus.NOT_FOUND)
                .build();

        //passing using constructor so we are using a new keyword
        //in controller we are passing using a static method called status
        //
        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
