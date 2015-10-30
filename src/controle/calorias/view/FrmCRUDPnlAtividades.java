package controle.calorias.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrmCRUDPnlAtividades extends JPanel {

	private static final long serialVersionUID = 1L;

	public FrmCRUDPnlAtividades() {
		this.setBackground(Color.BLUE);
		this.setSize(1024, 330);
		this.setLayout(null);
		this.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,
				Color.DARK_GRAY));

		JLabel lblControleAtividades = new JLabel("Controle de Atividades");
		lblControleAtividades.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblControleAtividades.setBounds(5, 5, 524, 20);
		lblControleAtividades.setBorder(BorderFactory.createMatteBorder(0, 0,
				1, 0, Color.DARK_GRAY));
		this.add(lblControleAtividades);
	}
}