package com.kuntsevich.task1.model.service.impl;

import com.kuntsevich.task1.entity.Laptop;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.factory.DaoFactory;
import com.kuntsevich.task1.model.service.ApplianceService;

import java.util.List;

public class LaptopApplianceServiceImpl implements ApplianceService<Laptop> {
    @Override
    public List<Laptop> findAll() throws ServiceException {
        Dao<Laptop> dao = DaoFactory.getInstance().getLaptopDao();
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
