package Prueba;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.Timer;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Memorama extends JFrame {

	private JPanel contentPane;
    public Integer[] cartas = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
    public int[] status = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int tarjetas_mostradas = 0;
    public int carta_1 = 0, carta_2 = 0;
    public List<JButton> botonesActivos = new ArrayList<>();
    
 // Variables
    private int segundos = 0;
    private int movimientos = 0;
    private int paresEncontrados = 0;
    private JLabel lblTiempo;
    private JLabel lblMovimientos;
    private JLabel lblPares;
    private Timer cronometro;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Memorama frame = new Memorama();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

	    public Memorama() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 640, 740);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(192, 192, 192));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(new BorderLayout(0, 0));

	        List<Integer> lista = Arrays.asList(cartas);
	        Collections.shuffle(lista);
	        lista.toArray(cartas);

	        JPanel panelCentral = new JPanel();
	        panelCentral.setBackground(new Color(192, 192, 192));
	        contentPane.add(panelCentral, BorderLayout.CENTER);
	        panelCentral.setLayout(new GridLayout(0, 4, 10, 10)); 

	        for (int i = 0; i < 12; i++) {
	            final int index = i;
	            BotonRedondeado btn = new BotonRedondeado("?");
	            btn.setIcon(new ImageIcon(getClass().getResource("/images/signo-de-interrogacion.png")));
	            
	            btn.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    flip(index, btn);
	                }
	            });
	            panelCentral.add(btn);
	        }

	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(new Color(0, 128, 192));
	        contentPane.add(panel_1, BorderLayout.SOUTH);

	        BotonRedondeado btnReiniciar = new BotonRedondeado("Reiniciar");
	        btnReiniciar.addActionListener(e -> {
	            cronometro.stop();
	            dispose();
	            new Memorama().setVisible(true);
	        });
	        panel_1.add(btnReiniciar);

	        BotonRedondeado btnPausa = new BotonRedondeado("Pausa");
	        btnPausa.addActionListener(e -> {
	            cronometro.stop();
	            //btnPausa.setBackground(Color.YELLOW);
	        });
	        panel_1.add(btnPausa);

	        BotonRedondeado btnReanudar = new BotonRedondeado("Reanudar");
	        btnReanudar.addActionListener(e -> {
	            if (!cronometro.isRunning()) {
	                cronometro.start();
	                btnPausa.setBackground(null);
	            }
	        });
	        panel_1.add(btnReanudar);

	        // Marcadores
	        JPanel panel_2 = new JPanel();
	        panel_2.setBackground(new Color(0, 128, 192));
	        contentPane.add(panel_2, BorderLayout.NORTH);
	        panel_2.setLayout(new GridLayout(0, 3, 0, 0));

	        lblMovimientos = new JLabel("Movimientos: 0");
	        lblMovimientos.setHorizontalAlignment(SwingConstants.CENTER);
	        panel_2.add(lblMovimientos);

	        lblTiempo = new JLabel("Tiempo: 0s");
	        lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
	        panel_2.add(lblTiempo);

	        lblPares = new JLabel("Pares: 0");
	        lblPares.setHorizontalAlignment(SwingConstants.CENTER);
	        panel_2.add(lblPares);

	        // Cronometro
	        iniciarCronometro();
	    }

	    private void iniciarCronometro() {
	        cronometro = new Timer(1000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                segundos++;
	                lblTiempo.setText("Tiempo: " + segundos + "s");
	            }
	        });
	        cronometro.start();
	    }

	    public void flip(Integer n, JButton b) {
	        if (status[n] == 0 && tarjetas_mostradas < 2) {
	            b.setIcon(new ImageIcon(getClass().getResource("/images/" + cartas[n] + ".png")));
	            
	            if (tarjetas_mostradas == 0) {
	                carta_1 = cartas[n];
	            } else {
	                carta_2 = cartas[n];
	                movimientos++;
	                lblMovimientos.setText("Movimientos: " + movimientos);
	            }

	            status[n] = 1;
	            botonesActivos.add(b);
	            tarjetas_mostradas++;

	            if (tarjetas_mostradas == 2) {
	                Timer delay = new Timer(800, e -> {
	                    checkMatch();
	                });
	                delay.setRepeats(false);
	                delay.start();
	            }
	        }
	    }

	    private void checkMatch() {
	        if (carta_1 == carta_2) {
	            paresEncontrados++;
	            lblPares.setText("Pares: " + paresEncontrados);
	            
	            for (JButton btn : botonesActivos) {
	                btn.setEnabled(false);
	            }
	            
	            if (paresEncontrados == 6) {
	                cronometro.stop();
	            }
	        } else {
	            for (JButton btn : botonesActivos) {
	                btn.setIcon(new ImageIcon(getClass().getResource("/images/signo-de-interrogacion.png")));
	            }
	            resetStatus(); 
	        }
	        
	        botonesActivos.clear();
	        tarjetas_mostradas = 0;
	        carta_1 = 0;
	        carta_2 = 0;
	    }

	    private void resetStatus() {
	        for (int i = 0; i < 12; i++) {
	            if (status[i] == 1) status[i] = 0;
	        }

	}

}
