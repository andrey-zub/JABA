package lab3;

import lab3.emp_src.EMP;
import lab3.emp_src.data;
import lab3.emp_src.dirtyRead;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

      //  data emps = new data(); // чтение данных из csv

//        System.out.println("//////////////////////CONNECT_BD//////////////////////////////");
//        EMP emp = new EMP(true); // формирование подключения к БД emp
//        emp.kill();
//        System.out.println("//////////////////////DISCONNECT_BD//////////////////////////////");

        dirtyRead drt_rd = new dirtyRead();


    }
}
