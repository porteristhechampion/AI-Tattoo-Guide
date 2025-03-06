package edu.matc.entjava.persistence;


import edu.matc.entjava.entity.Suggestion;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import java.util.List;


public class SuggestionDAO {

    private static final Logger logger = LogManager.getLogger(SuggestionDAO.class);
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public Suggestion getById(int id) {
        Session session = sessionFactory.openSession();
        Suggestion suggestion = session.get(Suggestion.class, id);
        session.close();
        return suggestion;
    }

    public void update(Suggestion suggestion) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(suggestion);
        transaction.commit();
        session.close();
    }

    public int insert(Suggestion suggestion) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(suggestion);
        transaction.commit();
        id = suggestion.getId();
        session.close();
        return id;
    }

}
