package com.kuntsevich.task1.controller.command.type;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.command.impl.*;

public enum CommandType {
    FIND_ALL_OVENS(new FindAllOvenCommand()),
    FIND_ALL_LAPTOPS(new FindAllLaptopCommand()),
    FIND_ALL_REFRIGERATORS(new FindAllRefrigeratorCommand()),
    FIND_ALL_VACUUM_CLEANERS(new FindAllVacuumCleanerCommand()),
    FIND_ALL_TABLET_PCS(new FindAllTabletPcCommand()),
    FIND_ALL_SPEAKERS(new FindAllSpeakersCommand());

    Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
