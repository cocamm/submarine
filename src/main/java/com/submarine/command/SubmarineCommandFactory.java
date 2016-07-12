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

        SubmarineCommand submarineCommand = commandType.createCommand(submarine);
        if(submarineCommand == null) {
            throw new CommandNotFoundException(command);
        }

        return submarineCommand;
    }
}
