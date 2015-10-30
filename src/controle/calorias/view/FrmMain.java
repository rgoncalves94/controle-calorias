package controle.calorias.view;

import javax.swing.JFrame;

public class FrmMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private PnlHeader pnlHeader;
	private FrmMainPnlPerfil pnlPerfil;
	private FrmMainPnlDados pnlDados;
	private FrmMainPnlAlimentos pnlAlimentos;
	private FrmMainPnlAtividades pnlAtividades;
	private PnlBaseBoard pnlBaseBoard;

	public FrmMain() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("POO - Gerenciador de Calorias");
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(1024, 728);

		pnlHeader = new PnlHeader();
		pnlHeader.setLocation(0, 0);
		this.add(pnlHeader);

		pnlPerfil = new FrmMainPnlPerfil();
		pnlPerfil.setLocation(0, 20);
		this.add(pnlPerfil);

		pnlDados = new FrmMainPnlDados();
		pnlDados.setLocation(250, 20);
		this.add(pnlDados);

		pnlAlimentos = new FrmMainPnlAlimentos();
		pnlAlimentos.setLocation(612, 40);
		this.add(pnlAlimentos);
		
		pnlAtividades = new FrmMainPnlAtividades();
		pnlAtividades.setLocation(612, 360);
		this.add(pnlAtividades);

		pnlBaseBoard = new PnlBaseBoard();
		pnlBaseBoard.setLocation(0, 680);
		this.add(pnlBaseBoard);
	}

	public static void main(String[] args) {
		new FrmMain();
	}
}