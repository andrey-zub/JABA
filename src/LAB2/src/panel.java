package LAB2.src;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.awt.Color.*;


public class panel extends Frame implements Runnable{

    protected  int x_origin;
    protected  int y_origin;
    protected  double dur = 0; // изменяемая величина
    protected  double mod; // скорость изменения велечены


    protected Thread panel;
    protected int time;

    public panel(int x, int y, int timer, double mod, double dur){


        this.x_origin = x; // стартовая точка по оси X
        this.y_origin = y; //стартовая точка по оси Y
        this.time = timer;
        this.mod = mod;
        this.dur = dur;

        this.setBackground(Color.black);
        panel = new Thread(this, "panel");
        panel.start();

        // Для закрытия окна
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public int getX(){  return this.x_origin;  }
    public int getY(){  return this.y_origin;  }


    @Override
    public void run() {
        while (true){
            this.repaint();
            this.dur +=    mod  ;

            try{ Thread.sleep(time); }
            catch (InterruptedException e){ e.printStackTrace(); }
        }

    }

    public void paint(Graphics g){

       // List<figure_abs> fig = new list_figure().getLIST();


       rect rec = new rect(g, green ,"rectangle",x_origin,y_origin);
            rec.setSide(100);
            rec.run();



       ball bl = new ball(g, blue,"ball",rec.x, rec.y,100, dur * 2.5 );
            bl.setRadius(8);
            bl.run();


       contur cntr = new contur(g, orange,"contur", rec.x,  rec.y,100 , dur * 3.5  );
            cntr.setRadius(5);
            cntr.run();





    }


}
