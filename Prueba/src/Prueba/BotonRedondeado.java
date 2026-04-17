package Prueba;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class BotonRedondeado extends JButton {

    public BotonRedondeado(String texto) {
        super(texto);
        setContentAreaFilled(false); // Quita fondo por defecto
        setFocusPainted(false);      // Quita borde de foco
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Color del botón
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
}
