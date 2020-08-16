package com.kuntsevich.task1.model.dao.creator.impl;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.Refrigerator;
import com.kuntsevich.task1.exception.ApplianceCreatorException;
import com.kuntsevich.task1.model.dao.creator.ApplianceCreator;

import java.util.List;

public class RefrigeratorApplianceCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(List<String> params) throws ApplianceCreatorException {
        try {
            int powerConsumption = Integer.parseInt(params.get(0));
            int weight = Integer.parseInt(params.get(1));
            int freezerCapacity = Integer.parseInt(params.get(2));
            float overallCapacity = Float.parseFloat(params.get(3));
            int height = Integer.parseInt(params.get(4));
            int width = Integer.parseInt(params.get(5));
            return new Refrigerator(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
        } catch (NumberFormatException e) {
            throw new ApplianceCreatorException("Can't create appliance because params are invalid");
        }
    }
}
