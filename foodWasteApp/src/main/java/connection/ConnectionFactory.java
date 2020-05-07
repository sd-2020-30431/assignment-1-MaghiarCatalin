package connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConnectionFactory {

    public static SessionFactory factory;
    //singleton

    private ConnectionFactory() {

    }

    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null) {
            // A SessionFactory is set up once for an application!
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            try {
                factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                StandardServiceRegistryBuilder.destroy(registry);
                System.err.println("Error in hibernate: ");
                e.printStackTrace();
                //return;
            }
        }
        return factory;
    }

    public static void close() {
        factory.close();
    }

}
