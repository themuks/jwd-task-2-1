package com.kuntsevich.task1.model.service;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.exception.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ApplianceService<T extends Appliance> {
    Optional<T> findById(String id) throws ServiceException;

    List<T> findAll() throws ServiceException;

    boolean insert(Map<String, String> objectFieldValues) throws ServiceException;

    boolean update(Map<String, String> objectFieldValues, String[] params) throws ServiceException;

    boolean delete(Map<String, String> objectFieldValues) throws ServiceException;
}
