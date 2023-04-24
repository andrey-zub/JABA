package lab4.hiber.model;

import jakarta.persistence.Query;
import lab4.hiber.HibernateUtil;
import lab4.hiber.entity.department;
import lab4.hiber.entity.empFull;
import lab4.hiber.entity.empPart;
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
        String hql = "From department";
        Query query = (Query) session.createQuery(hql);
        List<department> departmentList = query.getResultList();

        return departmentList;
    }

    public void show(){
        System.out.println(" ID | Department | Employee ID ");
        for (department dep : this.LIST){
            System.out.println("____________________________________________");
            System.out.print( dep.getId());
            System.out.print(" | " + dep.getName());
            System.out.print(" | " + dep.getEmpid());
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
        EMP_PART empp = new EMP_PART();

               for (empFull emp : empf.getEmpFullList()){
                   Transaction tx = null;
                   department dep = new department();
                   try { tx = session.beginTransaction();
                       Long rand = (long) (Math.random() * (1000) + 1);
                           dep.setName("dep" + emp.getArea()*10);
                           dep.setId(rand);
                           dep.setEmpid(emp.getId());
                       session.save(dep);
                       tx.commit();
                   } catch (HibernateException ex) {  if(tx != null) tx.rollback();   }
               }

        for (empPart emp : empp.getempPartList()){
            Transaction tx = null;
            department dep = new department();
            try { tx = session.beginTransaction();
                Long rand = (long) (Math.random() * (1000) + 1);
                dep.setName("dep" + emp.getArea()*10);
                dep.setId(rand);
                dep.setEmpid(emp.getId());
                session.save(dep);
                tx.commit();
            } catch (HibernateException ex) {  if(tx != null) tx.rollback();   }
        }










    }



}
