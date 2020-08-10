package com.kuntsevich.task1.controller.command.type;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.command.impl.FindAllOvensCommand;

public enum CommandType {
    FIND_ALL_OVENS(new FindAllOvensCommand());

    Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
