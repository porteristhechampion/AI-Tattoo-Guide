package edu.matc.entjava.persistence;


import edu.matc.entjava.entity.BaseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TattooDAO<T extends BaseEntity> {

    private static final Logger logger = LogManager.getLogger(TattooDAO.class);
    private final Class<T> type;

    public TattooDAO(Class<T> type) {
        this.type = type;
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

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

    public void update(T entity) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.merge(entity);
        tx.commit();
        session.close();
    }

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

    public void delete(T entity) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        session.close();
    }

//    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
//
//    public Suggestion getById(int id) {
//        Session session = sessionFactory.openSession();
//        Suggestion suggestion = session.get(Suggestion.class, id);
//        session.close();
//        return suggestion;
//    }
//
//    public void update(Suggestion suggestion) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.merge(suggestion);
//        transaction.commit();
//        session.close();
//    }
//
//    public int insert(Suggestion suggestion) {
//        int id = 0;
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.persist(suggestion);
//        transaction.commit();
//        id = suggestion.getId();
//        session.close();
//        return id;
//    }

}
