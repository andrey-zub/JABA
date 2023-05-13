package LAB4;

import LAB4.hiber.hiber;
import LAB4.hiber.model.DEPARTMENT;


public class Main {
    public static void main(String[] args){


        hiber hib = new hiber(); // для запуска hibernate

//        EMP_FULL empf = new EMP_FULL();
//        empf.show();
//        empf.kill();

//        EMP_PART empp = new EMP_PART();

//        empp.dropData();
//        empp.show();

//        System.out.println("----------emp_part_list------------");
//        for (empPart el : empp.getempPartList()){
//            System.out.print("id: "+ el.getId());
//            System.out.print("\t fio: " + el.getF_name()  + el.getL_name() );
//            System.out.print("\t special: " + el.getSpecial());
//            System.out.print("\t area: "+ el.getArea());
//            System.out.print("\t contract "+ el.getContract());
//            System.out.println("--------------------------");
//        }

//        empp.kill();

        DEPARTMENT depr = new DEPARTMENT();
       depr.addEmpDep();     // добавление записей в таблице с кафедрами
        depr.show();
        depr.kill();









    }
}
