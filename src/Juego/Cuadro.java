package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Cuadro extends JPanel {
    public static final int Squares=7;
    private boolean jugador=true;

    private ImageIcon[][] circuloImagen;
    public Cuadro() {
        circuloImagen = new ImageIcon[Squares][Squares];
        cuadroClicked = new boolean[Squares][Squares];

        // Agregar un MouseListener para detectar clics en el panel
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int width = getWidth();
                int height = getHeight();
                int side = Math.min(width, height) / Squares;
                int xOffset = (width - Squares * side) / 2;
                int yOffset = (height - Squares * side) / 2;

                int x = (e.getX() - xOffset) / side;
                int y = (e.getY() - yOffset) / side;

                if (x >= 0 && x < Squares && y >= 0 && y < Squares) {
                    // Asignar la imagen al cuadro donde se hizo clic
                    if(jugador==true){
                    circuloImagen[x][y] = new ImageIcon(getClass().getResource("img/circulob2.png"));
                    repaint();

                        jugador=false;
                    }
                    else{
                        circuloImagen[x][y] = new ImageIcon(getClass().getResource("img/circulor2.png"));
                        repaint();
                        jugador=true;
                    }


                }
            }
        });
    }


    private boolean[][] cuadroClicked;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int side = Math.min(width, height) / Squares;
        int xOffset = (width - Squares * side) / 2;
        int yOffset = (height - Squares * side) / 2;

        for (int i = 0; i < Squares; i++) {
            for (int j = 0; j < Squares; j++) {
                int x = xOffset + i * side;
                int y = yOffset + j * side;
                g.drawRect(x, y, side, side);
                if (circuloImagen[i][j] != null) {
                    int imageX = x + (side - circuloImagen[i][j].getIconWidth()) / 2;
                    int imageY = y + (side - circuloImagen[i][j].getIconHeight()) / 2;
                    circuloImagen[i][j].paintIcon(this, g, imageX, imageY);
                }
            }

        }
    }
    // Método para asignar una imagen a un cuadro específico
    public void setCuadroImage(int x, int y, ImageIcon imageIcon) {
        if (x >= 0 && x < Squares && y >= 0 && y < Squares) {
            circuloImagen[x][y] = imageIcon;
            repaint();
        }
    }
}
