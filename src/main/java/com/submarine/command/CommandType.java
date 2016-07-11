package com.submarine.command;

import com.submarine.domain.Submarine;

public enum CommandType {

    LEFT("L") {
        @Override
        public SubmarineCommand createCommand(Submarine submarine) {
            return new RotateLeftCommand(submarine);
        }
    },
    RIGHT("R") {
        @Override
        public SubmarineCommand createCommand(Submarine submarine) {
            return new RotateRightCommand(submarine);
        }
    },
    UP("U") {
        @Override
        public SubmarineCommand createCommand(Submarine submarine) {
            return new UpCommand(submarine);
        }
    },
    DOWN("D") {
        @Override
        public SubmarineCommand createCommand(Submarine submarine) {
            return new DownCommand(submarine);
        }
    },
    MOVE("M") {
        @Override
        public SubmarineCommand createCommand(Submarine submarine) {
            return new MoveCommand(submarine);
        }
    };

    CommandType(String command) {
        this.command = command;
    }

    public String command;

    public abstract SubmarineCommand createCommand(Submarine submarine);

    public static CommandType getCommand(String command) {

        for (CommandType commandType : values()) {
            if(commandType.command.equals(command)) {
                return commandType;
            }
        }

        throw new CommandNotFoundException("Commando " + command + " não encontrado.");
    }
}
