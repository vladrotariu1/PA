package com.lab9.entityManager;

public interface AbstractRepositoryInterface<T> {
    void create(T entity);
    void findById(int id);
    void findByName(String name);
}
