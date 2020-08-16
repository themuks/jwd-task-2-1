package com.kuntsevich.task1.model.dao.creator.provider;

import com.kuntsevich.task1.exception.ApplianceCreatorException;
import com.kuntsevich.task1.model.dao.creator.ApplianceCreator;
import com.kuntsevich.task1.model.dao.creator.type.ApplianceType;

public class ApplianceCreatorProvider {
    public static ApplianceCreator defineApplianceCreator(String applianceName) throws ApplianceCreatorException {
        if (applianceName == null || applianceName.isBlank()) {
            throw new ApplianceCreatorException("Invalid appliance name");
        }
        ApplianceType currentType;
        try {
            currentType = ApplianceType.valueOf(applianceName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ApplianceCreatorException("Invalid appliance name");
        }
        return currentType.getApplianceCreator();
    }
}
