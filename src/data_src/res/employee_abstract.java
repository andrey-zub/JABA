package data_src.res;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class employee_abstract implements employee_int, Serializable {
   protected List<List<String>> data = new ArrayList<>();
   protected List<String> f_name = new ArrayList<>();
   protected List<String> l_name = new ArrayList<>();
   protected List<String> special = new ArrayList<>();
   protected  List<String> row = new ArrayList<>();

   @Override
   public List<List<String>> getData(){  return this.data;  }

   @Override
   public void show() {

      System.out.println("-----------Employee_Part--------------");

      for (List<String> row : this.data){
         for (String cell : row ){
            System.out.print( cell + "\t|\t\t" );
         }
         System.out.println();
      }


   }

}
