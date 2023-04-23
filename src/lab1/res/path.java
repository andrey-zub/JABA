package lab1.res;

import java.io.File;

public class path {


    protected  String sepr = File.separator;

    protected  String src = "src" + sepr + "lab1" + sepr +"res" + sepr ;

    protected String get_path(){   return this.src;  }


    public  String get_csv(){
            String str = src +  "src.csv";
            return str;
    }
    public String get_jurnal(){
            String str = src  +  "jurnal.txt";
            return str;
    }

    public String get_emp_list(){
        String str =  src +  "emp_list.bin";
        return str;
    }

    public String get_data(){

       String  str = "src" + sepr + "lab1";

        return str + sepr + get_csv();
    }




}
