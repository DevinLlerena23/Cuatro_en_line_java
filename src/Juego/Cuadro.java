package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Cuadro extends JPanel {
    public static final int filas = 6;
    public static final int columnas = 7;
    private final JPanel lbl;
    private final JPanel lbl2;
    private final ImageIcon[][] circuloImagen;
    private boolean jugador = true;

    public Cuadro(JPanel lbl, JPanel lbl2) {
        this.lbl = lbl;
        this.lbl2 = lbl2;
        circuloImagen = new ImageIcon[columnas][filas];

        // Agregar un MouseListener para detectar clics en el panel
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int width = getWidth();
                int height = getHeight();
                int side = Math.min(width, height) / columnas;
                int xOffset = (width - columnas * side) / 2;
                int yOffset = (height - filas * side) / 2;

                int x = (e.getX() - xOffset) / side;
                int y = (e.getY() - yOffset) / side;

                if (x >= 0 && x < columnas && y >= 0 && y < filas && circuloImagen[x][y] == null) {
                    // Asignar la imagen al cuadro donde se hizo clic
                    if (jugador) {
                        lbl2.setVisible(true);
                        lbl.setVisible(false);

                        circuloImagen[x][y] = new ImageIcon(getClass().getResource("img/circulob2.png"));
                        repaint();

                        jugador = false;
                    } else {
                        lbl.setVisible(true);

                        lbl2.setVisible(false);
                        circuloImagen[x][y] = new ImageIcon(getClass().getResource("img/circulor2.png"));
                        repaint();
                        jugador = true;
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int side = Math.min(width, height) / columnas;
        int xOffset = (width - columnas * side) / 2;
        int yOffset = (height - filas * side) / 2;

        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
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
}

