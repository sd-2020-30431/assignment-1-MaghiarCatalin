package client_server.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class HibernateAbstractCrudRepository<ID extends Serializable, T> implements CrudRepository<ID, T> {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("factory");

    protected abstract Class<T> getValueClass();

    @Override
    public void save(T value) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(value);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(T value) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(value);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(ID id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println(id);
        T entity = entityManager.find(this.getValueClass(), id);
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public Optional<T> getById(ID id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return Optional.ofNullable(entityManager.find(this.getValueClass(), id));
    }

    @Override
    public List<T> getAll() {

        Session session = this.getCurrentSession();
        Class<T> valueClass = this.getValueClass();
        return session.createQuery("from " + valueClass.getName(), valueClass).list();
    }

    protected Session getCurrentSession() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session hibernateSession = (Session) entityManager.getDelegate();
        return hibernateSession;
    }

    protected EntityManager getCurrentEntity() {
        return entityManagerFactory.createEntityManager();
    }
}
