package controle.calorias.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class FrmMainPnlDados extends JPanel {
	private static final long serialVersionUID = 1L;

	public FrmMainPnlDados() {
		this.setBackground(Color.ORANGE);
		this.setSize(362, 660);
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
	}
}