package com.kuntsevich.task1.controller.command;

import com.kuntsevich.task1.controller.entity.Response;

import java.util.Map;

public interface Command {
    Response execute(Map<String, String> params);
}
