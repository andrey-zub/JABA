package lab2.src.fig;

import lab2.src.fig.figure_abs;

import java.util.ArrayList;
import java.util.List;

public class list_figure {
    private List<figure_abs> LIST = new ArrayList<>();

    public void push(figure_abs fig){  this.LIST.add(fig);  }

    public List<figure_abs> getLIST(){
        return this.LIST;
    }

}
