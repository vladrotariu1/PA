package com.lab8.compulsory.dao;

import com.lab8.compulsory.models.Actor;

import java.sql.SQLException;

public interface ActorDao {
    int addActor(Actor actor)
            throws SQLException;
    Actor  getActor(int id)
            throws SQLException;
}
