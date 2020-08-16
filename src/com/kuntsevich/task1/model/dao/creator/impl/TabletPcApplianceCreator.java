package com.kuntsevich.task1.model.dao.creator.impl;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.CustomColor;
import com.kuntsevich.task1.entity.TabletPc;
import com.kuntsevich.task1.exception.ApplianceCreatorException;
import com.kuntsevich.task1.model.dao.creator.ApplianceCreator;

import java.util.List;

public class TabletPcApplianceCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(List<String> params) throws ApplianceCreatorException {
        try {
            int batteryCapacity = Integer.parseInt(params.get(0));
            int displayInches = Integer.parseInt(params.get(1));
            int memoryRom = Integer.parseInt(params.get(2));
            int flashMemoryCapacity = Integer.parseInt(params.get(3));
            CustomColor color = Enum.valueOf(CustomColor.class, params.get(4).toUpperCase());
            return new TabletPc(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
        } catch (NumberFormatException e) {
            throw new ApplianceCreatorException("Can't create appliance because params are invalid");
        }
    }
}
