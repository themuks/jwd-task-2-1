package com.kuntsevich.task1.model.service.impl;

import com.kuntsevich.task1.entity.VacuumCleaner;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.factory.DaoFactory;
import com.kuntsevich.task1.model.service.ApplianceService;

import java.util.List;

public class VacuumCleanerApplianceServiceImpl implements ApplianceService<VacuumCleaner> {
    @Override
    public List<VacuumCleaner> findAll() throws ServiceException {
        Dao<VacuumCleaner> dao = DaoFactory.getInstance().getVacuumCleanerDao();
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
