package lab2.src;

import lab2.src.fig.figure_abs;

import java.awt.*;

public class rect extends figure_abs {
    protected int mod = 100;
    protected int x = x0 - mod;
    protected int y = y0 - mod;



    public rect(Graphics src, Color clr, String name, int x0, int y0) {
        super(src, clr, name, x0, y0);

    }

    @Override
    public void run() {
        graph.setColor(clr);
        graph.drawRect(x, y, mod * 2,  mod * 2  );

    }

    public void setSide(int side){
        this.mod = side;
    }





}
