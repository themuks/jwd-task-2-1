package com.kuntsevich.task1.model.dao.creator.impl;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.FilterType;
import com.kuntsevich.task1.entity.VacuumCleaner;
import com.kuntsevich.task1.exception.ApplianceCreatorException;
import com.kuntsevich.task1.model.dao.creator.ApplianceCreator;

import java.util.List;

public class VacuumCleanerApplianceCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(List<String> params) throws ApplianceCreatorException {
        try {
            int powerConsumption = Integer.parseInt(params.get(0));
            FilterType filterType = Enum.valueOf(FilterType.class, params.get(1).toUpperCase());
            String bagType = params.get(2);
            String wandType = params.get(3);
            int motorSpeedRegulation = Integer.parseInt(params.get(4));
            int cleaningWidth = Integer.parseInt(params.get(5));
            return new VacuumCleaner(powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth);
        } catch (NumberFormatException e) {
            throw new ApplianceCreatorException("Can't create appliance because params are invalid");
        }
    }
}
