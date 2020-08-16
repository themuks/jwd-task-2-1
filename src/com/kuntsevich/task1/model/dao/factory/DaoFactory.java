package com.kuntsevich.task1.model.dao.factory;

import com.kuntsevich.task1.model.dao.impl.ApplianceDao;

public class DaoFactory {
    private static volatile DaoFactory instance;

    private final ApplianceDao applianceDao = new ApplianceDao();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            synchronized (DaoFactory.class) {
                if (instance == null) {
                    instance = new DaoFactory();
                }
            }
        }
        return instance;
    }

    public ApplianceDao getApplianceDao() {
        return applianceDao;
    }
}
