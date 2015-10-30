package controle.calorias.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrmMainPnlAtividades extends JPanel {
	private static final long serialVersionUID = 1L;

	public FrmMainPnlAtividades() {
		this.setBackground(Color.GREEN);
		this.setSize(412, 320);

		JLabel titulo = new JLabel("Atividades Realizadas");
		this.add(titulo);
	}
}