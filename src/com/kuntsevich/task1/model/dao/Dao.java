package com.kuntsevich.task1.model.dao;

import com.kuntsevich.task1.entity.Criteria;
import com.kuntsevich.task1.exception.DaoException;

import java.util.List;

public interface Dao<T> {
    List<T> find(Criteria criteria) throws DaoException;
}
