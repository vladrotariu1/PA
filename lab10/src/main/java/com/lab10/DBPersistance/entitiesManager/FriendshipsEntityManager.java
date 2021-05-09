package com.lab10.DBPersistance.entitiesManager;

import com.lab10.DBPersistance.entities.FriendshipsEntity;
import com.lab10.DBPersistance.util.SingletonEntity;

import javax.persistence.*;
import java.util.ArrayList;

public class FriendshipsEntityManager implements AbstractRepositoryInterface<FriendshipsEntity>{
    private static final EntityManagerFactory EMF = SingletonEntity.getEntityManagerFactory();

    @Override
    public void create(FriendshipsEntity entity) throws Exception{
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
    public FriendshipsEntity findById(int id) {
        EntityManager em = EMF.createEntityManager();

        String query = "SELECT friendship FROM FriendshipsEntity friendship WHERE friendship.friendship.id_1 = :friendshipID";
        TypedQuery<FriendshipsEntity> tq = em.createQuery(query, FriendshipsEntity.class);

        tq.setParameter("friendshipID", id);

        FriendshipsEntity friendship = tq.getSingleResult();
        em.close();

        return friendship;
    }

    public FriendshipsEntity findFriendship(int userId1, int userId2) {
        EntityManager em = EMF.createEntityManager();

        String query = "SELECT friendship FROM FriendshipsEntity friendship " +
                "WHERE friendship.friendship.id_1 = :friendshipID1 AND friendship.friendship.id_2 = :friendshipID2";
        TypedQuery<FriendshipsEntity> tq = em.createQuery(query, FriendshipsEntity.class);

        tq.setParameter("friendshipID1", userId1);
        tq.setParameter("friendshipID2", userId2);

        FriendshipsEntity friendship = tq.getSingleResult();
        em.close();

        return friendship;
    }

    public ArrayList<FriendshipsEntity> getFriendships() {
        EntityManager em = EMF.createEntityManager();
        String query = "SELECT friendship FROM FriendshipsEntity friendship";
        TypedQuery<FriendshipsEntity> tq = em.createQuery(query, FriendshipsEntity.class);

        return (ArrayList<FriendshipsEntity>) tq.getResultList();
    }
}
