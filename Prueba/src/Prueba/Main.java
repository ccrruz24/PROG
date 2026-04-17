package Prueba;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		
		//Ventana miVentana = new Ventana ();
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		SwingUtilities.invokeLater(() -> {
            Paint app = new Paint();
            app.setLocationRelativeTo(null);
            app.setVisible(true);
        });

	}

}