package com.submarine.command;

public enum CommandType {

    LEFT("L"),
    RIGHT("R"),
    UP("U"),
    DOWN("D"),
    MOVE("M");

    CommandType(String command) {
        this.command = command;
    }

    public String command;

    public static CommandType getCommand(String command) {

        for (CommandType commandType : values()) {
            if(commandType.command.equals(command)) {
                return commandType;
            }
        }

        throw new CommandNotFoundException(String.format("Commando %s não encontrado.", command));
    }
}
