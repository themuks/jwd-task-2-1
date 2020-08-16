package com.kuntsevich.task1.model.dao.creator.impl;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.Laptop;
import com.kuntsevich.task1.entity.Os;
import com.kuntsevich.task1.exception.ApplianceCreatorException;
import com.kuntsevich.task1.model.dao.creator.ApplianceCreator;

import java.util.List;

public class LaptopApplianceCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(List<String> params) throws ApplianceCreatorException {
        try {
            float batteryCapacity = Float.parseFloat(params.get(0));
            Os os = Enum.valueOf(Os.class, params.get(1).toUpperCase());
            int memoryRom = Integer.parseInt(params.get(2));
            int systemMemory = Integer.parseInt(params.get(3));
            float cpu = Float.parseFloat(params.get(4));
            int displayInches = Integer.parseInt(params.get(5));
            return new Laptop(batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches);
        } catch (NumberFormatException e) {
            throw new ApplianceCreatorException("Can't create appliance because params are invalid");
        }
    }
}
