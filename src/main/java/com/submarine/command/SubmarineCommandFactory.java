package com.submarine.command;

import com.submarine.domain.Submarine;

import java.util.EnumMap;

public class SubmarineCommandFactory {

    private final Submarine submarine;

    public SubmarineCommandFactory(Submarine submarine) {
        this.submarine = submarine;
    }

    public SubmarineCommand create(String command) {

        CommandType commandType = CommandType.getCommand(command);

        if(command.equals("L")) {
            return new RotateLeftCommand(this.submarine);
        } else if(command.equals("R")) {
            return new RotateLeftCommand(this.submarine);
        }

        return null;
    }
}
