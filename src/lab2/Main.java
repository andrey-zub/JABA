package lab2;

import lab2.src.panel;

public class Main {
    public static void main(String[] args){

        // Панель для отрисовки
        panel pnl = new panel(200,200,200,5,30);

        // Размерность панели в пикселях
        pnl.setSize(400,400);

        // Вывод отрисовки
        pnl.setVisible(true);

        // Заголовок панели
        pnl.setTitle("speen");


    }
}
