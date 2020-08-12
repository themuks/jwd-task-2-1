package com.kuntsevich.task1.model.dao.factory;

import com.kuntsevich.task1.entity.*;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.impl.*;

public class DaoFactory {
    private static volatile DaoFactory instance;

    private final Dao<Oven> ovenDao = new OvenFileDaoImpl();
    private final Dao<Laptop> laptopDao = new LaptopFileDaoImpl();
    private final Dao<Refrigerator> refrigeratorDao = new RefrigeratorFileDaoImpl();
    private final Dao<VacuumCleaner> vacuumCleanerDao = new VacuumCleanerFileDaoImpl();
    private final Dao<TabletPc> tabletPcDao = new TabletPcFileDaoImpl();
    private final Dao<Speakers> speakersDao = new SpeakersFileDaoImpl();

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

    public Dao<Laptop> getLaptopDao() {
        return laptopDao;
    }

    public Dao<Refrigerator> getRefrigeratorDao() {
        return refrigeratorDao;
    }

    public Dao<VacuumCleaner> getVacuumCleanerDao() {
        return vacuumCleanerDao;
    }

    public Dao<TabletPc> getTabletPcDao() {
        return tabletPcDao;
    }

    public Dao<Speakers> getSpeakersDao() {
        return speakersDao;
    }
}
