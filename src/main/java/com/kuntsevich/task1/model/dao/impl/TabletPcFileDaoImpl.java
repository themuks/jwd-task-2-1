package com.kuntsevich.task1.model.dao.impl;

import com.kuntsevich.task1.entity.CustomColor;
import com.kuntsevich.task1.entity.TabletPc;
import com.kuntsevich.task1.exception.DaoException;
import com.kuntsevich.task1.model.dao.Dao;
import com.kuntsevich.task1.model.dao.constant.FileDaoConstant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TabletPcFileDaoImpl implements Dao<TabletPc> {

    private static final String CLASS_NAME = "TabletPC";

    @Override
    public Optional<TabletPc> findById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<TabletPc> findAll() throws DaoException {
        List<TabletPc> tabletPcs = new ArrayList<>();
        File file = new File(FileDaoConstant.DB_FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isBlank()) {
                    int colonPos = line.indexOf(FileDaoConstant.CLASS_NAME_DELIMITER);
                    String className = line.substring(0, colonPos - 1);
                    if (className.equals(CLASS_NAME)) {
                        String[] params = line.substring(colonPos + 1).split(FileDaoConstant.PARAM_DELIMITER);
                        int batteryCapacity = Integer.parseInt(getParamValue(params[0]));
                        int displayInches = Integer.parseInt(getParamValue(params[1]));
                        int memoryRom = Integer.parseInt(getParamValue(params[2]));
                        int flashMemoryCapacity = Integer.parseInt(getParamValue(params[3]));
                        CustomColor color = Enum.valueOf(CustomColor.class, getParamValue(params[4]).toUpperCase());
                        TabletPc tabletPc = new TabletPc(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
                        tabletPcs.add(tabletPc);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("File is not available", e);
        } catch (IOException e) {
            throw new DaoException("Error when reading file", e);
        }
        return tabletPcs;
    }

    @Override
    public boolean insert(TabletPc tabletPc) throws DaoException {
        return false;
    }

    @Override
    public boolean update(TabletPc tabletPc, String[] params) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(TabletPc tabletPc) throws DaoException {
        return false;
    }

    private String getParamValue(String paramLine) {
        int delimiterPos = paramLine.indexOf(FileDaoConstant.VALUE_DELIMITER);
        return paramLine.substring(delimiterPos + 1);
    }
}
