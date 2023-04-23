package lab4.hiber;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            System.out.println("///////////////////////////////////SERVER_CONNECTION_[ UP ]////////////////////////////////////////");
        } catch (Exception e){
            System.out.println("///////////////////////////////////SERVER_CONNECTION_[ DOWN ]////////////////////////////////////////");
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static  SessionFactory getSessionFactory() { return sessionFactory; }

}
