package LAB4.hiber.model;

import jakarta.persistence.Query;
import LAB4.hiber.HibernateUtil;
import LAB4.hiber.entity.department;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import java.util.List;


public class DEPARTMENT extends model {
    protected List<department> LIST;

    public DEPARTMENT() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();



        System.out.println("\\SESSION[ department ][ START ]\n");
        LIST = this.getdepartmentList();

        this.stream = new Thread(this,"department");
        stream.start();
    }


    protected List<department> getdepartmentList(){
        String hql = " from department ";
        Query query = (Query) session.createQuery(hql);
        List<department> departmentList = query.getResultList();

        return departmentList;
    }

    public void show(){
        System.out.println(" ID | Department | Employee ID ");
        System.out.println("____________________________________________");
        for (department dep : this.LIST){
            System.out.print( dep.getId());
            System.out.print(" | " + dep.getName());
            System.out.println(" | " + dep.getEmployee());
            System.out.println("____________________________________________");
        }
        System.out.println("///DONE\n");
    }
    public void kill(){
        session.close();
        System.out.println("\\SESSION[ department ][ STOP ]\n");
    }

    @Override
    public void run() {



    }

    public void dropData(){
        Transaction tx = null;
        try { tx = session.beginTransaction();
                String hql = "DELETE  FROM department";
                session.createQuery(hql).executeUpdate();
            tx.commit();
        } catch (HibernateException ex) {  if(tx != null) tx.rollback();   }
    }

    public void addEmpDep() {
        EMP_FULL empf = new EMP_FULL();
        department dep = new department();
        Transaction tx = null;


        try { tx = session.beginTransaction();


                       Long rand = (long) (Math.random() * (1000) + 1);
                           dep.setName("dep" + empf.getEmpFullList().get(3).getArea()*10);
                           dep.setId(rand);
                           dep.setEmployee(empf.getEmpFullList());
                       session.save(dep);
                       tx.commit();




        } catch (HibernateException ex) {  if(tx != null) tx.rollback();   }









    }



}
