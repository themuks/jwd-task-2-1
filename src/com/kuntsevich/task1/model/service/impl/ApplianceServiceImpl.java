package com.kuntsevich.task1.model.service.impl;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.Criteria;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.dao.factory.DaoFactory;
import com.kuntsevich.task1.model.dao.impl.ApplianceDao;
import com.kuntsevich.task1.model.service.ApplianceService;
import com.kuntsevich.task1.validator.CriteriaValidator;

public class ApplianceServiceImpl implements ApplianceService {
    @Override
    public Appliance find(Criteria criteria) throws ServiceException {
        if (!CriteriaValidator.isCriteriaValid(criteria)) {
            throw new ServiceException("Criteria is invalid");
        }
        ApplianceDao applianceDao = DaoFactory.getInstance().getApplianceDao();
        Appliance appliance;
        try {
            appliance = applianceDao.find(criteria);
        } catch (DaoException e) {
            throw new ServiceException("Appliance dao find error", e);
        }
        return appliance;
    }
}