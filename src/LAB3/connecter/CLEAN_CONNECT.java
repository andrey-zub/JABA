package LAB3.connecter;

import LAB3.emp_src.EMP;

public class CLEAN_CONNECT implements Runnable{

   public  Thread stream;

    public CLEAN_CONNECT(){
        this.stream = new Thread(this,"clean_connect");
        stream.start();
    }

    public void sleep(int time ){
        try{
            stream.sleep(time);		//Приостанавливает поток
        }catch(InterruptedException e){}
    }


    @Override
    public void run() {

        System.out.println("+++++++++++++++CLEAN_CONNECT_START+++++++++++++++");
        EMP clean = new EMP(true); // подключение с auto commit\
        this.sleep(1000);

        clean.showEmpPart();
        clean.kill();
        System.out.println("+++++++++++++++CLEAN_CONNECT_STOP+++++++++++++++");


    }
}
