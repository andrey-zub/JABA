package lab3;

import lab3.emp_src.dirtyRead;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        dirtyRead dirt = new dirtyRead();

        // чтение данных из csv
//        data emps = new data();

        /// формирование подключения к БД emp
//        System.out.println("//////////////////////CONNECT_BD//////////////////////////////");
//        EMP emp = new EMP(true);
//        emp.kill();

        //-------------INSERT empPart csv
//        for (int k = 0 ;k < emps.getPartEmp().size(); k++){
//            emp.add_empPart( emps.getPartEmp() ,k );
//        }
        //-------------INSERT empFull csv
//        for (int k = 0 ;k < emps.getFullEmp().size(); k++){
//            emp.add_empFull( emps.getFullEmp() ,k );
//        }

//        //-----------------------INSERT empFull с переменными значениями
//        String empf_f_name =     "Vladimir";
//        String empf_l_name =     "Svij";
//        String empf_special =    "System administrator";
//        int empf_area =           5;
//        double empf_salary =      152.5;
//        emp.create_new_empFull(empf_f_name,empf_l_name,empf_special,empf_area,empf_salary);

//        System.out.println("//////////////////////DISCONNECT_BD//////////////////////////////");













    }
}
