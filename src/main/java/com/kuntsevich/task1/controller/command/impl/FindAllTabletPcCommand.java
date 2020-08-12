package com.kuntsevich.task1.controller.command.impl;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.entity.Response;
import com.kuntsevich.task1.entity.TabletPc;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.service.impl.TabletPcApplianceServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindAllTabletPcCommand implements Command {
    @Override
    public Response<?> execute(Map<String, String> params) {
        Response<TabletPc> response;
        TabletPcApplianceServiceImpl tabletPcApplianceService = new TabletPcApplianceServiceImpl();
        try {
            List<TabletPc> tabletPcs = tabletPcApplianceService.findAll();
            response = new Response<>(false, tabletPcs);
        } catch (ServiceException e) {
            response = new Response<>(true, new ArrayList<>());
        }
        return response;
    }
}
