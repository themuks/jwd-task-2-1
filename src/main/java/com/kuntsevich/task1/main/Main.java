package com.kuntsevich.task1.main;

import com.kuntsevich.task1.entity.Oven;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.service.impl.OvenApplianceServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OvenApplianceServiceImpl ovenApplianceService = new OvenApplianceServiceImpl();
        try {
            List<Oven> ovens = ovenApplianceService.findAll();
            System.out.println(ovens);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
