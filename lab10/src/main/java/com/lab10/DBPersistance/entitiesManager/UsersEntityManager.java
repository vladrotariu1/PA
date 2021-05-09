package com.lab10.DBPersistance.entitiesManager;

import com.lab10.DBPersistance.entities.FriendshipsEntity;
import com.lab10.DBPersistance.entities.UsersEntity;
import com.lab10.DBPersistance.util.SingletonEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class UsersEntityManager implements AbstractRepositoryInterface<UsersEntity>{
    private static final EntityManagerFactory EMF = SingletonEntity.getEntityManagerFactory();

    @Override
    public void create(UsersEntity entity) throws Exception{
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction entityTransaction = null;

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(entity);
            entityTransaction.commit();
        } catch (Exception ex) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            ex.printStackTrace();
            throw ex;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public UsersEntity findById(int id) {
        EntityManager em = EMF.createEntityManager();

        String query = "SELECT user FROM UsersEntity user WHERE user.id = :userID";
        TypedQuery<UsersEntity> tq = em.createQuery(query, UsersEntity.class);

        tq.setParameter("userID", id);

        UsersEntity user = tq.getSingleResult();
        em.close();

        return user;
    }

    public UsersEntity findByName(String name) throws Exception{
        EntityManager em = EMF.createEntityManager();

        String query = "SELECT user FROM UsersEntity user WHERE user.name like :userNAME";
        TypedQuery<UsersEntity> tq = em.createQuery(query, UsersEntity.class);

        tq.setParameter("userNAME", name);

        UsersEntity user = tq.getSingleResult();
        em.close();

        return user;
    }

    public ArrayList<UsersEntity> getAllUsers() {
        EntityManager em = EMF.createEntityManager();
        String query = "SELECT user FROM UsersEntity user";
        TypedQuery<UsersEntity> tq = em.createQuery(query, UsersEntity.class);

        return (ArrayList<UsersEntity>) tq.getResultList();
    }
}
