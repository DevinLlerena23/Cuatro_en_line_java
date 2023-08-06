package Juego;

import javax.swing.*;
import java.awt.*;

public class Tablero extends JFrame {
    JLabel label1;
    JLabel label2;
    public  Tablero(){

    inicializarTablero();
    Lbl lbl=new Lbl();
    Lbl2 lbl2=new Lbl2();
    add(lbl,BorderLayout.NORTH);
    add(lbl2,BorderLayout.SOUTH);
    add(new Cuadro(lbl,lbl2),BorderLayout.CENTER);

    }

    public void inicializarTablero(){

        setResizable(false);
        setBounds(0,0,800,800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cuatro en raya");
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new Tablero());
    }
}
