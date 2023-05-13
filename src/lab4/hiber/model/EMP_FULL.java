package lab4.hiber.model;

import jakarta.persistence.Query;
import lab4.hiber.HibernateUtil;
import lab4.hiber.entity.empFull;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import java.util.List;

public class EMP_FULL extends model {

    protected List<empFull> LIST;

    public EMP_FULL() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        System.out.println("\\SESSION[ empFull ][ START ]\n");
        LIST = this.getEmpFullList();

        this.stream = new Thread(this,"empFull");
        stream.start();
    }

    public void kill(){
        session.close();
        System.out.println("\\SESSION[ empFull ][ STOP ]\n");
    }





    protected List<empFull> getEmpFullList(){
       String hql = "From empFull";
       Query query = (Query) session.createQuery(hql);
       List<empFull> empFullList = query.getResultList();

       return empFullList;
    }

    public void show(){
        System.out.println(" ID | First name | Last name | Special |  Area | Salary ");
        for (empFull empf : this.LIST){
            System.out.println("____________________________________________");
            System.out.print( empf.getId());
            System.out.print(" | " + empf.getF_name());
            System.out.print(" | " + empf.getL_name());
            System.out.print(" | " + empf.getSpecial());
            System.out.print(" | " + empf.getArea());
            System.out.println(" | " + empf.getSalary());
        }
        System.out.println("///DONE\n");
    }

    @Override
    public void run() {

    }

    public void dropData(){
        Transaction tx = null;
        try { tx = session.beginTransaction();
            String hql = "DELETE  FROM empFull";
            session.createQuery(hql).executeUpdate();
            tx.commit();
        } catch (HibernateException ex) {  if(tx != null) tx.rollback();   }
    }


}
