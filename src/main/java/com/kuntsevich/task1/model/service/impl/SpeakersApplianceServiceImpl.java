package com.kuntsevich.task1.model.service.impl;

import com.kuntsevich.task1.entity.Speakers;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.factory.DaoFactory;
import com.kuntsevich.task1.model.service.ApplianceService;

import java.util.List;

public class SpeakersApplianceServiceImpl implements ApplianceService<Speakers> {
    @Override
    public List<Speakers> findAll() throws ServiceException {
        Dao<Speakers> dao = DaoFactory.getInstance().getSpeakersDao();
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
