package com.kuntsevich.task1.model.dao.impl;

import com.kuntsevich.task1.entity.Oven;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.model.dao.Dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OvenFileDaoImpl implements Dao<Oven> {
    private static final String DB_FILE_PATH = "src/main/resources/db/appliances_db.txt";

    @Override
    public Optional<Oven> findById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Oven> findAll() throws DaoException {
        List<Oven> ovens = new ArrayList<>();
        File file = new File(DB_FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.isBlank()) {
                int colonPos = line.indexOf(':');
                String className = line.substring(0, colonPos - 1);
                if (className.equals("Oven")) {
                    String[] params = line.substring(colonPos + 1).split(", ");
                    int powerConsumption = Integer.parseInt(getParamValue(params[0]));
                    int weight = Integer.parseInt(getParamValue(params[1]));
                    int capacity = Integer.parseInt(getParamValue(params[2]));
                    float height = Float.parseFloat(getParamValue(params[3]));
                    float width = Float.parseFloat(getParamValue(params[4]));
                    Oven oven = new Oven(-1, powerConsumption, weight, capacity, height, width);
                    ovens.add(oven);
                }
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("File is not available", e);
        } catch (IOException e) {
            throw new DaoException("Error when reading file", e);
        }
        return ovens;
    }

    @Override
    public boolean insert(Oven oven) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Oven oven, String[] params) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Oven oven) throws DaoException {
        return false;
    }

    private String getParamValue(String paramLine) {
        int delimiterPos = paramLine.indexOf('=');
        String value = paramLine.substring(delimiterPos + 1);
        return value;
    }
}
