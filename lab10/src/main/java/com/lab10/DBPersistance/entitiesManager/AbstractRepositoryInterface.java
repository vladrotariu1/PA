package com.lab10.DBPersistance.entitiesManager;

public interface AbstractRepositoryInterface<T> {
    void create(T entity);
    T findById(int id);
}
