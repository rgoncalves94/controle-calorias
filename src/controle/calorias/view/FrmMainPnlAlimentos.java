package controle.calorias.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrmMainPnlAlimentos extends JPanel {
	private static final long serialVersionUID = 1L;

	public FrmMainPnlAlimentos() {
		this.setBackground(Color.PINK);
		this.setSize(412, 320);

		JLabel titulo = new JLabel("Alimentos Consumidos");
		this.add(titulo);
	}
}