package com.kuntsevich.task1.model.service;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.Criteria;
import com.kuntsevich.task1.exception.ServiceException;

import java.util.List;

public interface ApplianceService {
    List<Appliance> findAll(Criteria criteria) throws ServiceException;
}
