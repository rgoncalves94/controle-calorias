package controle.calorias.view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class RefeicaoView {

	JFrame frame = new JFrame("Controle de Calorias");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new RefeicaoView();
	}

	/**
	 * Create the application.
	 */
	public RefeicaoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}
