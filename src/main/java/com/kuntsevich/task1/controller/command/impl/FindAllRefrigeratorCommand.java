package com.kuntsevich.task1.controller.command.impl;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.entity.Response;
import com.kuntsevich.task1.entity.Refrigerator;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.service.impl.RefrigeratorApplianceServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindAllRefrigeratorCommand implements Command {
    @Override
    public Response<?> execute(Map<String, String> params) {
        Response<Refrigerator> response;
        RefrigeratorApplianceServiceImpl refrigeratorApplianceService = new RefrigeratorApplianceServiceImpl();
        try {
            List<Refrigerator> refrigerators = refrigeratorApplianceService.findAll();
            response = new Response<>(false, refrigerators);
        } catch (ServiceException e) {
            response = new Response<>(true, new ArrayList<>());
        }
        return response;
    }
}
