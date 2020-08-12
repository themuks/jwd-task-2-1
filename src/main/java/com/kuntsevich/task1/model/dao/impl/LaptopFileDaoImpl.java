package com.kuntsevich.task1.model.dao.impl;

import com.kuntsevich.task1.entity.Laptop;
import com.kuntsevich.task1.entity.Os;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.constant.FileDaoConstant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LaptopFileDaoImpl implements Dao<Laptop> {
    @Override
    public Optional<Laptop> findById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Laptop> findAll() throws DaoException {
        List<Laptop> laptops = new ArrayList<>();
        File file = new File(FileDaoConstant.DB_FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isBlank()) {
                    int colonPos = line.indexOf(FileDaoConstant.CLASS_NAME_DELIMITER);
                    String className = line.substring(0, colonPos - 1);
                    if (className.equals("Laptop")) {
                        String[] params = line.substring(colonPos + 1).split(FileDaoConstant.PARAM_DELIMITER);
                        float batteryCapacity = Float.parseFloat(getParamValue(params[0]));
                        Os os = Enum.valueOf(Os.class, getParamValue(params[1]).toUpperCase());
                        int memoryRom = Integer.parseInt(getParamValue(params[2]));
                        int systemMemory = Integer.parseInt(getParamValue(params[3]));
                        float cpu = Float.parseFloat(getParamValue(params[4]));
                        int displayInches = Integer.parseInt(getParamValue(params[5]));
                        Laptop laptop = new Laptop(batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches);
                        laptops.add(laptop);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("File is not available", e);
        } catch (IOException e) {
            throw new DaoException("Error when reading file", e);
        }
        return laptops;
    }

    @Override
    public boolean insert(Laptop laptop) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Laptop laptop, String[] params) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Laptop laptop) throws DaoException {
        return false;
    }

    private String getParamValue(String paramLine) {
        int delimiterPos = paramLine.indexOf(FileDaoConstant.VALUE_DELIMITER);
        return paramLine.substring(delimiterPos + 1);
    }
}
