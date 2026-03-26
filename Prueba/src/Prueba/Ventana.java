package Prueba;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame {

	public Ventana() {

		this.setSize(1000, 700);
		// this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(200, 200));
		this.setMaximumSize(new Dimension(1000, 1000));
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.black);
		this.setLayout(null);
		this.setTitle("Ventana chida");

		try {
			Image iconImage = ImageIO.read(getClass().getResource("/images/image.jpg"));

			this.setIconImage(iconImage);

		} catch (IOException e) {
			e.printStackTrace();
		}

		JMenuBar barra = new JMenuBar();
		this.setJMenuBar(barra);

		JMenu menu1 = new JMenu("Archivo");
		barra.add(menu1);

		JMenuItem opt1_mi = new JMenuItem("Nuevo");
		menu1.add(opt1_mi);

		JMenuItem opt2_mi = new JMenuItem("Abrir");
		menu1.add(opt2_mi);

		JMenuItem opt3_mi = new JMenuItem("Cerrar");
		menu1.add(opt3_mi);

		menu1.addSeparator();

		JMenu menu2 = new JMenu("Guardar");
		menu1.add(menu2);

		JMenuItem opt4_mi = new JMenuItem("Guardar");
		menu2.add(opt4_mi);

		JMenuItem opt5_mi = new JMenuItem("Guardar como");
		menu2.add(opt5_mi);
		
		JMenu menu3 = new JMenu("Cuentas");
		barra.add(menu3);
		
		JMenuItem login = new JMenuItem("Registro");
		login.addActionListener(e ->{
			this.router("registro");
		});
		menu3.add(login);
		
			JMenuItem registro = new JMenuItem("login");
			registro.addActionListener(e ->{
				this.router("login");
			});
			menu3.add(registro);
			
		JMenuItem rec_account = new JMenuItem("Recuperacion de cuenta");
		menu3.add(rec_account);
		
		JMenu menu4 = new JMenu("Usuarios");
		barra.add(menu4);
		
		JMenuItem high = new JMenuItem("Alta");
		menu4.add(high);
		
		JMenuItem low = new JMenuItem("Baja");
		menu4.add(low);
		
		JMenuItem check = new JMenuItem("Consultar");
		menu4.add(check);
		
		JMenu menu5 = new JMenu("Ayuda");
		barra.add(menu5);
		
		JMenuItem create = new JMenuItem("¿Cómo crear un usuario?");
		menu5.add(create);
		
		JMenuItem access = new JMenuItem("¿Cómo acceder al sistema?");
		menu5.add(access);
		
		JMenuItem forget = new JMenuItem("¿Qué pasa si olvidé mi contraseña?");
		menu5.add(forget);
		
		
		
		
		
		
		
			
		

		//this.login();
		//this.registro();
		//this.users();
		//this.paintComponent();
		//this.factura();
		
		
		this.router("login");

		this.setVisible(true);
		this.repaint();
	
	}
	
	public void router(String target) {
		
		this.getContentPane().removeAll();
		
		if(target.equals("login")) 
			this.login();
			
		if(target.equals("registro")) 
			this.registro();
		
		this.repaint();
		this.revalidate();
			
	}

	public void login() {

		JPanel login_container = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/jeje.jpg")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			}
		};

		login_container.setSize(400, 600);
		login_container.setLocation(50, 50);
		login_container.setBackground(Color.decode("#13E836"));
		login_container.setLayout(null);
		this.add(login_container);

		// AÑADIR ELEMETOS
		JLabel tag_title = new JLabel();
		JLabel user = new JLabel();
		JLabel passwor = new JLabel();

		tag_title.setText("Bienvenido");
		tag_title.setSize(150, 30);
		tag_title.setLocation(120, 30);
		tag_title.setBackground(Color.white);
		tag_title.setForeground(Color.white);
		tag_title.setOpaque(false);
		tag_title.setFont(new Font("Arial", Font.PLAIN, 26));
		tag_title.setVerticalAlignment(JLabel.CENTER);
		tag_title.setHorizontalAlignment(JLabel.CENTER);

		user.setText("Usuario");
		user.setSize(110, 20);
		user.setLocation(20, 115);
		user.setBackground(Color.white);
		user.setForeground(Color.white);
		user.setOpaque(false);
		user.setFont(new Font("Arial", Font.PLAIN, 18));
		user.setVerticalAlignment(JLabel.CENTER);
		user.setHorizontalAlignment(JLabel.CENTER);

		passwor.setText("Contraseña");
		passwor.setSize(110, 20);
		passwor.setLocation(20, 215);
		passwor.setBackground(Color.white);
		passwor.setForeground(Color.white);
		passwor.setOpaque(false);
		passwor.setFont(new Font("Arial", Font.PLAIN, 18));
		passwor.setVerticalAlignment(JLabel.CENTER);
		passwor.setHorizontalAlignment(JLabel.CENTER);

		login_container.add(tag_title);
		login_container.add(user);
		login_container.add(passwor);

		JTextField email_input = new JTextField();
		email_input.setSize(280, 40);
		email_input.setLocation(60, 150);
		login_container.add(email_input);

		JCheckBox rememberme = new JCheckBox("Recordarme");
		rememberme.setSize(100, 20);
		rememberme.setLocation(60, 300);
		rememberme.setForeground(Color.white);
		rememberme.setOpaque(false);
		login_container.add(rememberme);

		JPasswordField password = new JPasswordField();
		password.setSize(280, 40);
		password.setLocation(60, 250);
		login_container.add(password);

		JButton acces_btn = new JButton();
		acces_btn.setText("Acceder");
		acces_btn.setSize(200, 40);
		acces_btn.setLocation(100, 350);
		acces_btn.setFont(new Font("Arial", Font.ITALIC, 18));
		login_container.add(acces_btn);

		acces_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String email = email_input.getText();
				String pass = password.getText();

				if (email.equals("")) {
		            email_input.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            JOptionPane.showMessageDialog(
		                login_container,
		                "El campo usuario está vacío",
		                "Error",
		                JOptionPane.ERROR_MESSAGE
		            );
		            return; 
		        } else {
		            email_input.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }

		        if (pass.equals("")) {
		            password.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            JOptionPane.showMessageDialog(
		                login_container,
		                "El campo contraseña está vacío",
		                "Error",
		                JOptionPane.ERROR_MESSAGE
		            );
		            return;
		        } else if (pass.length() < 8) {
		            password.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            JOptionPane.showMessageDialog(
		                login_container,
		                "La contraseña debe tener al menos 8 caracteres",
		                "Error",
		                JOptionPane.ERROR_MESSAGE
		            );
		            return;
		        } else {
		            password.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }

		        // Datos correctos 
		        String correo = "admin@alu.uabcs.mx";
		        String contra = "12345678";

		        if (email.equals(correo) && pass.equals(contra)) {
		            JOptionPane.showMessageDialog(
		                login_container,
		                "Bienvenido, ",
		                "Acceso correcto",
		                JOptionPane.INFORMATION_MESSAGE
		            );
		        } else {
		            JOptionPane.showMessageDialog(
		                login_container,
		                "Usuario o contraseña incorrectos",
		                "Error de acceso",
		                JOptionPane.ERROR_MESSAGE
		            );
		        }
		    }
		});
		
		JButton registro = new JButton("¿Aun no tienes cuenta?");
		registro.setSize(250, 50);
		registro.setLocation(80, 400);
		registro.setFont(new Font("Arial", Font.ITALIC, 18));
		login_container.add(registro);
		
		registro.addActionListener(e->{
			this.router("registro");
		});

		
	}

	public void registro() {

		JPanel rgs_container = new JPanel();
		rgs_container.setBounds(500, 50, 400, 700);
		rgs_container.setOpaque(true);
		rgs_container.setBackground(Color.decode("#5836C7"));
		rgs_container.setLayout(null);
		this.add(rgs_container);

		JLabel user_name = new JLabel("Nombre de usuario");
		user_name.setBounds(50, 50, 250, 120);
		user_name.setOpaque(false);
		user_name.setForeground(Color.white);
		user_name.setFont(new Font("Arial", Font.PLAIN, 24));
		user_name.setVerticalAlignment(JLabel.CENTER);
		user_name.setHorizontalAlignment(JLabel.CENTER);
		rgs_container.add(user_name);

		JTextField text_name = new JTextField();
		text_name.setBounds(50, 140, 300, 25);
		rgs_container.add(text_name);

		JLabel register = new JLabel("Registro");
		register.setBounds(50, -10, 300, 120);
		register.setOpaque(false);
		register.setForeground(Color.white);
		register.setFont(new Font("Arial", Font.PLAIN, 26));
		register.setVerticalAlignment(JLabel.CENTER);
		register.setHorizontalAlignment(JLabel.CENTER);
		rgs_container.add(register);

		JLabel bio_tag = new JLabel("BIO");
		bio_tag.setBounds(50, 140, 300, 120);
		bio_tag.setOpaque(false);
		bio_tag.setFont(new Font("Arial", Font.PLAIN, 22));
		bio_tag.setForeground(Color.white);
		bio_tag.setHorizontalAlignment(JLabel.CENTER);
		bio_tag.setVerticalAlignment(JLabel.CENTER);
		rgs_container.add(bio_tag);

		// TEXTAREA

		JTextArea text_Area = new JTextArea("", 10, 10);
		text_Area.setBounds(50, 50, 400, 40);
		text_Area.setLocation(50, 220);
		text_Area.setSize(300, 50);
		text_Area.setOpaque(true);
		rgs_container.add(text_Area);

		// CHECK BOX

		JCheckBox opt_sweet = new JCheckBox("Dulce");
		opt_sweet.setBounds(50, 320, 100, 40);
		opt_sweet.setForeground(Color.black);
		opt_sweet.setOpaque(true);
		rgs_container.add(opt_sweet);

		JCheckBox opt_salty = new JCheckBox("Salado");
		opt_salty.setBounds(150, 320, 100, 40);
		opt_salty.setForeground(Color.black);
		opt_salty.setOpaque(true);
		rgs_container.add(opt_salty);

		JCheckBox opt_healty = new JCheckBox("Saludable");
		opt_healty.setBounds(250, 320, 100, 40);
		opt_healty.setForeground(Color.black);
		opt_healty.setOpaque(true);
		rgs_container.add(opt_healty);

		// LABEL PREFERENCES

		JLabel preferences = new JLabel("Preferencias");
		preferences.setBounds(50, 240, 300, 120);
		preferences.setOpaque(false);
		preferences.setForeground(Color.white);
		preferences.setFont(new Font("Arial", Font.PLAIN, 28));
		preferences.setHorizontalAlignment(JLabel.CENTER);
		preferences.setVerticalAlignment(JLabel.CENTER);
		rgs_container.add(preferences);

		// LABEL TERMS

		JLabel terms_text = new JLabel("Terminos");
		terms_text.setBounds(50, 320, 300, 120);
		terms_text.setOpaque(false);
		terms_text.setForeground(Color.white);
		terms_text.setFont(new Font("Arial", Font.PLAIN, 28));
		terms_text.setHorizontalAlignment(JLabel.CENTER);
		terms_text.setVerticalAlignment(JLabel.CENTER);
		rgs_container.add(terms_text);

		JRadioButton accept_terms = new JRadioButton("Acepto los terminos");
		accept_terms.setBounds(20, 400, 180, 40);
		accept_terms.setOpaque(true);
		accept_terms.setForeground(Color.black);
		accept_terms.setBorderPainted(true);
		rgs_container.add(accept_terms);

		JRadioButton reject_terms = new JRadioButton("Rechazo los terminos ");
		reject_terms.setBounds(220, 400, 170, 40);
		reject_terms.setOpaque(true);
		reject_terms.setForeground(Color.black);
		rgs_container.add(reject_terms);

		ButtonGroup terms = new ButtonGroup();
		terms.add(accept_terms);
		terms.add(reject_terms);

		// COMBO
		String[] colonias = { "Camino real", "Arcoiris", "Villas del encanto", "8 de octubre" };
		JComboBox colonias_combo = new JComboBox(colonias);
		colonias_combo.setBounds(50, 460, 300, 20);
		rgs_container.add(colonias_combo);

		// BUTTON
		JButton register_btn = new JButton("Crear cuenta");
		register_btn.setBounds(50, 500, 300, 60);
		rgs_container.add(register_btn);

		register_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = text_name.getText();
				String BIO = text_Area.getText();
				Boolean term = accept_terms.isSelected();

				if (name.equals("")) {
					text_name.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
				} else {
					text_name.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
				}

				if (BIO.equals("")) {
					text_Area.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
				} else {
					text_Area.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
				}

				if (term == false) {
					accept_terms.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
				} else {
					accept_terms.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
				}

			}
		});
		
		JButton login_btn = new JButton();
		login_btn.setText("¿Ya tienes cuenta?");
		login_btn.setSize(250, 50);
		login_btn.setLocation(80, 590);
		login_btn.setFont(new Font("Arial", Font.ITALIC, 18));
		rgs_container.add(login_btn);
		
		login_btn.addActionListener(e->{
			this.router("login");
		});
	}

	public void users() {
		JPanel panel_users = new JPanel();
		panel_users.setBounds(50, 50, 1000, 650);
		panel_users.setOpaque(true);
		panel_users.setBackground(Color.white);
		panel_users.setLayout(null);
		panel_users.setBorder(BorderFactory.createLineBorder(Color.decode("#D1CDCD"), 5, true));
		panel_users.setBackground(Color.decode("#BBF2F2"));
		this.add(panel_users);

		String[] table_head = { "No. Control", "Nombre", "Apellidos", "Correo electrónico", "Semestre", "Carrera",
				"Acciones" };

		Object[][] table_body = {
				{ "2026001", "Carlos", "López García", "carlos.lopez@uni.edu.mx", "3", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026002", "Ana", "Martínez Pérez", "ana.martinez@uni.edu.mx", "5", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026003", "Juan", "Hernández Ruiz", "juan.hernandez@uni.edu.mx", "2", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026004", "María", "González Torres", "maria.gonzalez@uni.edu.mx", "6", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026005", "José", "Ramírez Díaz", "jose.ramirez@uni.edu.mx", "4", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026006", "Laura", "Sánchez Vega", "laura.sanchez@uni.edu.mx", "1", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026007", "Miguel", "Torres Luna", "miguel.torres@uni.edu.mx", "7", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026008", "Sofía", "Vargas Ortega", "sofia.vargas@uni.edu.mx", "8", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026009", "Daniel", "Castillo Ramos", "daniel.castillo@uni.edu.mx", "5", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026010", "Paula", "Mendoza Silva", "paula.mendoza@uni.edu.mx", "3", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026001", "Carlos", "López García", "carlos.lopez@uni.edu.mx", "3", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026002", "Ana", "Martínez Pérez", "ana.martinez@uni.edu.mx", "5", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026003", "Juan", "Hernández Ruiz", "juan.hernandez@uni.edu.mx", "2", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026004", "María", "González Torres", "maria.gonzalez@uni.edu.mx", "6", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026005", "José", "Ramírez Díaz", "jose.ramirez@uni.edu.mx", "4", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026006", "Laura", "Sánchez Vega", "laura.sanchez@uni.edu.mx", "1", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026007", "Miguel", "Torres Luna", "miguel.torres@uni.edu.mx", "7", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026008", "Sofía", "Vargas Ortega", "sofia.vargas@uni.edu.mx", "8", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026009", "Daniel", "Castillo Ramos", "daniel.castillo@uni.edu.mx", "5", "Ingeniería en Sistemas",
						"Editar" },
				{ "2026010", "Paula", "Mendoza Silva", "paula.mendoza@uni.edu.mx", "3", "Ingeniería en Sistemas",
						"Editar" } };

		JTable students = new JTable(table_body, table_head);
		students.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		// students.isCellEditable(ERROR, ABORT);

		JLabel text = new JLabel("Usuario");
		text.setBounds(400, 30, 200, 100);
		text.setFont(new Font("SansSerif", Font.ITALIC, 50));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setVerticalAlignment(JLabel.CENTER);
		panel_users.add(text);

		JLabel text_1 = new JLabel("Usuarios 20");
		text_1.setBounds(80, 80, 200, 100);
		text_1.setOpaque(true);
		text_1.setFont(new Font("SansSerif", Font.ITALIC, 30));
		text_1.setBackground(Color.black);
		text_1.setForeground(Color.white);
		text_1.setHorizontalAlignment(JLabel.CENTER);
		text_1.setVerticalAlignment(JLabel.CENTER);
		panel_users.add(text_1);

		JScrollPane final_table = new JScrollPane(students);
		final_table.setBounds(80, 220, 850, 345);
		final_table.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_users.add(final_table, BorderLayout.CENTER);

	}
	
	public void paintComponent() {
		JPanel pane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2d = (Graphics2D) g;

				// FONDO
				g2d.setColor(Color.decode("#79D6ED")); 
				g2d.fillRect(0, 0, getWidth(), getHeight());
				
				int fila = 5;
	            int columnas =35;
	            int cellSize = 30;
	            int yOffset = 487;
	            int xOffset = 83;

	            
	            // COLOR 
	            g2d.setColor(Color.decode("#804000"));

	            // RELLENA CELDA
	            for (int i = 0; i < fila; i++) {
	                for (int j = 0; j < columnas; j++) {
	                    g2d.fillRect(xOffset + j * cellSize, yOffset + i * cellSize, cellSize, cellSize);
	                }
	            }
	            
	            // LINEAS
	            g2d.setColor(Color.decode("#5E3A0C"));
	            g2d.setStroke(new BasicStroke(3));
	            for (int i = 0; i <= fila; i++) {
	                g2d.drawLine(xOffset, yOffset + i * cellSize, xOffset + columnas * cellSize, yOffset + i * cellSize);
	            }
	            for (int j = 0; j <= columnas; j++) {
	                g2d.drawLine(xOffset + j * cellSize, yOffset, xOffset + j * cellSize, yOffset + fila * cellSize);
	            }
	            
	            // PISO ARRIBA
	            g2d.setColor(Color.decode("#B87333")); 
	            g2d.fillRect(82, 466, 918, 20);
	            
	            // BLOQUE AZUL	            
	            g2d.setColor(Color.black);
	            g2d.fillRect(520, 258, 40, 210);
	            
	            g2d.setColor(Color.decode("#058EED"));//0080D9
	            g2d.fillRect(380, 216, 150, 250);
	            g2d.setColor(Color.BLACK);              
	            g2d.setStroke(new BasicStroke(3));      
	            g2d.drawRect(380, 216, 150, 250); 
	            
	            g2d.setColor(Color.decode("#0080D9"));
	            g2d.fillRect(520, 219, 10, 246);
	            
	            g2d.setColor(Color.decode("#9C9C9C"));
	            g2d.fillOval(385, 220, 20, 20);
	            g2d.setColor(Color.decode("#9C9C9C"));
	            g2d.fillOval(505, 220, 20, 20);
	            g2d.setColor(Color.decode("#9C9C9C"));
	            g2d.fillOval(505, 443, 20, 20);
	            
	            
	       
	            // BLOQUE ROSA	           	            
	            g2d.setColor(Color.black);
	            g2d.fillRect(420, 365, 40, 100);
	            
	            
	            g2d.setColor(Color.decode("#F2C5BD"));
	            g2d.fillRect(280, 316, 150, 150); 
	            g2d.setColor(Color.BLACK);              
	            g2d.setStroke(new BasicStroke(3));      
	            g2d.drawRect(280, 316, 150, 150);

	            g2d.setColor(Color.decode("#F7B7AB"));
	            g2d.fillRect(418, 320, 10, 145);
	            
	            g2d.setColor(Color.decode("#9C9C9C"));
	            g2d.fillOval(285, 322, 20, 20);
	            g2d.setColor(Color.decode("#9C9C9C"));
	            g2d.fillOval(405, 322, 20, 20);
	            
	            g2d.setColor(Color.decode("#9C9C9C"));
	            g2d.fillOval(285, 440, 20, 20);
	            g2d.setColor(Color.decode("#9C9C9C"));
	            g2d.fillOval(405, 440, 20, 20);
	            
	            // BLOQUE VERDE
	            g2d.setColor(Color.decode("#00CC09"));
	            g2d.fillRect(850, 316, 150, 150); 
	            g2d.setColor(Color.BLACK);              
	            g2d.setStroke(new BasicStroke(3));      
	            g2d.drawRect(850, 316, 150, 150); 
	            
	            
	            g2d.setColor(Color.decode("#9C9C9C"));
	            g2d.fillOval(855, 320, 20, 20);
	            g2d.setColor(Color.decode("#9C9C9C"));
	            g2d.fillOval(855, 440, 20, 20);
	            
	         	            	
	            //TUBO
	            g2d.setColor(Color.decode("#156B15"));
	            g2d.fillRect(649, 300, 140, 60); 
	            
	            g2d.setColor(Color.decode("#98D4EB"));
	            g2d.fillRect(649, 300, 36, 60);
	            
	            g2d.setColor(Color.decode("#0C610C"));
	            g2d.fillRect(735, 300, 15, 60);
	            
	            g2d.setColor(Color.decode("#034203"));
	            g2d.fillRect(750, 300, 40, 60);
	            
	            
	            
	            // Parte inferior 
	            g2d.setColor(Color.decode("#156B15"));//79D6ED,0C610C
	            g2d.fillRect(671, 360, 100, 104);
	            
	            g2d.setColor(Color.decode("#98D4EB"));
	            g2d.fillRect(671, 360, 13, 104);
	            
	            g2d.setColor(Color.decode("#0C610C"));
	            g2d.fillRect(735, 360, 13, 104);
	            
	            g2d.setColor(Color.decode("#034203"));
	            g2d.fillRect(749, 360, 23, 104);

	            
	            g2d.setColor(Color.BLACK);
	            g2d.setStroke(new BasicStroke(3));
	            g2d.drawRect(650, 300, 140, 60); // borde superior
	            g2d.drawRect(671, 360, 100, 104); // borde inferior
	            
	            
	            // BLOQUE ARRIBA
	            g2d.setColor(Color.decode("#B87333"));
	            g2d.fillRect(100, 200, 50, 50);
	            g2d.setColor(Color.BLACK);              
	            g2d.setStroke(new BasicStroke(3));      
	            g2d.drawRect(100, 200, 50, 50); 
	            
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(104, 202, 4, 4);
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(104, 244, 4, 4);
	            
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(144, 202, 4, 4);
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(144, 244, 4, 4);
	            
	            // BLOQUEN DEL FONDO
	            g2d.setColor(Color.decode("#B87333"));
	            g2d.fillRect(900, 200, 50, 50);
	            g2d.setColor(Color.BLACK);              
	            g2d.setStroke(new BasicStroke(3));      
	            g2d.drawRect(900, 200, 50, 50); 
	            
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(904, 202, 4, 4);
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(904, 244, 4, 4);
	            
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(944, 202, 4, 4);
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(944, 244, 4, 4);
	            
	            // BLOQUE 1 ARRIBA
	            g2d.setColor(Color.decode("#B87333"));
	            g2d.fillRect(250, 60, 50, 50);
	            g2d.setColor(Color.BLACK);             
	            g2d.setStroke(new BasicStroke(3));      
	            g2d.drawRect(250, 60, 50, 50); 
	            
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(254, 64, 4, 4);
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(254, 104, 4, 4);
	            
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(294, 64, 4, 4);
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(294, 104, 4, 4);
	            
	            // BLOQUE 2 ARRIBA
	            g2d.setColor(Color.decode("#B87333"));
	            g2d.fillRect(300, 60, 50, 50);
	            g2d.setColor(Color.BLACK);              
	            g2d.setStroke(new BasicStroke(3));      
	            g2d.drawRect(300, 60, 50, 50); 
	            
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(304, 64, 4, 4);
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(304, 104, 4, 4);
	            
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(344, 64, 4, 4);
	            g2d.setColor(Color.BLACK);
	            g2d.fillOval(344, 104, 4, 4);
	            			
				

				
			}
		};
		pane.setSize(1000, 700);
		pane.setLocation(0, 0);
		this.add(pane);
	}
	
	public void factura() {
		
		JPanel login_container = new JPanel();
		login_container.setSize(600, 625);
		login_container.setLocation(200, 50);
		login_container.setBackground(Color.decode("#FFFFFF"));
		login_container.setLayout(null);
		this.add(login_container);
		
		JPanel banner = new JPanel();
        banner.setBounds(0, 0, 600, 80);
        banner.setBackground(Color.decode("#1053A3")); 
        banner.setLayout(null);
        login_container.add(banner);
        
        JLabel titulo = new JLabel("<html>Factura en Java - NetBeans - ArrayList y POO<br>[Sin Base de datos]</html>");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBounds(20, 20, 760, 40);
        banner.add(titulo);
        
        //DATOS DEL CLIENTE
        JPanel datosClientePanel = new JPanel();
        datosClientePanel.setBounds(20, 100, 560, 120); 
        datosClientePanel.setLayout(null);

        
        datosClientePanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1),
            "Datos del cliente",                            
            TitledBorder.LEFT,                              
            TitledBorder.TOP,                               
            new Font("Arial", Font.BOLD, 14),               
            Color.BLACK                                     
        ));

        login_container.add(datosClientePanel);

        // ETIQUETAS DENTRO DEL PANEL 
        JLabel Documento = new JLabel("Documento:");
        Documento.setBounds(20, 30, 100, 30);
        datosClientePanel.add(Documento);

        JLabel Direccion = new JLabel("Dirección:");
        Direccion.setBounds(20, 60, 100, 30);
        datosClientePanel.add(Direccion);

        JLabel Nombre = new JLabel("Nombres:");
        Nombre.setBounds(300, 30, 100, 30);
        datosClientePanel.add(Nombre);

        JLabel Telefono = new JLabel("Teléfono:");
        Telefono.setBounds(300, 60, 100, 30);
        datosClientePanel.add(Telefono);

        // TEXTO DENTRO DEL PANEL 
        JTextField textoDocumento = new JTextField();
        textoDocumento.setBounds(120, 35, 150, 20);
        datosClientePanel.add(textoDocumento);

        JTextField textoDireccion = new JTextField();
        textoDireccion.setBounds(120, 65, 150, 20);
        datosClientePanel.add(textoDireccion);

        JTextField textoNombre = new JTextField();
        textoNombre.setBounds(400, 35, 140, 20);
        datosClientePanel.add(textoNombre);

        JTextField textoTelefono = new JTextField();
        textoTelefono.setBounds(400, 65, 140, 20);
        datosClientePanel.add(textoTelefono);
        
       
        //DATOS FACTURA
        JPanel datosFacturaPanel = new JPanel();
        datosFacturaPanel.setBounds(20, 225, 560, 80); 
        datosFacturaPanel.setLayout(null);

        
        datosFacturaPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1),
            "Datos del cliente",                            
            TitledBorder.LEFT,                              
            TitledBorder.TOP,                               
            new Font("Arial", Font.BOLD, 14),               
            Color.BLACK                                     
        ));

        login_container.add(datosFacturaPanel);
        
        JLabel numFactura = new JLabel("№ Factura:    1");
        numFactura.setBounds(20, 25, 100, 30);
        datosFacturaPanel.add(numFactura);
        
        JLabel fecha = new JLabel("Fecha:   2026/03/25");
        fecha.setBounds(300, 25, 150, 30);
        datosFacturaPanel.add(fecha);
        
        
        
        
        JPanel optPanel = new JPanel();
        optPanel.setBounds(22, 310, 557, 30); 
        optPanel.setLayout(null);

        // DATOS OPCIONES
        optPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1),
            "",                            
            TitledBorder.LEFT,                              
            TitledBorder.TOP,                               
            new Font("Arial", Font.BOLD, 14),               
            Color.BLACK                                     
        ));
        
        login_container.add(optPanel);
        
     
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/images/barra.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);
        
        JLabel lista = new JLabel("Ver listado de factura");
        lista.setBounds(70, 0, 200, 30);
        lista.setIcon(icono);
        lista.setHorizontalTextPosition(SwingConstants.RIGHT);
        lista.setVerticalTextPosition(SwingConstants.CENTER);

        optPanel.add(lista);
        
        // AÑADIR
        JLabel añadir = new JLabel("Añadir");
        añadir.setBounds(400, 0, 150, 30);

        ImageIcon iconoAddOriginal = new ImageIcon(getClass().getResource("/images/agregar.png"));
        Image imgAdd = iconoAddOriginal.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        añadir.setIcon(new ImageIcon(imgAdd));

        añadir.setHorizontalTextPosition(SwingConstants.RIGHT);
        añadir.setVerticalTextPosition(SwingConstants.CENTER);

        optPanel.add(añadir);

        // ELIMINAR
        JLabel eliminar = new JLabel("Eliminar");
        eliminar.setBounds(480, 0, 150, 30);

        ImageIcon iconoDelOriginal = new ImageIcon(getClass().getResource("/images/eliminar.png"));
        Image imgDel = iconoDelOriginal.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        eliminar.setIcon(new ImageIcon(imgDel));

        eliminar.setHorizontalTextPosition(SwingConstants.RIGHT);
        eliminar.setVerticalTextPosition(SwingConstants.CENTER);

        optPanel.add(eliminar);
        
        // DATOS DE LA TABLA 
        String[] columnas = {"Producto", "Cantidad", "Valor", "Sub Total"};

        Object[][] datos = {
            {"Agua", 2, 500, 1000.0},
            {"Cereal", 5, 1000, 5000.0},
            {"Leche", 2, 300, 600.0}
        };

        JTable tabla = new JTable(datos, columnas);
        
        tabla.setRowHeight(25);
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        
        JScrollPane scrollTabla = new JScrollPane(tabla);
        scrollTabla.setBounds(20, 350, 560, 100); 
        
        login_container.add(scrollTabla);
        
        
        // DATOS
        
        JLabel subTotal = new JLabel("SubTotal: 6600.0");
        subTotal.setBounds(20, 460, 150, 30);
        login_container.add(subTotal);
        
        JLabel descuento = new JLabel("% Descuento: ");
        descuento.setBounds(20, 490, 150, 30);
        login_container.add(descuento);
        
        JTextField campoNumero = new JTextField("5"); 
        campoNumero.setBounds(110, 495, 30, 20); 
        login_container.add(campoNumero);

        JCheckBox check = new JCheckBox();
        check.setBounds(160, 492, 25, 25); 
        check.setSelected(false); 
        login_container.add(check);
        
        JLabel valor_descuento = new JLabel("Valor descontado:  330.0 ");
        valor_descuento.setBounds(210, 488, 200, 30);
        login_container.add(valor_descuento);
        
        JLabel iva = new JLabel("IVA 19%: 1254.0 ");
        iva.setBounds(20, 520, 200, 30);
        login_container.add(iva);
        
        JLabel total = new JLabel("Total Factura: 7524.0  ");
        total.setBounds(20, 550, 200, 30);
        login_container.add(total);
        
        
        // Botón Finalizar factura
        JButton btnFinalizar = new JButton("Finalizar factura");
        btnFinalizar.setBounds(320, 585, 150, 20); 
        btnFinalizar.setBackground(Color.WHITE);  
        btnFinalizar.setFocusPainted(false);
        btnFinalizar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        login_container.add(btnFinalizar);

        // Botón Limpiar
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(480, 585, 100, 20);
        btnLimpiar.setBackground(Color.WHITE);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        login_container.add(btnLimpiar);

        
        JPanel barra1 = new JPanel();
        barra1.setBounds(0, 610, 600, 15); 
        barra1.setBackground(Color.decode("#1053A3"));
        login_container.add(barra1);
    
	}


}