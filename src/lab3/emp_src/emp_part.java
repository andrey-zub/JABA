package lab3.emp_src;

import lab1.res.empPart;


import java.util.ArrayList;
import java.util.List;

public class emp_part extends empPart {
        List<String> ROW;
        String CELL;

    public emp_part(int row_num, int cell_num){
        ROW =  this.data.get(row_num);
        CELL = ROW.get(cell_num);
    }

    public emp_part(int row_num){
        ROW =  this.data.get(row_num);
    }

    public emp_part(){}



    public List getRow(int i){
        ROW =  this.data.get(i);
        return ROW;
    }

    public int size(){
        ROW = this.data.get(0);
        return ROW.size();
    }




}
