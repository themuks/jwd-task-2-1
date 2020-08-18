package com.kuntsevich.task1.model.service;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.Criteria;
import com.kuntsevich.task1.exception.ServiceException;

public interface ApplianceService {
    Appliance find(Criteria criteria) throws ServiceException;
}
