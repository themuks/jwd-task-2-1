package com.kuntsevich.task1.model.service.impl;

import com.kuntsevich.task1.entity.Oven;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.factory.DaoFactory;
import com.kuntsevich.task1.model.service.ApplianceService;

import java.util.List;

public class OvenApplianceServiceImpl implements ApplianceService<Oven> {
    @Override
    public List<Oven> findAll() throws ServiceException {
        Dao<Oven> dao = DaoFactory.getInstance().getOvenDao();
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
