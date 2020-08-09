package com.kuntsevich.task1.model.service.impl;

import com.kuntsevich.task1.entity.Oven;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.factory.DaoFactory;
import com.kuntsevich.task1.model.service.ApplianceService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OvenApplianceServiceImpl implements ApplianceService<Oven> {
    @Override
    public Optional<Oven> findById(String id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public List<Oven> findAll() throws ServiceException {
        Dao<Oven> ovenDao = DaoFactory.getInstance().getOvenDao();
        List<Oven> ovens;
        try {
            ovens = ovenDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return ovens;
    }

    @Override
    public boolean insert(Map<String, String> objectFieldValues) throws ServiceException {
        return false;
    }

    @Override
    public boolean update(Map<String, String> objectFieldValues, String[] params) throws ServiceException {
        return false;
    }

    @Override
    public boolean delete(Map<String, String> objectFieldValues) throws ServiceException {
        return false;
    }
}
