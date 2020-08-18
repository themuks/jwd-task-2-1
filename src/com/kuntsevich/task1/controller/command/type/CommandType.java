package com.kuntsevich.task1.controller.command.type;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.command.impl.FindApplianceCommand;

public enum CommandType {
    FIND_APPLIANCE(new FindApplianceCommand());

    Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
