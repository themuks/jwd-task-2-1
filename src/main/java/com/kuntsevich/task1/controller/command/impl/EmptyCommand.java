package com.kuntsevich.task1.controller.command.impl;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.entity.Response;
import com.kuntsevich.task1.entity.Appliance;

import java.util.ArrayList;
import java.util.Map;

public class EmptyCommand implements Command {
    @Override
    public Response<Appliance> execute(Map<String, String> params) {
        return new Response<>(false, new ArrayList<>());
    }
}
