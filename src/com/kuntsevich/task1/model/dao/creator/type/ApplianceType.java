package com.kuntsevich.task1.model.dao.creator.type;

import com.kuntsevich.task1.model.dao.creator.ApplianceCreator;
import com.kuntsevich.task1.model.dao.creator.impl.*;

public enum ApplianceType {
    LAPTOP(new LaptopApplianceCreator()),
    OVEN(new OvenApplianceCreator()),
    REFRIGERATOR(new RefrigeratorApplianceCreator()),
    SPEAKERS(new SpeakersApplianceCreator()),
    TABLETPC(new TabletPcApplianceCreator()),
    VACUUMCLEANER(new VacuumCleanerApplianceCreator());

    ApplianceCreator applianceCreator;

    ApplianceType(ApplianceCreator applianceCreator) {
        this.applianceCreator = applianceCreator;
    }

    public ApplianceCreator getApplianceCreator() {
        return applianceCreator;
    }
}
