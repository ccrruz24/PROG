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

public class Ventana extends JFrame {

	public Ventana() {

		this.setSize(1000, 1000);
		// this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(200, 200));
		this.setMaximumSize(new Dimension(1000, 1000));
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.black);
		this.setLayout(new BorderLayout());
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

		// this.login();
		// this.registro();
		// this.users();
		// this.calculadora();
		// this.interes();
		// this.paint();
		this.draw();

		this.setVisible(true);
		this.repaint();
	}

	public void login() {

		JPanel login_container = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/login.png")).getImage();

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

		JButton acces_btn = new JButton();
		acces_btn.setText("Acceder");
		acces_btn.setSize(200, 40);
		acces_btn.setLocation(100, 350);
		acces_btn.setFont(new Font("Arial", Font.ITALIC, 18));
		login_container.add(acces_btn);

		JPasswordField password = new JPasswordField();
		password.setSize(280, 40);
		password.setLocation(60, 250);
		login_container.add(password);
	}

	public void registro() {

		JPanel rgs_container = new JPanel();
		rgs_container.setBounds(500, 50, 400, 600);
		rgs_container.setOpaque(true);
		rgs_container.setBackground(Color.decode("#5836C7"));
		rgs_container.setLayout(null);
		this.add(rgs_container);

		// TITULO

		// LABEL NAME

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
		opt_sweet.setForeground(Color.white);
		opt_sweet.setOpaque(false);
		rgs_container.add(opt_sweet);

		JCheckBox opt_salty = new JCheckBox("Salado");
		opt_salty.setBounds(150, 320, 100, 40);
		opt_salty.setForeground(Color.white);
		opt_salty.setOpaque(false);
		rgs_container.add(opt_salty);

		JCheckBox opt_healty = new JCheckBox("Saludable");
		opt_healty.setBounds(250, 320, 100, 40);
		opt_healty.setForeground(Color.white);
		opt_healty.setOpaque(false);
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
		accept_terms.setBounds(50, 400, 180, 40);
		accept_terms.setOpaque(false);
		accept_terms.setForeground(Color.white);
		rgs_container.add(accept_terms);

		JRadioButton reject_terms = new JRadioButton("Rechazo los terminos ");
		reject_terms.setBounds(220, 400, 200, 40);
		reject_terms.setOpaque(false);
		reject_terms.setForeground(Color.white);
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

	public void calculadora() {
		JPanel panel_user = new JPanel();
		panel_user.setSize(500, 700);
		panel_user.setLocation(250, 50);
		panel_user.setBackground(Color.decode("#2D2E33"));
		panel_user.setLayout(null);
		this.add(panel_user);

		JLabel field = new JLabel("10 varos");
		field.setSize(280, 40);
		field.setLocation(10, 10);
		field.setOpaque(true);
		field.setBackground(Color.white);
		field.setFont(new Font("Arial", Font.BOLD, 22));
		field.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		panel_user.add(field);

		int cor_x = 30, cor_y = 60;
		String[] botones = { "CE", "", "", "", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "+", "0", ".",
				"-", "=" };

		for (int i = 0; i < 20; i++) {
			JButton ce = new JButton(botones[i]);
			ce.setSize(100, 100);
			ce.setLocation(cor_x, cor_y);
			panel_user.add(ce);

			cor_x += 110;
			panel_user.add(ce);

			if (cor_x >= 420) {
				cor_x = 30;
				cor_y += 110;
			}

		}
	}

	public void interes() {

		JLabel textinterets = new JLabel("Interés");
		textinterets.setBounds(100, 20, 200, 100);
		textinterets.setForeground(Color.red);
		textinterets.setOpaque(false);
		textinterets.setFont(new Font("SansSerif", Font.ITALIC, 50));
		this.add(textinterets);

		JPanel interest_container = new JPanel();
		interest_container.setSize(600, 300);
		interest_container.setLocation(200, 100);
		interest_container.setBackground(Color.decode("#8BE098"));
		interest_container.setLayout(null);
		interest_container.setBorder(BorderFactory.createEtchedBorder());
		this.add(interest_container);

		// Título
		JLabel titulo = new JLabel("Calcular Interés");
		titulo.setSize(400, 40);
		titulo.setLocation(-100, 0);
		titulo.setFont(new Font("Arial", Font.BOLD, 26));
		titulo.setForeground(Color.BLACK);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		interest_container.add(titulo);

		// Etiquetas y campos
		JLabel capital = new JLabel("Capital:");
		capital.setBounds(50, 80, 120, 30);
		capital.setFont(new Font("SansSerif", Font.ITALIC, 20));
		interest_container.add(capital);

		JTextField textCapital = new JTextField();
		textCapital.setBounds(300, 80, 200, 30);
		interest_container.add(textCapital);

		JLabel time = new JLabel("Tiempo :");
		time.setBounds(50, 130, 120, 30);
		time.setFont(new Font("SansSerif", Font.ITALIC, 20));
		interest_container.add(time);

		JTextField textTime = new JTextField();
		textTime.setBounds(300, 130, 200, 30);
		interest_container.add(textTime);

		JLabel tasa = new JLabel("Tasa de interés:");
		tasa.setBounds(50, 180, 150, 30);
		tasa.setFont(new Font("SansSerif", Font.ITALIC, 20));
		interest_container.add(tasa);

		JTextField textTasa = new JTextField();
		textTasa.setBounds(300, 180, 200, 30);
		interest_container.add(textTasa);

		// Botón Guardar con ícono desde resources
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(200, 240, 120, 40);

		// Cargar y escalar ícono
		ImageIcon iconoGuardar = new ImageIcon(getClass().getResource("/images/guardar.jpg"));
		Image imgGuardar = iconoGuardar.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnGuardar.setIcon(new ImageIcon(imgGuardar));

		// Ajustar posición del texto respecto al ícono
		btnGuardar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnGuardar.setVerticalTextPosition(SwingConstants.CENTER);

		interest_container.add(btnGuardar);

		// Botón Cancelar con ícono desde resources
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(340, 240, 120, 40);

		// Cargar y escalar ícono
		ImageIcon iconoCancelar = new ImageIcon(getClass().getResource("/images/cancelar.jpg"));
		Image imgCancelar = iconoCancelar.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnCancelar.setIcon(new ImageIcon(imgCancelar));

		// Ajustar posición del texto respecto al ícono
		btnCancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelar.setVerticalTextPosition(SwingConstants.CENTER);

		interest_container.add(btnCancelar);

		JPanel interest_results = new JPanel();
		interest_results.setSize(600, 200);
		interest_results.setLocation(200, 450);
		interest_results.setBackground(Color.decode("#EB9898"));
		interest_results.setLayout(null);
		this.add(interest_results);

		// Panel de resultados
		JLabel interest = new JLabel("Interés: ");
		interest.setBounds(50, 50, 200, 30);
		interest.setFont(new Font("SansSerif", Font.ITALIC, 20));
		interest_results.add(interest);

		JTextField textInterest = new JTextField();
		textInterest.setBounds(300, 50, 200, 30);
		interest_results.add(textInterest);

		JLabel amount = new JLabel("Monto Final: ");
		amount.setBounds(50, 120, 200, 30);
		amount.setFont(new Font("SansSerif", Font.ITALIC, 20));
		interest_results.add(amount);

		JTextField textAmount = new JTextField();
		textAmount.setBounds(300, 120, 200, 30);
		interest_results.add(textAmount);

	}

	public void paint() {

		JPanel pane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2d = (Graphics2D) g;

				g2d.drawLine(0, 0, 1000, 700);

				g2d.setColor(Color.red);
				g2d.setStroke(new BasicStroke(3));
				g2d.drawOval(100, 100, 150, 50);

				g2d.setStroke(new BasicStroke(3));

				g2d.setColor(Color.green);
				g2d.drawPolygon(new int[] { 300, 100, 500 }, new int[] { 100, 300, 300 }, 3);

				g2d.setColor(Color.cyan);
				g2d.drawRect(250, 300, 100, 100);
				g2d.drawRoundRect(500, 150, 100, 100, 10, 10);

				g2d.drawArc(400, 100, 100, 100, 0, 90);

				g2d.setFont(new Font("Arial", Font.BOLD, 22));
				g2d.drawString("Hola", 100, 100);

				g2d.setColor(Color.blue);
				g2d.fillOval(500, 50, 50, 50);
				g2d.fillPolygon(new int[] { 500, 300, 700 }, new int[] { 300, 500, 500 }, 3);
				g2d.fillRect(500, 500, 100, 100);

				g2d.setColor(Color.orange);
				g2d.fillRoundRect(500, 500, 100, 100, 10, 10);

				g2d.fillArc(450, 150, 100, 100, 0, 300);

				BufferedImage image;
				try {

					image = ImageIO.read(new File("src/images/cancelar.jpg"));
					g2d.drawImage(image, 0, 0, null);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};
		pane.setSize(1000, 700);
		pane.setLocation(0, 0);
		this.add(pane);
	}

	public void draw() {
		JPanel pane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2d = (Graphics2D) g;
				
				//fondo
				g2d.setColor(Color.decode("#79D6ED")); // azul cielo
				g2d.fillRect(0, 0, getWidth(), getHeight());
				
				
			 // cerca con postes y travesaños
			    for (int x = 50; x <= 900; x += 60) {
			        // poste rectangular
			        g2d.setColor(Color.decode("#C19A6B")); 
			        g2d.fillRect(x, 500, 40, 150);

			        // punta del poste
			        int[] xPunta = { x, x + 20, x + 40 };
			        int[] yPunta = { 500, 460, 500 };
			        g2d.setColor(Color.decode("#C19A6B")); 
			        g2d.fillPolygon(xPunta, yPunta, 3);
			    }

			    // travesaños horizontales
			    g2d.setColor(Color.decode("#695328"));
			    g2d.fillRect(50, 630, 850, 50); 
			     

				// cuadro de casa
				g2d.setColor(Color.decode("#DBC07B"));
				g2d.fillRect(290, 260, 400, 300);

				// franjas horizontales en la pared
				g2d.setColor(Color.decode("#B08A4A"));
				for (int y = 270; y < 560; y += 40) {
					g2d.fillRect(290, y, 400, 5);
				}

				// Pasto
				g2d.setColor(Color.decode("#416141"));
				g2d.fillRect(0, 620, 984, 30);

				g2d.setColor(Color.decode("#8DD485"));
				g2d.fillRect(0, 650, 984, 30);

				// Tierra
				g2d.setColor(Color.decode("#E0E0A2"));
				g2d.fillRect(0, 680, 984, 480);

				g2d.setColor(Color.decode("#69574F"));
				g2d.fillRect(0, 720, 984, 480);

				// piso
				g2d.setColor(Color.decode("#929692"));
				g2d.fillRect(240, 560, 500, 60);

				// puerta
				g2d.setColor(Color.decode("#967741"));
				g2d.fillRect(330, 360, 100, 200);

				// marco
				g2d.setColor(Color.decode("#69512D"));
				g2d.fillRect(330, 353, 100, 7);

				g2d.setColor(Color.decode("#69512D"));
				g2d.fillRect(330, 556, 100, 4);

				g2d.setColor(Color.decode("#69512D"));
				g2d.fillRect(330, 353, 7, 206);

				g2d.setColor(Color.decode("#69512D"));
				g2d.fillRect(430, 353, 7, 207);

				// ventana
				g2d.setColor(Color.decode("#B01212"));
				g2d.fillRect(540, 360, 120, 120);

				g2d.setColor(Color.decode("#FAFAFA"));
				g2d.fillRect(545, 365, 50, 50);

				g2d.setColor(Color.decode("#FAFAFA"));
				g2d.fillRect(605, 365, 50, 50);

				g2d.setColor(Color.decode("#FAFAFA"));
				g2d.fillRect(545, 425, 50, 50);

				g2d.setColor(Color.decode("#FAFAFA"));
				g2d.fillRect(605, 425, 50, 50);

				g2d.setColor(Color.decode("#4F4D4D"));
				g2d.fillRect(536, 478, 130, 15);

				// perilla
				g2d.setColor(Color.decode("#EBEBEB"));
				g2d.fillOval(405, 460, 10, 10);
				

				//chimenea
				g2d.setColor(Color.decode("#4F4D4D"));
				g2d.fillRect(535, 100, 112, 40);
				
				
				g2d.setColor(Color.decode("#878787"));
				g2d.fillRect(551, 140, 80, 100);
				
				
				
				// techo
				int xTecho[] = { 250, 370, 740 };
				int yTecho[] = { 260, 80, 260 };

				g.setColor(Color.decode("#9C0B0B"));
				g.fillPolygon(xTecho, yTecho, 3);

			}
		};
		pane.setSize(1000, 700);
		pane.setLocation(0, 0);
		this.add(pane);
	}

}