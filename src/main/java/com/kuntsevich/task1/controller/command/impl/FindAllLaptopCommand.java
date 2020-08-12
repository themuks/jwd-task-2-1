package com.kuntsevich.task1.controller.command.impl;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.entity.Response;
import com.kuntsevich.task1.entity.Laptop;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.service.impl.LaptopApplianceServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindAllLaptopCommand implements Command {
    @Override
    public Response<?> execute(Map<String, String> params) {
        Response<Laptop> response;
        LaptopApplianceServiceImpl laptopApplianceService = new LaptopApplianceServiceImpl();
        try {
            List<Laptop> laptops = laptopApplianceService.findAll();
            response = new Response<>(false, laptops);
        } catch (ServiceException e) {
            response = new Response<>(true, new ArrayList<>());
        }
        return response;
    }
}
