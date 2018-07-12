package aglf.data.dao.commons;

import java.io.Serializable;
import java.util.List;

/**
 * @param <IdT> type of entity key
 * @param <T>   entity type
 */
public interface AbstractDao<IdT extends Serializable, T> {

    /**
     * Finds entity by it's primary key
     *
     * @param idT
     * @return
     */
    T findById(IdT idT);

    /**
     * Finds all entities
     *
     * @return
     */
    List<T> findAll();

    /**
     * Finds all entities
     *
     * @return
     */
    List<T> findAllWithLimit(int maxResults);

    /**
     * Saves entity to database
     *
     * @param entity
     */
    void save(T entity);

    void saveAll(List<T> entityList);

    /**
     * Deletes entity from database
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * Deletes entity from database identified by it's id
     *
     * @param entityId id of the entity to be deleted
     */
    void delete(IdT entityId);

    /**
     * Merges detached entity with context
     *
     * @param entity entity to merge
     * @return merged instance
     */
    T merge(T entity);

    /**
     * Loads entity by primary key
     *
     * @param entityId id of entity to load
     * @return proxy to T entity
     */
    T loadById(IdT entityId);

    /**
     * Flushes current session
     */
    void flush();

    void clear();
}
