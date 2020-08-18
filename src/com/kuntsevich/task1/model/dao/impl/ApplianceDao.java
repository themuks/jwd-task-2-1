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
import java.util.Map;

public class ApplianceDao implements Dao<Appliance> {
    @Override
    public Appliance find(Criteria criteria) throws DaoException {
        File file = new File(FileDaoConstant.DB_FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isBlank()) {
                    int colonPos = line.indexOf(FileDaoConstant.CLASS_NAME_DELIMITER);
                    String className = line.substring(0, colonPos - 1);
                    if (className.equals(criteria.getGroupSearchName())) {
                        String[] paramLines = line.substring(colonPos + 1).split(FileDaoConstant.PARAM_DELIMITER);
                        List<String> paramValues = new ArrayList<>();
                        List<String> paramNames = new ArrayList<>();
                        for (String paramLine : paramLines) {
                            paramValues.add(getParamValue(paramLine));
                            paramNames.add(getParamName(paramLine));
                        }
                        if (isFitsCriteria(criteria, paramValues, paramNames)) {
                            return createApplianceFromValues(className, paramValues);
                        }
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
        throw new DaoException("Appliance not found");
    }

    private Appliance createApplianceFromValues(String className, List<String> paramValues) throws ApplianceCreatorException {
        ApplianceCreator applianceCreator = ApplianceCreatorProvider.defineApplianceCreator(className.toUpperCase());
        Appliance appliance = applianceCreator.createAppliance(paramValues);
        return appliance;
    }

    private boolean isFitsCriteria(Criteria criteria, List<String> paramValues, List<String> paramNames) {
        Map<String, Object> criterias = criteria.getCriteria();
        boolean flag = true;
        for (int i = 0; i < paramNames.size(); i++) {
            String paramName = paramNames.get(i);
            String paramValue = paramValues.get(i);
            if (criterias.containsKey(paramName) && !criterias.get(paramName).toString().equals(paramValue)) {
                flag = false;
            }
        }
        return flag;
    }

    private String getParamName(String paramLine) {
        int delimiterPos = paramLine.indexOf(FileDaoConstant.VALUE_DELIMITER);
        return paramLine.substring(0, delimiterPos);
    }

    private String getParamValue(String paramLine) {
        int delimiterPos = paramLine.indexOf(FileDaoConstant.VALUE_DELIMITER);
        return paramLine.substring(delimiterPos + 1);
    }
}
