package edu.matc.entjava.persistence;


import edu.matc.entjava.entity.BaseEntity;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * This is a generic DAO class for the suggestion, user and style entities.
 * It performs all CRUD operations for the database.
 * @param <T> entity type
 *
 * @author ptaylor
 */
public class TattooDAO<T extends BaseEntity> {

    private static final Logger logger = LogManager.getLogger(TattooDAO.class);
    private final Class<T> type;

    /**
     * Sets type when class is instantiated.
     * @param type entity type
     */
    public TattooDAO(Class<T> type) {
        this.type = type;
    }

    /**
     * Returns a session variable.
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Returns an object based on
     * a given id.
     * @param id entity id
     * @return entity object
     */
    public T getById(int id) {
        Session session = getSession();
        T entity = session.get(type, id);
        session.close();
        if (entity == null) {
            logger.error("Entity not found");
        } else {
            logger.info(entity.toString());
        }
        return entity;
    }

    /**
     * Returns all suggestions based on a user id
     * @param id user id
     * @return list of all suggestions
     */
    public List<T> getAllByID(int id) {
        Session session = getSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        Root<T> root = criteria.from(type);

        criteria.where(builder.equal(root.get("user").get("id"), id));
        List<T> list = session.createQuery(criteria).getResultList();

        logger.debug(list.toString());
        session.close();
        return list.isEmpty() ? null : list;
    }

    /**
     * Updates a given record in the database.
     * @param entity entity type
     */
    public void update(T entity) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.merge(entity);
        tx.commit();
        session.close();
    }

    /**
     * Inserts a new row into the database.
     * @param entity entity type
     * @return new record id
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        id = entity.getId();
        session.close();
        return id;
    }

    /**
     * Deletes a row from the database.
     * @param entity entity type
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        session.close();
    }

}
