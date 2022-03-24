package w.jpaDao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import w.dao.Dao;
import w.model.SessionUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public abstract class JpaDao<T> implements Dao<T> {

    @Override
    public Optional<T> find(Class<T> entityClass, int id) {
        try (final Session session = SessionUtil.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            T entity = session.get(entityClass, id);
            transaction.commit();
            return Optional.ofNullable(entity);
        }
    }

    @Override
    public void create(Object obj) {
        try (final Session session = SessionUtil.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(obj);
            transaction.commit();
        }
    }

    @Override
    public void delete(Object obj) {
        try (final Session session = SessionUtil.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(obj);
            transaction.commit();
        }
    }

    @Override
    public void update(Object obj) {
        try (final Session session = SessionUtil.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.update(obj);
            transaction.commit();
        }
    }

    @Override
    public List findAll(Class<T> entityClass) {
        try (final Session session = SessionUtil.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> rootEntry = cq.from(entityClass);
            CriteriaQuery<T> all = cq.select(rootEntry);
            Transaction transaction = session.getTransaction();
            transaction.begin();
            List<T> results = session.createQuery(all).getResultList();
            transaction.commit();
            return results;
        }
    }

    @Override
    public void deleteAll(Class<T> entityClass) {
        try (final Session session = SessionUtil.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaDelete<T> delete = cb.createCriteriaDelete(entityClass);
            delete.from(entityClass);
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.createQuery(delete).executeUpdate();
            transaction.commit();
        }
    }
}
