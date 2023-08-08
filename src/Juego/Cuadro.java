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

        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                circuloImagen[i][j] = null; // Inicializar con valores nulos
            }
        }

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

                if (x >= 0 && x < columnas && y >= 0 && y < filas) {
                    int lowestAvailableRow = -1;
                    for (int i = filas - 1; i >= 0; i--) {
                        if (circuloImagen[x][i] == null) {
                            lowestAvailableRow = i;
                            break;
                        }
                    }

                    if (lowestAvailableRow != -1) {
                        if (jugador) {
                            lbl2.setVisible(true);
                            lbl.setVisible(false);

                            circuloImagen[x][lowestAvailableRow] = new ImageIcon(getClass().getResource("img/circulob2.png"));
                            repaint();

                            jugador = false;
                        } else {
                            lbl.setVisible(true);

                            lbl2.setVisible(false);
                            circuloImagen[x][lowestAvailableRow] = new ImageIcon(getClass().getResource("img/circulor2.png"));
                            repaint();
                            jugador = true;
                        }
                        
                        if (comprobarGanador()) {
                            JOptionPane.showMessageDialog(Cuadro.this, "¡Jugador " + (jugador ? "2" : "1") + " ha ganado!");
                            reiniciarJuego();
                        }
                    }
                }
            }
        });
    }
    public boolean comprobarGanador() {
        // Comprobar alineaciones horizontales
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas - 3; j++) {
                if (circuloImagen[j][i] != null &&
                    circuloImagen[j][i].equals(circuloImagen[j + 1][i]) &&
                    circuloImagen[j][i].equals(circuloImagen[j + 2][i]) &&
                    circuloImagen[j][i].equals(circuloImagen[j + 3][i])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void reiniciarJuego() {
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                circuloImagen[i][j] = null;
            }
        }
        jugador = true;
        repaint();
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

