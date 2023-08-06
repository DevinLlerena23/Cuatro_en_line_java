package Juego;

import javax.swing.*;
import java.awt.*;

public class Lbl2 extends JPanel {
    JLabel label2;
    public Lbl2(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        label2 = new JLabel("Jugador 2: ");
        label2.setFont(new Font("Arial",Font.PLAIN, 24)); // Cambiar el tamaño de la fuente si lo deseas
        jPanel.add(label2);
        add(jPanel, BorderLayout.NORTH);
        setVisible(false);
    }

}
