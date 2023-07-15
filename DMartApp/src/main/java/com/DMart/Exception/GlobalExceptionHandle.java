package com.DMart.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> exceptionsHandle(Exception e, WebRequest web){
        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setMessage(e.getMessage());
        errorDetails.setTimeStamp(LocalDateTime.now());
        errorDetails.setDescription(web.getDescription(true));
        return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> noHandlerFoundException(NoHandlerFoundException e, WebRequest web){
        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setMessage(e.getMessage());
        errorDetails.setTimeStamp(LocalDateTime.now());
        errorDetails.setDescription(web.getDescription(true));
        return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> methodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest web){
        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setMessage(e.getMessage());
        errorDetails.setTimeStamp(LocalDateTime.now());
        errorDetails.setDescription(web.getDescription(true));
        return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(StockException.class)
    public ResponseEntity<MyErrorDetails> stockExceptionsHandle(StockException e, WebRequest web){
        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setMessage(e.getMessage());
        errorDetails.setTimeStamp(LocalDateTime.now());
        errorDetails.setDescription(web.getDescription(true));
        return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(LocationException.class)
    public ResponseEntity<MyErrorDetails> StoreLocationExceptionHandle(LocationException e, WebRequest web){
        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setMessage(e.getMessage());
        errorDetails.setTimeStamp(LocalDateTime.now());
        errorDetails.setDescription(web.getDescription(true));
        return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_GATEWAY);
    }
    @ExceptionHandler(StockMovementException.class)
    public ResponseEntity<MyErrorDetails> StockMovementExceptionHandle(StockMovementException e, WebRequest web){
        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setMessage(e.getMessage());
        errorDetails.setTimeStamp(LocalDateTime.now());
        errorDetails.setDescription(web.getDescription(true));
        return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_GATEWAY);
    }

}
