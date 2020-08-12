package com.kuntsevich.task1.model.dao.impl;

import com.kuntsevich.task1.entity.FilterType;
import com.kuntsevich.task1.entity.VacuumCleaner;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.constant.FileDaoConstant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VacuumCleanerFileDaoImpl implements Dao<VacuumCleaner> {
    @Override
    public Optional<VacuumCleaner> findById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<VacuumCleaner> findAll() throws DaoException {
        List<VacuumCleaner> vacuumCleaners = new ArrayList<>();
        File file = new File(FileDaoConstant.DB_FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isBlank()) {
                    int colonPos = line.indexOf(FileDaoConstant.CLASS_NAME_DELIMITER);
                    String className = line.substring(0, colonPos - 1);
                    if (className.equals("VacuumCleaner")) {
                        String[] params = line.substring(colonPos + 1).split(FileDaoConstant.PARAM_DELIMITER);
                        int powerConsumption = Integer.parseInt(getParamValue(params[0]));
                        FilterType filterType = Enum.valueOf(FilterType.class, getParamValue(params[1]).toUpperCase());
                        String bagType = getParamValue(params[2]);
                        String wandType = getParamValue(params[3]);
                        int motorSpeedRegulation = Integer.parseInt(getParamValue(params[4]));
                        int cleaningWidth = Integer.parseInt(getParamValue(params[5]));
                        VacuumCleaner vacuumCleaner = new VacuumCleaner(powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth);
                        vacuumCleaners.add(vacuumCleaner);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("File is not available", e);
        } catch (IOException e) {
            throw new DaoException("Error when reading file", e);
        }
        return vacuumCleaners;
    }

    @Override
    public boolean insert(VacuumCleaner vacuumCleaner) throws DaoException {
        return false;
    }

    @Override
    public boolean update(VacuumCleaner vacuumCleaner, String[] params) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(VacuumCleaner vacuumCleaner) throws DaoException {
        return false;
    }

    private String getParamValue(String paramLine) {
        int delimiterPos = paramLine.indexOf(FileDaoConstant.VALUE_DELIMITER);
        return paramLine.substring(delimiterPos + 1);
    }
}
