package Restaurante;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {

	public Ventana() {

		this.setSize(1400, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(200, 200));
		this.setMaximumSize(new Dimension(1000, 1000));
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.decode("#D84315"));
		this.setLayout(null);
		this.setTitle("La casa del maiz");

		try {
			Image iconImage = ImageIO.read(getClass().getResource("/images/casa_maiz.jpeg"));

			this.setIconImage(iconImage);

		} catch (IOException e) {
			e.printStackTrace();
		}

		this.login();

		this.setVisible(true);
		this.repaint();
	}

	public void login() {

		JPanel pane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int arc = 40;
				int width = getWidth();
				int height = getHeight();

				// fondo redondeado
				g2d.setColor(getBackground());
				g2d.fillRoundRect(0, 0, width - 1, height - 1, arc, arc);

			}
		};
		pane.setOpaque(false);
		pane.setSize(600, 600);

		int x = (this.getWidth() - pane.getWidth()) / 2;
		int y = (this.getHeight() - pane.getHeight()) / 2;
		pane.setLocation(x, y);

		this.add(pane);
		pane.setLayout(null);

		// Añadir componentes

		ImageIcon icon = new ImageIcon(getClass().getResource("/images/casa_maiz.jpeg"));
		Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setBounds(267, 50, 50, 50);
		pane.add(iconLabel);

		JLabel titulo = new JLabel("La casa del maiz");
		titulo.setBounds(210, -20, 200, 100);
		titulo.setFont(new Font("Arial", Font.PLAIN, 22));
		pane.add(titulo);

		JLabel correo = new JLabel("Correo electrónico");
		correo.setBounds(60, 100, 200, 100);
		correo.setFont(new Font("Arial", Font.PLAIN, 22));
		pane.add(correo);

		JTextField textcorreo = new JTextField();
		textcorreo.setBounds(0, 0, 0, 0);

	}

}
