package controle.calorias.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PnlHeader extends JPanel {
	private static final long serialVersionUID = 1L;

	public PnlHeader() {
		this.setSize(1024, 20);
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Color.DARK_GRAY));

		JLabel lblAcessoAdm = new JLabel("Acesso Administrativo");
		lblAcessoAdm.setForeground(Color.WHITE);
		lblAcessoAdm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAcessoAdm.setBounds(900, 4, 130, 12);
		lblAcessoAdm.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(lblAcessoAdm);
	}
}