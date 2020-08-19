package com.kuntsevich.task1.model.dao.impl;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.Criteria;
import com.kuntsevich.task1.exception.ApplianceCreatorException;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.model.dao.ApplianceDao;
import com.kuntsevich.task1.model.dao.constant.FileDaoConstant;
import com.kuntsevich.task1.model.dao.creator.ApplianceCreator;
import com.kuntsevich.task1.model.dao.creator.provider.ApplianceCreatorProvider;
import com.kuntsevich.task1.model.dao.entity.ObjectParameter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceDaoImpl implements ApplianceDao {
    @Override
    public List<Appliance> find(Criteria criteria) throws DaoException {
        List<Appliance> appliances = new ArrayList<>();
        File file = new File(FileDaoConstant.DB_FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isBlank()) {
                    int colonPos = line.indexOf(FileDaoConstant.CLASS_NAME_DELIMITER);
                    String className = line.substring(0, colonPos - 1);
                    if (className.equals(criteria.getGroupSearchName())) {
                        List<String> paramLines = List.of(line.substring(colonPos + 1).split(FileDaoConstant.PARAM_DELIMITER));
                        List<ObjectParameter> parameters = getApplianceParameters(paramLines);
                        if (isFitsCriteria(criteria, parameters)) {
                            appliances.add(createAppliance(className, parameters));
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
        return appliances;
    }

    private List<ObjectParameter> getApplianceParameters(List<String> paramLines) {
        List<ObjectParameter> parameters = new ArrayList<>();
        for (String paramLine : paramLines) {
            int delimiterPos = paramLine.indexOf(FileDaoConstant.VALUE_DELIMITER);
            String parameterName = paramLine.substring(0, delimiterPos);
            String parameterValue = paramLine.substring(delimiterPos + 1);
            ObjectParameter objectParameter = new ObjectParameter(parameterName, parameterValue);
            parameters.add(objectParameter);
        }
        return parameters;
    }

    private Appliance createAppliance(String className, List<ObjectParameter> parameters) throws ApplianceCreatorException {
        ApplianceCreator applianceCreator = ApplianceCreatorProvider.defineApplianceCreator(className.toUpperCase());
        List<String> values = new ArrayList<>();
        for (ObjectParameter parameter : parameters) {
            values.add(parameter.getParameterValue());
        }
        return applianceCreator.createAppliance(values);
    }

    private boolean isFitsCriteria(Criteria criteria, List<ObjectParameter> parameters) {
        Map<String, Object> criteriaList = criteria.getCriteria();
        for (ObjectParameter parameter : parameters) {
            String paramName = parameter.getParameterName();
            String paramValue = parameter.getParameterValue();
            if (criteriaList.containsKey(paramName) && !criteriaList.get(paramName).toString().equals(paramValue)) {
                return false;
            }
        }
        return true;
    }
}
