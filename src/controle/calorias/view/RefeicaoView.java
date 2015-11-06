package controle.calorias.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class RefeicaoView {

	JFrame frame = new JFrame("Controle de Calorias");
	private JLabel logo;
	private JScrollPane scrollPane;
	private JTable table;

	private JLabel lblRefeicao;
	private JComboBox cmbRefeicao;

	private JLabel lblAlimento;
	private JComboBox cmbAlimento;

	private JLabel lblQtde;
	private JSpinner txtQtde;

	private JButton btnRemover;
	private JButton btnLimparTudo;
	private JButton btnFinalizar;
	private JButton btnAdicionar;

	public static void main(String[] args) {
		new RefeicaoView();
	}

	public RefeicaoView() {
		initialize();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void initialize() {

		frame.setBounds(100, 100, 833, 503);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 25, 517, 373);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		logo = new JLabel("Controle Calorias");
		logo.setBounds(21, 25, 243, 83);
		frame.getContentPane().add(logo);

		cmbRefeicao = new JComboBox();
		cmbRefeicao.setBounds(21, 137, 243, 31);
		frame.getContentPane().add(cmbRefeicao);

		lblRefeicao = new JLabel("Refei\u00E7\u00E3o");
		lblRefeicao.setBounds(21, 109, 243, 31);
		frame.getContentPane().add(lblRefeicao);

		lblAlimento = new JLabel("Alimento");
		lblAlimento.setBounds(21, 193, 243, 31);
		frame.getContentPane().add(lblAlimento);

		cmbAlimento = new JComboBox();
		cmbAlimento.setBounds(21, 222, 243, 31);
		frame.getContentPane().add(cmbAlimento);

		lblQtde = new JLabel("Quantidade");
		lblQtde.setBounds(21, 264, 243, 31);
		frame.getContentPane().add(lblQtde);

		txtQtde = new JSpinner();
		txtQtde.setBounds(21, 290, 243, 31);
		frame.getContentPane().add(txtQtde);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(21, 332, 243, 55);
		frame.getContentPane().add(btnAdicionar);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(21, 399, 243, 55);
		frame.getContentPane().add(btnFinalizar);

		btnLimparTudo = new JButton("Limpar Tudo");
		btnLimparTudo.setBounds(551, 409, 126, 45);
		frame.getContentPane().add(btnLimparTudo);

		btnRemover = new JButton("Remover");
		btnRemover.setBounds(687, 409, 120, 45);
		frame.getContentPane().add(btnRemover);
	}
}
