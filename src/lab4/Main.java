package lab4;

import lab4.hiber.*;
import lab4.hiber.model.*;


public class Main {
    public static void main(String[] args){


        hiber hib = new hiber(); // ��� ������� hibernate

//        EMP_FULL empf = new EMP_FULL();
//        empf.show();
//        empf.kill();

//        EMP_PART empp = new EMP_PART();
//        empp.show();
//
//        empp.kill();

        DEPARTMENT depr = new DEPARTMENT();
//        depr.addEmpDep();     // ���������� ������� � ������� � ���������

        depr.show();
        depr.kill();





    }
}
