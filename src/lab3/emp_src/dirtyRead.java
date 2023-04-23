package lab3.emp_src;

public class dirtyRead  implements Runnable {

    Thread stream;
    public dirtyRead(){
        stream = new Thread(this, "dirty-read");
        stream.start();
    }
    @Override
    public void run() {

        System.out.println("+++++++++++++++CLEAN_CONNECT_START+++++++++++++++");
        EMP clean = new EMP(true); // подключение с auto commit

        clean.showEmpPart();


        System.out.println("+++++++++++++++DIRTY_CONNECT_START+++++++++++++++");
        EMP dirty = new EMP(false); // подключение без auto commit

        char q ='"';
        dirty.exec( "UPDATE java."+q+"empPart"+q+" SET f_name = 'Sergj' WHERE id in(2103)");

        dirty.kill();
        System.out.println("+++++++++++++++CLEAN_CONNECT_STOP+++++++++++++++");


        clean.showEmpPart();
        clean.kill();
        System.out.println("+++++++++++++++CLEAN_CONNECT_STOP+++++++++++++++");




    }
}
