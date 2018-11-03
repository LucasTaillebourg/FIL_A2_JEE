package com.jee.crud.facade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Generic CRUD facade interface
 * @param <T> Entity type
 */
public interface IEntityFacade<T> {

    /**
     * Insert object
     * @param entity Entity
     */
    void create(T entity) throws EntityExistsException, IllegalStateException,
            IllegalArgumentException, TransactionRequiredException;

    /**
     * Select object
     * @param entity Entity class
     * @param primaryKey PrK
     * @return Requested object
     */
    T read(Class<T> entity, Serializable primaryKey) throws IllegalStateException,
            IllegalArgumentException;

    /**
     * Update object
     * @param entity Entity
     */
    void update(T entity) throws IllegalStateException,
            IllegalArgumentException, TransactionRequiredException;

    /**
     * Delete object
     * @param entity Entity
     */
    void delete(T entity) throws IllegalStateException,
            IllegalArgumentException, PersistenceException;

    /**
     * Find objects with custom query
     * @param queryString Query
     * @return Objects
     */
    Collection customSearch(String queryString, Map<String, T> queryParameters);

}
