package controle.calorias.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PrincipalView extends JFrame {

	private static final long serialVersionUID = 1L;
	private PainelTop painelTop;
	private PrincipalPainelLeft painelLeft;
	private PrincipalPainelCenter painelCenter;
	private PrincipalPainelRight painelRight;
	private PainelBottom painelBottom;

	public PrincipalView() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("POO-Gerenciador de Calorias");
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(1024, 728);

		painelTop = new PainelTop();
		painelTop.setLocation(0, 0);
		this.add(painelTop);

		painelLeft = new PrincipalPainelLeft();
		painelLeft.setLocation(0, 20);
		this.add(painelLeft);

		painelCenter = new PrincipalPainelCenter();
		painelCenter.setLocation(200, 20);
		this.add(painelCenter);

		painelRight = new PrincipalPainelRight();
		painelRight.setLocation(674, 20);
		this.add(painelRight);

		painelBottom = new PainelBottom();
		painelBottom.setLocation(0, 680);
		this.add(painelBottom);
	}

	public static void main(String[] args) {
		new PrincipalView();
	}
}

class PrincipalPainelLeft extends JPanel {
	private static final long serialVersionUID = 1L;

	public PrincipalPainelLeft() {
		 this.setBackground(Color.BLUE);
		this.setSize(200, 660);
	}
}

class PrincipalPainelCenter extends JPanel {
	private static final long serialVersionUID = 1L;

	public PrincipalPainelCenter() {
		 this.setBackground(Color.ORANGE);
		this.setSize(474, 660);
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
	}
}

class PrincipalPainelRight extends JPanel {
	private static final long serialVersionUID = 1L;

	public PrincipalPainelRight() {
		 this.setBackground(Color.GREEN);
		this.setSize(350, 660);
	}
}