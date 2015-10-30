package controle.calorias.view;

import javax.swing.JFrame;

public class FrmCRUD extends JFrame {
	private static final long serialVersionUID = 1L;
	private PnlHeader pnlHeader;
	private FrmCRUDPnlALimentos frmCRUDPnlAlimentos;
	private FrmCRUDPnlAtividades frmCRUDPnlExercicios;
	private PnlBaseBoard painelBottom;

	public FrmCRUD() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("POO - Gerenciador de Calorias");
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(1024, 728);

		pnlHeader = new PnlHeader();
		pnlHeader.setLocation(0, 0);
		this.add(pnlHeader);
		
		frmCRUDPnlAlimentos = new FrmCRUDPnlALimentos();
		frmCRUDPnlAlimentos.setLocation(0, 20);
		this.add(frmCRUDPnlAlimentos);
		
		frmCRUDPnlExercicios = new FrmCRUDPnlAtividades();
		frmCRUDPnlExercicios.setLocation(0, 350);
		this.add(frmCRUDPnlExercicios);

		painelBottom = new PnlBaseBoard();
		painelBottom.setLocation(0, 680);
		this.add(painelBottom);
	}
	
	public static void main(String[] args) {
		new FrmCRUD();
	}
}