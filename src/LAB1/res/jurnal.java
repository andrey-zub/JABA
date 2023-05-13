package LAB1.res;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class jurnal extends LAB1.res.path {

    protected String path = new  path().get_jurnal();



    public void print(String str){
        try(FileWriter writer = new FileWriter(this.path, true))
        {
            writer.write(str);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){  System.out.println(ex.getMessage()); }

    }
    public  void clear() {
        try(FileWriter fwOb = new FileWriter(this.path, false))
        {
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            fwOb.close();
            pwOb.close();

        }
        catch(IOException ex){  System.out.println(ex.getMessage()); }
    }
}
