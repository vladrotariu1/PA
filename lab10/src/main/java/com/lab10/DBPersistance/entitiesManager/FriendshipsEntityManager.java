package com.lab10.DBPersistance.entitiesManager;

import com.lab10.DBPersistance.entities.FriendshipsEntity;
import com.lab10.DBPersistance.util.SingletonEntity;

import javax.persistence.*;

public class FriendshipsEntityManager implements AbstractRepositoryInterface<FriendshipsEntity>{
    private static final EntityManagerFactory EMF = SingletonEntity.getEntityManagerFactory();

    @Override
    public void create(FriendshipsEntity entity) {
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
}
