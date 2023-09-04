package com.book;

public class InvalidBookException extends Exception {
    public InvalidBookException(String message) {
        super(message);
    }
}