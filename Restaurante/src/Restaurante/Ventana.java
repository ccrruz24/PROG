package Restaurante;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	
	public Ventana (){
		
		this.setSize(1000, 800);
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
		
		//this.login();
		
		this.setVisible(true);
		this.repaint();
	}
	
	public void login() {
		
		JPanel login_container = new JPanel(); 
		login_container.setSize(500, 600);
		login_container.setLocation(250, 70);
		login_container.setBackground(Color.decode("#FFFFFF"));
		login_container.setLayout(null);
		login_container.setAlignmentX(CENTER_ALIGNMENT);
		login_container.setAlignmentY(CENTER_ALIGNMENT);
		this.add(login_container);

		// AÑADIR ELEMETOS
		
		JLabel titulo = new JLabel();
		titulo.setText("La casa del maiz");
		titulo.setSize(200, 30);
		titulo.setLocation(145, 50);
		titulo.setBackground(Color.white);
		titulo.setForeground(Color.black);
		titulo.setOpaque(false);
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setVerticalAlignment(JLabel.CENTER);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		login_container.add(titulo);
		
	}
	

		
}

