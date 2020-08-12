package com.kuntsevich.task1.model.service.impl;

import com.kuntsevich.task1.entity.TabletPc;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.factory.DaoFactory;
import com.kuntsevich.task1.model.service.ApplianceService;

import java.util.List;

public class TabletPcApplianceServiceImpl implements ApplianceService<TabletPc> {
    @Override
    public List<TabletPc> findAll() throws ServiceException {
        Dao<TabletPc> dao = DaoFactory.getInstance().getTabletPcDao();
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
