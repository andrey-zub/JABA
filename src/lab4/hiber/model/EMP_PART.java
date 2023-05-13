package lab4.hiber.model;


import emp_logic.emp_src.data;
import emp_logic.emp_src.emp_part;
import jakarta.persistence.Query;
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




    public List<empPart> getempPartList(){
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
        this.readData();
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

        Transaction tx = null;
        emp_part emps = new data().getPartEmp(); // чтение из CSV

        for ( List<String> row : emps.getData()  ){

            empPart empp = new empPart();

            try { tx = session.beginTransaction();
                Long id = (long) Integer.parseInt(row.get(0).toString());
                String f_name = row.get(1).toString();
                String l_name = row.get(2).toString();
                String special = row.get(3).toString();
                int area = (int) Double.parseDouble(row.get(4).toString());
                double salary = Double.parseDouble(row.get(5).toString());
                String contract = row.get(6).toString();

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
