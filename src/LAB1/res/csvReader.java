package LAB1.res;



import java.io.*;
import java.util.*;

public  class csvReader extends LAB1.res.path  {

    public  List<List<String>> readDataWith(String pth,String delimiter) {

        List<List<String>> data = new ArrayList<>();

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(pth))) {
            while((line = br.readLine()) != null){
                data.add( Arrays.asList(line.split(delimiter)) );
            }

        } catch (IOException e) {  e.printStackTrace(); }

        System.out.println("____________File_readed_________");
        System.out.println(pth);
        return data;
    }


}
