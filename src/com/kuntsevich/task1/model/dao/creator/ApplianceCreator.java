package com.kuntsevich.task1.model.dao.creator;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.exception.ApplianceCreatorException;

import java.util.List;

public interface ApplianceCreator {
    Appliance createAppliance(List<String> params) throws ApplianceCreatorException;
}
