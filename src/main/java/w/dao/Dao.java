package w.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    /**
     * Get entity from id
     *
     * @param entityClass class to fnd
     * @param id          entity  id
     * @return optional which contains entity
     */
    Optional<T> find(Class<T> entityClass, int id);

    /**
     * Add entity to database
     *
     * @param obj entity to add
     * @return id of new entity
     */
    void create(T obj);

    /**
     * Delete entity to database
     *
     * @param obj entity to delete
     */
    void delete(T obj);

    /**
     * Update entity in database
     *
     * @param obj entity to update
     */
    void update(T obj);


    /**
     * Get all entity in database
     *
     * @param entityClass entity class to update
     */
    List<T> findAll(Class<T> entityClass);

    /**
     * Delete all entity to database
     *
     * @param entityClass entity class to update
     */
    void deleteAll(Class<T> entityClass);
}
