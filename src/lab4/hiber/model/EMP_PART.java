package lab4.hiber.model;

import jakarta.persistence.Query;
import lab4.hiber.HibernateUtil;
import lab4.hiber.entity.empPart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class EMP_PART implements Runnable {
    private SessionFactory sessionFactory;
    private Session session;
    private Thread stream;
    protected List<empPart> LIST = new ArrayList<>();

    public EMP_PART() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        System.out.println("\\SESSION[ empPart ][ START ]");
        LIST = this.getempPartList();

        this.stream = new Thread(this,"empPart");
        stream.start();
    }

    public void kill(){
        session.close();
        System.out.println("\\SESSION[ empPart ][ STOP ]");
    }

    protected List<empPart> getempPartList(){
        String hql = "From empPart";
        Query query = (Query) session.createQuery(hql);
        List<empPart> empPartList = query.getResultList();

        return empPartList;
    }

    public void showEmp(){
        System.out.println(" ID | First name | Last name | Special |  Area | Salary ");
        for (empPart empp : this.LIST){
            System.out.println("____________________________________________");
            System.out.print( empp.getId());
            System.out.print(" | " + empp.getF_name());
            System.out.print(" | " + empp.getL_name());
            System.out.print(" | " + empp.getSpecial());
            System.out.print(" | " + empp.getArea());
            System.out.println(" | " + empp.getSalary());
        }
        System.out.println("///DONE\n");
    }

    @Override
    public void run() {

    }
}
