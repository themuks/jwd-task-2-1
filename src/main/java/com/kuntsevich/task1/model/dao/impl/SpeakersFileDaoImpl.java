package com.kuntsevich.task1.model.dao.impl;

import com.kuntsevich.task1.entity.FloatRange;
import com.kuntsevich.task1.entity.Speakers;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.constant.FileDaoConstant;
import com.kuntsevich.task1.parser.FloatRangeParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpeakersFileDaoImpl implements Dao<Speakers> {
    @Override
    public Optional<Speakers> findById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Speakers> findAll() throws DaoException {
        List<Speakers> speakersList = new ArrayList<>();
        File file = new File(FileDaoConstant.DB_FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isBlank()) {
                    int colonPos = line.indexOf(FileDaoConstant.CLASS_NAME_DELIMITER);
                    String className = line.substring(0, colonPos - 1);
                    if (className.equals("Speakers")) {
                        String[] params = line.substring(colonPos + 1).split(FileDaoConstant.PARAM_DELIMITER);
                        int powerConsumption = Integer.parseInt(getParamValue(params[0]));
                        int numberOfSpeakers = Integer.parseInt(getParamValue(params[1]));
                        FloatRange frequencyLength = FloatRangeParser.parseFloatRange(getParamValue(params[2]));
                        int cordLength = Integer.parseInt(getParamValue(params[3]));
                        Speakers speakers = new Speakers(powerConsumption, numberOfSpeakers, frequencyLength, cordLength);
                        speakersList.add(speakers);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("File is not available", e);
        } catch (IOException e) {
            throw new DaoException("Error when reading file", e);
        }
        return speakersList;
    }

    @Override
    public boolean insert(Speakers speakers) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Speakers speakers, String[] params) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Speakers speakers) throws DaoException {
        return false;
    }

    private String getParamValue(String paramLine) {
        int delimiterPos = paramLine.indexOf(FileDaoConstant.VALUE_DELIMITER);
        return paramLine.substring(delimiterPos + 1);
    }
}
