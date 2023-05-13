package LAB1.res;

import java.util.ArrayList;
import java.util.List;

public class empPart extends employee_abstract {

    protected List<String> area = new ArrayList<>();
    protected List<String> salary = new ArrayList<>();
    protected List<String> contract = new ArrayList<>();



    @Override
    public void init(List<List<String>> ll) {


        for (List<String> row : ll){

            int area = (int) (Math.random() * ( 10 - 1  )) ;
            int id = (int) (Math.random() * ( area * 100- area  )) + area*1000 + 1;
            double  salary = (int) (Math.random() * (250 - 100 ) + 100);
            int month = (int) ( Math.random() * 36 ) + 3 ;

            if (row.contains("part")){
                this.row.add( String.valueOf(""+ id +"") );
                this.f_name.add(row.get(0));
                this.l_name.add(row.get(1));
                this.special.add(row.get(2));
                this.area.add(""+ area +"");
                this.salary.add(""+ salary +"");
                this.contract.add("for " + month + " month");
            }
        }

        this.data.add(this.row);
        this.data.add(this.f_name);
        this.data.add(this.l_name);
        this.data.add(this.special);
        this.data.add(this.area);
        this.data.add(this.salary);
        this.data.add(this.contract);

    }


}
