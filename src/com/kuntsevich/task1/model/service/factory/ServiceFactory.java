package com.kuntsevich.task1.model.service.factory;

import com.kuntsevich.task1.model.service.ApplianceService;
import com.kuntsevich.task1.model.service.impl.ApplianceServiceImpl;

public class ServiceFactory {
    private static volatile ServiceFactory instance;

    private final ApplianceService applianceService = new ApplianceServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            synchronized (ServiceFactory.class) {
                if (instance == null) {
                    instance = new ServiceFactory();
                }
            }
        }
        return instance;
    }

    public ApplianceService getApplianceService() {
        return applianceService;
    }
}
