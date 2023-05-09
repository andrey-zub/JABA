package emp_logic;

import emp_logic.emp_src.EMP;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {



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



//        System.out.println("//////////////////////DISCONNECT_BD//////////////////////////////");

        EMP e = new EMP(true);
        //-----------------------INSERT empFull с переменными значениями
        e.create_new_empFull("Max","Bocharov","Backend",6,140);
        //-------------------------PrepareStatment-----------------------
        e.selectPrepare(1,10);

        //----------------DIRTY_READ----------------------
        // dirtyRead dirt = new dirtyRead();











    }
}
