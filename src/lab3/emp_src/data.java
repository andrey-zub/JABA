package lab3.emp_src;

import lab1.res.csvReader;
import lab1.res.path;

public class data implements Runnable{

    protected Thread stream;

    protected  emp_part emp_p = new emp_part();
    protected  emp_full emp_f = new emp_full();

    public data(){
        this.stream = new Thread(this, "read_csv");
        stream.start();
    }

    @Override
    public void run() {

        System.out.println("//////////////////////GET_DATA_START//////////////////////////////");

        String file = new path().get_data();
        csvReader csv = new csvReader();



        emp_p.init (csv.readDataWith( file , ";" ) );
        emp_f.init(csv.readDataWith(file, ";"));

//        emp_p.show();
//        emp_f.show();

        System.out.println("//////////////////////GET_DATA_STOP//////////////////////////////");

    }

    public emp_full getFullEmp(){
        return this.emp_f;
    }

    public emp_part getPartEmp(){
        return this.emp_p;
    }



}
