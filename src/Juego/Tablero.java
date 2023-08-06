package Juego;

import javax.swing.*;
import java.awt.*;

public class Tablero extends JFrame {
    JLabel label1;
    JLabel label2;
    public  Tablero(){

    inicializarTablero();
    Lbl();
    add(new Cuadro(),BorderLayout.CENTER);

    }

    public void inicializarTablero(){

        setResizable(false);
        setBounds(0,0,800,800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cuatro en raya");
    }

    public void Lbl() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS)); // Usar BoxLayout para alinear verticalmente

        label1 = new JLabel("Jugador 1");
        label1.setFont(new Font("Arial", Font.PLAIN, 24)); // Cambiar el tamaño de la fuente si lo deseas
        jPanel.add(label1);

        label2 = new JLabel("Jugador 2");
        label2.setFont(new Font("Arial", Font.PLAIN, 24)); // Cambiar el tamaño de la fuente si lo deseas
        jPanel.add(label2);

        add(jPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new Tablero());
    }
}
