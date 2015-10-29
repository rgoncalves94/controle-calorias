package controle.calorias.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PnlBaseBoard extends JPanel {
	private static final long serialVersionUID = 1L;

	public PnlBaseBoard() {
		this.setBackground(Color.DARK_GRAY);
		this.setSize(1024, 20);
		this.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,
				Color.DARK_GRAY));

		JLabel lblCredits = new JLabel("Powered by R2F Developers");
		lblCredits.setForeground(Color.WHITE);
		lblCredits.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblCredits.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(lblCredits);
		lblCredits.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop desk = java.awt.Desktop.getDesktop();
				try {
					desk.browse(new URI("http://www.rafagoncalves.com.br/"));
				} catch (URISyntaxException | IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi possível acessar o link");
				}
			}
		});
	}
}
