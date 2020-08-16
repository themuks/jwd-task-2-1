package com.kuntsevich.task1.model.dao.impl;

import com.kuntsevich.task1.entity.Refrigerator;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.constant.FileDaoConstant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RefrigeratorFileDaoImpl implements Dao<Refrigerator> {

    private static final String CLASS_NAME = "Refrigerator";

    @Override
    public Optional<Refrigerator> findById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Refrigerator> findAll() throws DaoException {
        List<Refrigerator> refrigerators = new ArrayList<>();
        File file = new File(FileDaoConstant.DB_FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isBlank()) {
                    int colonPos = line.indexOf(FileDaoConstant.CLASS_NAME_DELIMITER);
                    String className = line.substring(0, colonPos - 1);
                    if (className.equals(CLASS_NAME)) {
                        String[] params = line.substring(colonPos + 1).split(FileDaoConstant.PARAM_DELIMITER);
                        int powerConsumption = Integer.parseInt(getParamValue(params[0]));
                        int weight = Integer.parseInt(getParamValue(params[1]));
                        int freezerCapacity = Integer.parseInt(getParamValue(params[2]));
                        float overallCapacity = Float.parseFloat(getParamValue(params[3]));
                        int height = Integer.parseInt(getParamValue(params[4]));
                        int width = Integer.parseInt(getParamValue(params[5]));
                        Refrigerator refrigerator = new Refrigerator(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
                        refrigerators.add(refrigerator);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("File is not available", e);
        } catch (IOException e) {
            throw new DaoException("Error when reading file", e);
        }
        return refrigerators;
    }

    @Override
    public boolean insert(Refrigerator refrigerator) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Refrigerator refrigerator, String[] params) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Refrigerator refrigerator) throws DaoException {
        return false;
    }

    private String getParamValue(String paramLine) {
        int delimiterPos = paramLine.indexOf(FileDaoConstant.VALUE_DELIMITER);
        return paramLine.substring(delimiterPos + 1);
    }
}
