package lab1.res;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class empList {


    protected ArrayList<employee_abstract> LIST ;

    public empList(){
        this.LIST =  new ArrayList<>();
    }
    public void push(employee_abstract emp){
        this.LIST.add(emp);
    }





    public void writeFile(String pth){
        jurnal j = new jurnal();
        try{

            FileOutputStream fos = new FileOutputStream(pth);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(    this.LIST    );
            fos.close();
            j.print("------Serialize_[OK]---------");

        } catch(IOException e){
            j.print("------Serialize_[!ERR!]------");
            j.print(e.getMessage());

        }
    }


    public  void  readFile(String pth){

        jurnal j = new jurnal();
        try{

            FileInputStream fis = new FileInputStream(pth);
            ObjectInputStream ois = new ObjectInputStream(fis);


            this.LIST = (ArrayList) ois.readObject() ;

            ois.close();
            j.print("------DeSerialize_[OK]---------");

        } catch(IOException e){
            j.print("------DeSerialize_[!ERR!]------");
            j.print(e.getMessage());

        } catch (ClassNotFoundException e) {
            j.print("------DeSerialize_[!ERR!]------");
            j.print(e.getMessage());
        }

    }

    public void showEmp(){
        empFull full;
        empPart part;
        System.out.println("////////////////////////////////////////////////////////////");
        System.out.println("_______________List_of_emp_objects______________");
        System.out.println(this.LIST);
        System.out.println("////////////////////////////////////////////////////////////");
        System.out.println("_______________List_of_emp______________________");
        for (Object obj: this.LIST){
            if (obj instanceof lab1.res.empFull) {
                    full = (empFull) obj;
                    full.show();
            }
            if (obj instanceof lab1.res.empPart) {
                    part = (empPart) obj;
                    part.show();
            }
        }
    }






}
