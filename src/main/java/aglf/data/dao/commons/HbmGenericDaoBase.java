package aglf.data.dao.commons;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @param <IdT>
 * @param <E>
 */
public class HbmGenericDaoBase<IdT extends Serializable, E> implements AbstractDao<IdT, E> {

    /**
     * Hibernate session factory instance
     */
    @Autowired
    private SessionFactory sessionFactory;
    /**
     * Entity class instance used for db operations.
     */
    private Class<E> entityClass;

    public HbmGenericDaoBase() {
    }

    public HbmGenericDaoBase(Class<E> entityClass) {
        super();
        this.entityClass = entityClass;
    }

    public E findById(IdT id) {
        E result = (E) getSessionFactory().getCurrentSession().get(entityClass, id);
        return result;
    }

    public List<E> findAll() {
        Session currentSession = getSessionFactory().getCurrentSession();
        List<E> list = currentSession.createCriteria(entityClass).list();
        return list;
    }

    public List<E> findAllWithLimit(int maxResults) {
        Session currentSession = getSessionFactory().getCurrentSession();
        Criteria criteria = currentSession.createCriteria(entityClass);
        criteria.setMaxResults(maxResults);
        List<E> list = criteria.list();
        return list;
    }

    public void saveAll(List<E> entityList) {
        for (E entity : entityList) {
            save(entity);
        }
    }

    public void save(E entity) {
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(E entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    @Override
    public E merge(E entity) {
        Session currentSession = getSessionFactory().getCurrentSession();
        E merged = (E) currentSession.merge(entity);
        return merged;
    }

    @Override
    public void delete(IdT entityId) {
        Session currentSession = getSessionFactory().getCurrentSession();
        Object object = currentSession.load(entityClass, entityId);
        currentSession.delete(object);
    }

    @Override
    public E loadById(IdT entityId) {
        E result = (E) getSessionFactory().getCurrentSession().load(entityClass, entityId);
        return result;
    }

    @Override
    public void flush() {
        getSession().flush();
    }

    @Override
    public void clear() {
        getSession().clear();
    }

    protected SessionFactory getSessionFactory() {
        sessionFactory.getCurrentSession().setFlushMode(FlushMode.COMMIT);
        return sessionFactory;
    }

    protected Session getSession() {
        return getSessionFactory().getCurrentSession();
    }
}

