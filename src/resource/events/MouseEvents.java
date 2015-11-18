package resource.events;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import controle.calorias.view.AdministrativoViewer;

public class MouseEvents implements MouseListener{
	private Color color1;
	private Color color2;

	public MouseEvents(Color color1, Color color2) {
		this.color1 = color1;
		this.color2 = color2;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().getClass().equals(JButton.class)) {
			JButton b = (JButton) e.getSource();
			b.setForeground(color1);
			b.setBackground(color2);
		} else if (e.getSource().getClass().equals(JLabel.class)) {
			JLabel l = (JLabel) e.getSource();
			l.setForeground(color1);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().getClass().equals(JButton.class)) {
			JButton b = (JButton) e.getSource();
			b.setForeground(color2);
			b.setBackground(color1);
		} else if (e.getSource().getClass().equals(JLabel.class)) {
			JLabel l = (JLabel) e.getSource();
			l.setForeground(color2);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}