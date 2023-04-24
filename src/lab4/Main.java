package lab4;

import lab4.hiber.hiber;
import lab4.hiber.model.EMP_PART;

public class Main {
    public static void main(String[] args){


        hiber hib = new hiber(); // для запуска hibernate

//        EMP_FULL empf = new EMP_FULL();
//        empf.show();
//        empf.kill();

        EMP_PART empp = new EMP_PART();
       // empp.show();

        empp.readData();

        empp.kill();

//        DEPARTMENT depr = new DEPARTMENT();
//        depr.show();
//        depr.kill();



    }
}
