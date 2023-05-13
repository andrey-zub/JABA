package LAB3.connecter;

import LAB3.emp_src.EMP;

public class DIRTY_CONNECT implements Runnable{

    Thread stream;

    public DIRTY_CONNECT(){
        this.stream = new Thread(this,"dirty_connect");
        stream.start();
    }



    @Override
    public void run() {
        EMP dirty = new EMP(false); // подключение без auto commit
        System.out.println("+++++++++++++++DIRTY_CONNECT_START+++++++++++++++");


        char q ='"';
        dirty.exec( "UPDATE java."+q+"empPart"+q+" SET f_name = 'Sergj' WHERE id in(2103)");

        dirty.create_new_empPart("test","test","test",0,0,0);



        dirty.kill();
        System.out.println("+++++++++++++++DIRTY_CONNECT_STOP+++++++++++++++");

    }
}
