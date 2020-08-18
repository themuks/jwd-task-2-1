package com.kuntsevich.task1.controller;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.command.provider.CommandProvider;
import com.kuntsevich.task1.controller.entity.Request;
import com.kuntsevich.task1.controller.entity.Response;

import java.util.Map;

public class Controller {
    public Response executeTask(Request request) {
        Command command = CommandProvider.defineCommand(request.getCommand());
        Map<String, Object> params = request.getParams();
        return command.execute(params);
    }
}
