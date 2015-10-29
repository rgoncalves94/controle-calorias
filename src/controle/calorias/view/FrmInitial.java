package controle.calorias.view;

import javax.swing.JFrame;

public class FrmInitial extends JFrame {
	private static final long serialVersionUID = 1L;
	private PnlHeader pnlHeader;
	private FrmInitialPnlUsuario pnlUsuario;
	private FrmInitialPnlBackground pnlBackground;
	private PnlBaseBoard pnlBaseBoard;

	public FrmInitial() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("POO- Controle de Calorias");
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(1024, 728);

		pnlHeader = new PnlHeader();
		pnlHeader.setLocation(0, 0);
		this.add(pnlHeader);

		pnlUsuario = new FrmInitialPnlUsuario();
		pnlUsuario.setLocation(0, 20);
		this.add(pnlUsuario);

		pnlBackground = new FrmInitialPnlBackground();
		pnlBackground.setLocation(300, 20);
		this.add(pnlBackground);

		pnlBaseBoard = new PnlBaseBoard();
		pnlBaseBoard.setLocation(0, 680);
		this.add(pnlBaseBoard);
	}

	public static void main(String[] args) {
		new FrmInitial();
	}
}
