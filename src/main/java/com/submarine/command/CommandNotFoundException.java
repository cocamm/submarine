package com.submarine.command;

public class CommandNotFoundException extends RuntimeException {

    public CommandNotFoundException(String message) {
        super(message);
    }

    public CommandNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
