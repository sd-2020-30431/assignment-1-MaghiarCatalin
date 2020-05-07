import connection.HibernateConfig;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DTO {

    static SessionFactory sessionFactory;

    private final static Session session = HibernateConfig.Instance();

    public static void setUpConnection() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
            System.err.println("Error in hibernate: ");
            e.printStackTrace();
            return;
        }
    }


    public static <T> T findById(Class<T> clasz, int id) {
        // Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T toReturn = null;
        toReturn = session.find(clasz, Integer.valueOf(id));
        transaction.commit();
        return toReturn;
    }


    public static <T> int save(T toSave) {
        //Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        int savedId = (int) session.save(toSave);
        transaction.commit();
        return savedId;
    }


    public static <T> void delete(T toDelete) {
        // Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(toDelete);
        transaction.commit();
    }


    public static <T> List<T> getAll(Class<T> className) {
//        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Criteria criteria = session.createCriteria(className);
        transaction.commit();
        return criteria.list();
    }


    public static <T> void update(T toUpdate) {
//      Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(toUpdate);
        transaction.commit();
    }
}
