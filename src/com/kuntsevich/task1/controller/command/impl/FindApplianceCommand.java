package com.kuntsevich.task1.controller.command.impl;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.entity.Response;
import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.Criteria;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.service.ApplianceService;
import com.kuntsevich.task1.model.service.factory.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindApplianceCommand implements Command {
    @Override
    public Response execute(Map<String, Object> params) {
        Response response;
        ApplianceService applianceService = ServiceFactory.getInstance().getApplianceService();
        try {
            String applianceName = (String) params.get("applianceName");
            Map<String, Object> criteriaParams = (Map<String, Object>) params.get("criteriaParams");
            if (applianceName != null && criteriaParams != null) {
                Criteria criteria = new Criteria(applianceName);
                criteria.addAll(criteriaParams);
                List<Appliance> appliances = applianceService.find(criteria);
                response = new Response(false, appliances);
            } else {
                response = new Response(true, new ArrayList<>());
            }
        } catch (ServiceException e) {
            response = new Response(true, new ArrayList<>());
        }
        return response;
    }
}
