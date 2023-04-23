package lab2.src;

import java.awt.*;

public abstract class figure_abs implements Runnable{

    protected Graphics graph;
    protected Thread stream;
    protected  String name;
    protected int x0;
    protected int y0;
    protected double rad;
    protected double delta;
    protected Color clr;


     figure_abs(Graphics src, String name, int x0, int y0, double rad, double delta){
        this.x0 = x0;
        this.y0 = y0;
        this.rad = rad;
        this.delta = delta;
        this.graph = src;

        this.stream = new Thread(this, name);
        stream.start();

    }

     figure_abs(Graphics src, String name, int x0, int y0, double delta){
        this.x0 = x0;
        this.y0 = y0;
        this.delta = delta;
        this.graph = src;

        this.stream = new Thread(this, name);
        stream.start();

    }

    public void setColor(Color clr){   this.clr = clr;  }

}
