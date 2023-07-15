package com.DMart.Exception;

public class StockMovementException extends RuntimeException{
    public StockMovementException(String message) {
        super(message);
    }

    public StockMovementException() {
    }
}
