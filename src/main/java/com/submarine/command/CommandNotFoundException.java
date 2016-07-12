package com.submarine.command;

public class CommandNotFoundException extends RuntimeException {

    public CommandNotFoundException(String command) {
        super("Comando " + command + " nao encontrado!");
    }

    public CommandNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
