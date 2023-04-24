package lab4.hiber.model;

import jakarta.persistence.Query;
import lab3.emp_src.data;
import lab3.emp_src.emp_part;
import lab4.hiber.HibernateUtil;
import lab4.hiber.entity.empPart;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import java.util.List;

public class EMP_PART extends model {

    protected List<empPart> LIST;

    public EMP_PART() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        System.out.println("\\SESSION[ empPart ][ START ]\n");
        LIST = this.getempPartList();

        this.stream = new Thread(this,"empPart");
        stream.start();
    }

    public void kill(){
        session.close();
        System.out.println("\\SESSION[ empPart ][ STOP ]\n");
    }

    protected List<empPart> getempPartList(){
        String hql = "From empPart";
        Query query = (Query) session.createQuery(hql);
        List<empPart> empPartList = query.getResultList();

        return empPartList;
    }

    public void show(){
        System.out.println(" ID | First name | Last name | Special |  Area | Salary | Contract");
        for (empPart empp : this.LIST){
            System.out.println("____________________________________________");
            System.out.print( empp.getId());
            System.out.print(" | " + empp.getF_name());
            System.out.print(" | " + empp.getL_name());
            System.out.print(" | " + empp.getSpecial());
            System.out.print(" | " + empp.getArea());
            System.out.print(" | " + empp.getSalary());
            System.out.println(" | " + empp.getContract());
        }
        System.out.println("///DONE\n");
    }

    @Override
    public void run() {

    }

    public void dropData(){
        Transaction tx = null;
        try { tx = session.beginTransaction();
            String hql = "DELETE  FROM empPart ";
            session.createQuery(hql).executeUpdate();
            tx.commit();
        } catch (HibernateException ex) {  if(tx != null) tx.rollback();   }
    }

    public void readData(){

        data emps = new data(); // чтение из CSV
        emp_part emp_part = emps.getPartEmp();
        Transaction tx = null;

        System.out.println(emp_part.size());


        for (int k = 0 ;k < emp_part.size(); k++){


            empPart empp = new empPart();
            try { tx = session.beginTransaction();

                Long id = (long) Integer.parseInt(emp_part.getRow(0).get(k).toString());
                String f_name = emp_part.getRow(1).get(k).toString();
                String l_name = emp_part.getRow(2).get(k).toString();
                String special = emp_part.getRow(3).get(k).toString();
                int area = (int) Double.parseDouble(emp_part.getRow(4).get(k).toString());
                double salary = Double.parseDouble(emp_part.getRow(5).get(k).toString());
                String contract = emp_part.getRow(6).get(k).toString();

                empp.setId(id);
                empp.setF_name(f_name);
                empp.setL_name(l_name);
                empp.setSpecial(special);
                empp.setArea(area);
                empp.setContract(contract);

                session.save(empp);
                tx.commit();
            } catch (HibernateException ex) {  if(tx != null) tx.rollback();   }

        }


    }
}
