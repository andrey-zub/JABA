package LAB2.src;

import LAB2.src.fig.figure_abs;

import java.awt.*;

public class contur extends figure_abs {

    protected int x ;
    protected int y ;
    protected int radius = 5;
    protected int mod = 10;
    protected double elip = 0.8;

    contur(Graphics src, Color clr,String name, int x0, int y0, double rad, double delta) {
        super(src, clr,name, x0, y0, rad, delta);

    }

    @Override
    public void run() {

        x = (int) (x0 +   (rad * Math.cos(delta*Math.PI / 180)) + rad) ;
        y =  (int) ( (y0 +   (rad * Math.cos(delta*Math.PI / 180)) + rad ) * elip );

        graph.setColor(clr);
        graph.drawOval( x - mod , y - mod , (int) radius*2,(int) radius*2);


    }

    public void setRadius(int rad){  this.radius = rad;  }



}
