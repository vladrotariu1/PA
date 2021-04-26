package com.lab9.entityManager;

import com.lab9.entities.GenresEntity;
import com.lab9.util.SingletonEntity;

import javax.persistence.*;
import java.util.List;

public class GenresEntityManager implements AbstractRepositoryInterface<GenresEntity>{
    private static final EntityManagerFactory EMF = SingletonEntity.getEntityManagerFactory();


    @Override
    public void create(GenresEntity entity) {
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
    public void findById(int id) {
        EntityManager em = EMF.createEntityManager();

        String query = "SELECT genres FROM GenresEntity genres WHERE genres.id = :genresID";

        TypedQuery<GenresEntity> tq = em.createQuery(query, GenresEntity.class);
        tq.setParameter("genresID", id);

        GenresEntity genre = null;

        try {
            genre = tq.getSingleResult();
            System.out.println("ID: " + genre.getId() + "  Gen: " + genre.getType());
        }
        catch (NoResultException ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void findByName(String name) {
        EntityManager em = EMF.createEntityManager();
        Query query = em.createQuery("SELECT genres from GenresEntity genres WHERE genres.type like :name ");
        List genres = query.setParameter("name", name).getResultList();
        em.close();
        System.out.println(genres.isEmpty()? null : genres.get(0).toString());
    }
}
