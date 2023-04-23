package lab4.hiber;

import org.hibernate.Session;

public class hiber implements Runnable{
    private Thread stream;
    public hiber(){
        stream = new Thread(this,"hiber_start");
        stream.start();
    }
    @Override
    public void run() {
        Session session = HibernateUtil.getSessionFactory().openSession();
    }
}
