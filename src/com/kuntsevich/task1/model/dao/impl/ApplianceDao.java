package com.kuntsevich.task1.model.dao.impl;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.Criteria;
import com.kuntsevich.task1.exception.ApplianceCreatorException;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.constant.FileDaoConstant;
import com.kuntsevich.task1.model.dao.creator.ApplianceCreator;
import com.kuntsevich.task1.model.dao.creator.provider.ApplianceCreatorProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApplianceDao implements Dao<Appliance> {
    @Override
    public List<Appliance> findAll(Criteria criteria) throws DaoException {
        List<Appliance> appliances = new ArrayList<>();
        File file = new File(FileDaoConstant.DB_FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isBlank()) {
                    int colonPos = line.indexOf(FileDaoConstant.CLASS_NAME_DELIMITER);
                    String className = line.substring(0, colonPos - 1);
                    if (className.equals(criteria.getGroupSearchName())) {
                        ApplianceCreator applianceCreator = ApplianceCreatorProvider.defineApplianceCreator(className.toUpperCase());
                        String[] paramsRaw = line.substring(colonPos + 1).split(FileDaoConstant.PARAM_DELIMITER);
                        List<String> params = new ArrayList<>();
                        for (String param : paramsRaw) {
                            params.add(getParamValue(param));
                        }
                        Appliance appliance = applianceCreator.createAppliance(params);
                        appliances.add(appliance);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("File is not available", e);
        } catch (IOException e) {
            throw new DaoException("Error when reading file", e);
        } catch (ApplianceCreatorException e) {
            throw new DaoException("Error defining appliance creator", e);
        }
        return appliances;
    }

    private String getParamValue(String paramLine) {
        int delimiterPos = paramLine.indexOf(FileDaoConstant.VALUE_DELIMITER);
        return paramLine.substring(delimiterPos + 1);
    }
}
