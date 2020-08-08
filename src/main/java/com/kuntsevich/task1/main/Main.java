package com.kuntsevich.task1.main;

import com.kuntsevich.task1.entity.Oven;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.impl.OvenFileDaoImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dao<Oven> dao = new OvenFileDaoImpl();
        try {
            List<Oven> ovens = dao.findAll();
            System.out.println(ovens);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
