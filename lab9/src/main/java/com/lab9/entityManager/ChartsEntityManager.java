package com.lab9.entityManager;

import com.lab9.entities.ChartsEntity;
import com.lab9.util.SingletonEntity;

import javax.persistence.*;
import java.util.List;

public class ChartsEntityManager implements AbstractRepositoryInterface<ChartsEntity>{
    private static final EntityManagerFactory EMF = SingletonEntity.getEntityManagerFactory();

    @Override
    public void create(ChartsEntity entity) {
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

        String query = "SELECT movies FROM ChartsEntity movies WHERE movies.id = :moviesID";

        TypedQuery<ChartsEntity> tq = em.createQuery(query, ChartsEntity.class);
        tq.setParameter("moviesID", id);

        ChartsEntity movie = null;

        try {
            movie = tq.getSingleResult();
            System.out.println("ID: " + movie.getId() + " TITLU: " + movie.getTitle() +  " DATA LANSARII: " + movie.getReleaseDate() + " RATING: " + movie.getRating());
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
        Query query = em.createQuery("SELECT movie from ChartsEntity movie WHERE movie.title like :title ");
        List movies = query.setParameter("title", name).getResultList();
        em.close();
        System.out.println(movies.isEmpty()? null : movies.get(0).toString());
    }
}
