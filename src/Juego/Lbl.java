package Juego;

import javax.swing.*;
import java.awt.*;

public class Lbl extends JPanel {
    JLabel label1;


    public Lbl () {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS)); // Usar BoxLayout para alinear verticalmente

        label1 = new JLabel("Jugador 1: ");
        label1.setFont(new Font("Arial", Font.PLAIN, 24)); // Cambiar el tamaño de la fuente si lo deseas
        jPanel.add(label1);


        add(jPanel, BorderLayout.NORTH);
    }

}




