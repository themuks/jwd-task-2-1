package com.kuntsevich.task1.controller.command.provider;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.command.impl.EmptyCommand;
import com.kuntsevich.task1.controller.command.type.CommandType;

public class CommandProvider {
    public static Command defineCommand(String action) {
        if (action == null || action.isBlank()) {
            return new EmptyCommand();
        }
        CommandType currentType;
        try {
            currentType = CommandType.valueOf(action.toUpperCase());
        } catch (IllegalArgumentException e) {
            return new EmptyCommand();
        }
        return currentType.getCommand();
    }
}