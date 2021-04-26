package com.lab9.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEntity {
    private static EntityManagerFactory EMF;

    private SingletonEntity(){}

    public static EntityManagerFactory getEntityManagerFactory() {
        if (EMF == null)
            EMF = Persistence.createEntityManagerFactory("Laborator9");
        return EMF;
    }
}
