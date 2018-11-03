package com.jee.crud;

import com.jee.crud.facade.IEntityFacade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Generic CRUD facade implementation
 * @param <T> Entity type
 */
public class CRUDEntityFacade<T> implements IEntityFacade<T> {

    private static final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("databaseJEE");

    /**
     * Insert object
     * @param entity Entity
     */
    @Override
    public void create(final T entity) throws EntityExistsException, IllegalStateException,
            IllegalArgumentException, TransactionRequiredException {

        EntityManager em = emf.createEntityManager();
        EntityTransaction createTransaction = null;

        try {
            createTransaction = em.getTransaction();
            createTransaction.begin();
            System.out.println("Create transaction started");

            em.persist(entity);
            createTransaction.commit();
            System.out.println("Create transaction succeeded");
        } catch (PersistenceException e) {
            System.out.println("Create transaction error : " + e.getMessage());
            if (createTransaction != null) {
                createTransaction.rollback();
                System.out.println("Create transaction rollback done to undo database operations !\n" + e.getMessage());
            }
        } finally {
            em.close();
            System.out.println("Create's entity manager closed");
        }
    }

    /**
     * Select object
     * @param entity Entity class
     * @param primaryKey Primary key
     * @return Requested object
     */
    @Override
    public T read(final Class<T> entity, final Serializable primaryKey) throws IllegalStateException,
            IllegalArgumentException {
        EntityManager em = emf.createEntityManager();
        T entities = null;

        try {
            System.out.println("Read transaction started");
            entities = em.find(entity, primaryKey);
            System.out.println("Read transaction succeeded");
        } catch (PersistenceException e) {
            System.out.println("Read transaction error : " + e.getMessage());

        } finally {
            em.close();
            System.out.println("Read's entity Manager closed");
            return entities;
        }
    }

    /**
     * Update object
     * @param entity Entity
     */
    @Override
    public void update(final T entity) throws IllegalStateException,
            IllegalArgumentException, TransactionRequiredException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction updateTransaction = null;

        try {
            updateTransaction = em.getTransaction();
            updateTransaction.begin();
            System.out.println("Update transaction started");

            em.persist(entity);
            updateTransaction.commit();
            System.out.println("Update transaction succeeded");
        } catch (PersistenceException e) {
            System.out.println("Update transaction error : " + e.getMessage());
            if (updateTransaction != null) {
                updateTransaction.rollback();
                System.out.println("Update transaction rollback done to undo database operations !\n" + e.getMessage());
            }
        } finally {
            em.close();
            System.out.println("Update's entity Manager closed");
        }
    }

    /**
     * Delete object
     * @param entity Entity
     */
    @Override
    public void delete(final T entity) throws IllegalStateException,
            IllegalArgumentException, PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction deleteTransaction = null;

        try {
            deleteTransaction = em.getTransaction();
            deleteTransaction.begin();
            System.out.println("Delete transaction started");

            em.remove(entity);
            deleteTransaction.commit();
            System.out.println("Delete transaction succeeded");
        } catch (PersistenceException e) {
            System.out.println("Delete transaction error : " + e.getMessage());
            if (deleteTransaction != null) {
                deleteTransaction.rollback();
                System.out.println("Delete transaction rollback done to undo database operations !\n" + e.getMessage());
            }
        } finally {
            em.close();
            System.out.println("Delete's entity manager closed");
        }

    }

    /**
     * Find objects with custom query
     * @param queryString Query
     * @return Objects
     */
    @Override
    public Collection customSearch(String queryString, Map<String, T> queryParameters) {
        EntityManager em = emf.createEntityManager();
        List entities = null;

        try {
            System.out.println("Custom Search started");
            Query query = em.createQuery(queryString);
            if(queryParameters != null && !queryParameters.isEmpty()) {
                for(Map.Entry<String, T> entry : queryParameters.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }
            entities = query.getResultList();
            System.out.println("Custom Search succeeded");
        } catch (PersistenceException e) {
            System.out.println("Custom Search error : " + e.getMessage());
        } finally {
            em.close();
            System.out.println("Custom Search's entity manager closed");
            return entities;
        }
    }

}
