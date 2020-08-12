package com.kuntsevich.task1.controller.command.impl;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.entity.Response;
import com.kuntsevich.task1.entity.Oven;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.service.impl.OvenApplianceServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindAllOvenCommand implements Command {
    @Override
    public Response<?> execute(Map<String, String> params) {
        Response<Oven> response;
        OvenApplianceServiceImpl ovenApplianceService = new OvenApplianceServiceImpl();
        try {
            List<Oven> ovens = ovenApplianceService.findAll();
            response = new Response<>(false, ovens);
        } catch (ServiceException e) {
            response = new Response<>(true, new ArrayList<>());
        }
        return response;
    }
}
