package emp_logic.emp_src;

import emp_logic.connecter.CLEAN_CONNECT;
import emp_logic.connecter.DIRTY_CONNECT;

public class dirtyRead  implements Runnable {

    Thread stream;
    public dirtyRead(){
        stream = new Thread(this, "dirty-read");
        stream.start();
    }

    @Override
    public void run() {

        CLEAN_CONNECT clean_con = new CLEAN_CONNECT();

        DIRTY_CONNECT dirty_con = new DIRTY_CONNECT();











    }
}
