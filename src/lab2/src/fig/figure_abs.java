package lab2.src.fig;

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



    // Для фигур с изменяемыми параметрами и радианами
    public figure_abs(Graphics src, Color clr, String name, int x0, int y0, double rad, double delta){
        this.x0 = x0;
        this.y0 = y0;
        this.rad = rad;
        this.delta = delta;
        this.graph = src;
        this.clr = clr;
        graph.setColor(clr);

        this.stream = new Thread(this, name);
        stream.start();

    }

    // Для фигур с изменяемыми параметрами
     figure_abs(Graphics src, Color clr,String name, int x0, int y0, double delta){
        this.x0 = x0;
        this.y0 = y0;
        this.delta = delta;
        this.graph = src;
         this.clr = clr;
         graph.setColor(clr);

        this.stream = new Thread(this, name);
        stream.start();

    }

    // Для статичных фигур
    protected figure_abs(Graphics src, Color clr,String name, int x0, int y0){
        this.x0 = x0;
        this.y0 = y0;
        this.graph = src;
        this.clr = clr;
        graph.setColor(clr);

        this.stream = new Thread(this, name);
        stream.start();
    }



}
