package com.almod.dao;

import java.util.List;

public interface BaseDAO<T> {
    public List<T> findAll();
}
