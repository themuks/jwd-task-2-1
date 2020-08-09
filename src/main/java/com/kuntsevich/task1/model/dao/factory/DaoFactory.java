package com.kuntsevich.task1.model.dao.factory;

import com.kuntsevich.task1.entity.Oven;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.impl.OvenFileDaoImpl;

public class DaoFactory {
    private static volatile DaoFactory instance;

    private final Dao<Oven> ovenDao = new OvenFileDaoImpl();

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

    public Dao<Oven> getOvenDao() {
        return ovenDao;
    }
}
