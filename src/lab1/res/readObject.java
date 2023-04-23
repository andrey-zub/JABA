package lab1.res;

import java.util.List;

public class readObject {

    public void check(List<List<String>> ll){
        if (ll.isEmpty()){
            System.out.println("---------OBJECT_NOT_READ-------");
        } else {
            System.out.println("---------OBJECT_READ_SUCCESSFULY-------");
            for (List<String> row : ll){
                for (String cell : row ){
                    System.out.print( cell + "\t|\t" );
                }
                System.out.println();
            }
        }

    }
}
