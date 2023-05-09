package emp_logic.emp_src;



import data_src.res.empFull;

import java.util.List;

public class emp_full extends empFull {

    List<String> ROW;
    String CELL;

    public emp_full(int row_num, int cell_num){
        ROW =  this.data.get(row_num);
        CELL = ROW.get(cell_num);
    }

    public emp_full(int row_num){
        ROW =  this.data.get(row_num);
    }

    public emp_full(){}

    public List getRow(int i){
        ROW =  this.data.get(i);
        return ROW;
    }

    public int size(){
        ROW = this.data.get(0);
        return ROW.size();
    }


}
