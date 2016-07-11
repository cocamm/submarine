package com.submarine.command.translator;

import com.submarine.command.SubmarineCommand;

import java.util.List;

public interface SubmarineCommandTranslator {

    List<SubmarineCommand> translate(String commands);
}
