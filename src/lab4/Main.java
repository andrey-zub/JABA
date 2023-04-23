package lab4;

import lab4.hiber.hiber;
import lab4.hiber.model.EMP_FULL;

public class Main {
    public static void main(String[] args){


        hiber hib = new hiber(); // для запуска hibernate

        EMP_FULL empf = new EMP_FULL();
        empf.showEmp();



    }
}
