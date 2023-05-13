package LAB4.hiber.model;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class model implements Runnable {

    protected SessionFactory sessionFactory;
    protected Session session;
    protected Thread stream;
    protected Query qr;


    public void kill() {}
    public void show(){}

}
