package com.kuntsevich.task1.controller.command.impl;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.entity.Response;
import com.kuntsevich.task1.entity.VacuumCleaner;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.service.impl.VacuumCleanerApplianceServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindAllVacuumCleanerCommand implements Command {
    @Override
    public Response<?> execute(Map<String, String> params) {
        Response<VacuumCleaner> response;
        VacuumCleanerApplianceServiceImpl vacuumCleanerApplianceService = new VacuumCleanerApplianceServiceImpl();
        try {
            List<VacuumCleaner> vacuumCleaners = vacuumCleanerApplianceService.findAll();
            response = new Response<>(false, vacuumCleaners);
        } catch (ServiceException e) {
            response = new Response<>(true, new ArrayList<>());
        }
        return response;
    }
}
