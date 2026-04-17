package Prueba;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class Paint extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;


    public Paint() {
        setTitle("Paint");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.add(crearSeccionBotones("Formas", new String[]{"Rectángulo", "Círculo", "Triángulo", "Línea"}));
        panelSuperior.add(crearSeccionBotones("Herramientas", new String[]{"Pincel", "Borrador", "Relleno", "Deshacer", "Rehacer"}));
        panelSuperior.add(crearSeccionColoresTop());
        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));
        panelLateral.setPreferredSize(new Dimension(200, 0));
        panelLateral.setBorder(new EmptyBorder(5, 5, 5, 5));

        panelLateral.add(crearSeccionOpciones());
        panelLateral.add(Box.createRigidArea(new Dimension(0, 5)));
        panelLateral.add(crearSeccionColoresRapidos());
        panelLateral.add(Box.createRigidArea(new Dimension(0, 5)));
        panelLateral.add(crearSeccionAcciones());

        add(panelLateral, BorderLayout.WEST);

        JPanel lienzo = new JPanel();
        lienzo.setBackground(Color.WHITE);
        lienzo.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        add(lienzo, BorderLayout.CENTER);
    }

    private JPanel crearSeccionColoresRapidos() {
        JPanel contenedor = new JPanel(new GridLayout(1,0,4,4));
        contenedor.setBorder(BorderFactory.createTitledBorder("Colores rápidos"));
        
        contenedor.setMaximumSize(new Dimension(190, 50)); 

        Color[] colores = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA};
        for (Color c : colores) {
            contenedor.add(crearMuestraColor(c));
        }
        
        return contenedor;
    }

    private JPanel crearMuestraColor(Color c) {
        JPanel cuadro = new JPanel();
        cuadro.setBackground(c);
        cuadro.setPreferredSize(new Dimension(18, 18));
        cuadro.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        return cuadro;
    }

    private JPanel crearSeccionBotones(String titulo, String[] nombres) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
        for (String nombre : nombres) {
            panel.add(new JButton(nombre));
        }
        return panel;
    }

    private JPanel crearSeccionColoresTop() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Colores"));
        Color[] colores = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA};
        for (Color c : colores) {
            panel.add(crearMuestraColor(c));
        }
        panel.add(new JButton("Más..."));
        return panel;
    }

    private JPanel crearSeccionOpciones() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Opciones"));
        
        JPanel filaTamaño = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaTamaño.add(new JLabel("Tamaño:"));
        filaTamaño.add(new JSpinner(new SpinnerNumberModel(5, 1, 50, 1)));
        
        panel.add(filaTamaño);
        panel.add(new JCheckBox("Relleno"));
        panel.setMaximumSize(new Dimension(200, 100));
        return panel;
    }

    private JPanel crearSeccionAcciones() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Acciones"));
        panel.add(new JButton("Limpiar lienzo"));
        panel.add(new JButton("Guardar como imagen"));
        panel.setMaximumSize(new Dimension(200, 100));
        return panel;
    }
}