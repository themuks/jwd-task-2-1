package com.kuntsevich.task1.model.service.impl;

import com.kuntsevich.task1.entity.Refrigerator;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.factory.DaoFactory;
import com.kuntsevich.task1.model.service.ApplianceService;

import java.util.List;

public class RefrigeratorApplianceServiceImpl implements ApplianceService<Refrigerator> {
    @Override
    public List<Refrigerator> findAll() throws ServiceException {
        Dao<Refrigerator> dao = DaoFactory.getInstance().getRefrigeratorDao();
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
