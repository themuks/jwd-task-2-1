package com.kuntsevich.task1.model.dao;

import com.kuntsevich.task1.entity.Criteria;
import com.kuntsevich.task1.exception.DaoException;

public interface Dao<T> {
    T find(Criteria criteria) throws DaoException;
}
