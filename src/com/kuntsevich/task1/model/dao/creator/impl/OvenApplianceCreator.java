package com.kuntsevich.task1.model.dao.creator.impl;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.Oven;
import com.kuntsevich.task1.exception.ApplianceCreatorException;
import com.kuntsevich.task1.model.dao.creator.ApplianceCreator;

import java.util.List;

public class OvenApplianceCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(List<String> params) throws ApplianceCreatorException {
        try {
            int powerConsumption = Integer.parseInt(params.get(0));
            int weight = Integer.parseInt(params.get(1));
            int capacity = Integer.parseInt(params.get(2));
            float height = Float.parseFloat(params.get(3));
            float width = Float.parseFloat(params.get(4));
            return new Oven(powerConsumption, weight, capacity, height, width);
        } catch (NumberFormatException e) {
            throw new ApplianceCreatorException("Can't create appliance because params are invalid");
        }
    }
}
