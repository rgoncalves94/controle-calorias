package controle.calorias.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controle.calorias.control.AlimentoComboModel;
import controle.calorias.control.AlimentoController;
import controle.calorias.control.AlimentoTableModel;
import controle.calorias.control.RefeicaoController;
import controle.calorias.control.TipoRefeicaoComboModel;
import controle.calorias.model.Alimento;
import controle.calorias.model.Refeicao;
import controle.calorias.model.TipoRefeicao;
import controle.calorias.model.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;

public class RefeicaoView implements ActionListener {

	JFrame frame = new JFrame("SlimSoft");
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

	private AlimentoComboModel ctrlAlimentoComboModel;
	private AlimentoTableModel ctrlAlimentoTableModel;
	private TipoRefeicaoComboModel ctrlTipoRefeicaoComboModel;

	public static void main(String[] args) {
		new RefeicaoView();
	}

	public RefeicaoView() {
		ctrlAlimentoComboModel = new AlimentoComboModel();
		ctrlAlimentoTableModel = new AlimentoTableModel();
		ctrlTipoRefeicaoComboModel = new TipoRefeicaoComboModel();
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

		table = new JTable(ctrlAlimentoTableModel);
		scrollPane.setViewportView(table);

		logo = new JLabel("Controle Calorias");
		logo.setBounds(21, 25, 243, 83);
		frame.getContentPane().add(logo);

		cmbRefeicao = new JComboBox();
		cmbRefeicao.setBounds(21, 137, 243, 31);
		cmbRefeicao.setModel(ctrlTipoRefeicaoComboModel);
		frame.getContentPane().add(cmbRefeicao);

		lblRefeicao = new JLabel("Refei\u00E7\u00E3o");
		lblRefeicao.setBounds(21, 109, 243, 31);
		frame.getContentPane().add(lblRefeicao);

		lblAlimento = new JLabel("Alimento");
		lblAlimento.setBounds(21, 193, 243, 31);
		frame.getContentPane().add(lblAlimento);

		cmbAlimento = new JComboBox();
		cmbAlimento.setBounds(21, 222, 243, 31);
		cmbAlimento.setModel(ctrlAlimentoComboModel);
		frame.getContentPane().add(cmbAlimento);

		lblQtde = new JLabel("Quantidade");
		lblQtde.setBounds(21, 264, 243, 31);
		frame.getContentPane().add(lblQtde);

		txtQtde = new JSpinner();
		txtQtde.setBounds(21, 290, 243, 31);
		frame.getContentPane().add(txtQtde);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(21, 332, 243, 55);
		btnAdicionar.addActionListener(this);
		frame.getContentPane().add(btnAdicionar);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(21, 399, 243, 55);
		btnFinalizar.addActionListener(this);
		frame.getContentPane().add(btnFinalizar);

		btnLimparTudo = new JButton("Limpar Tudo");
		btnLimparTudo.setBounds(551, 409, 126, 45);
		btnLimparTudo.addActionListener(this);
		frame.getContentPane().add(btnLimparTudo);

		btnRemover = new JButton("Remover");
		btnRemover.setBounds(687, 409, 120, 45);
		btnRemover.addActionListener(this);
		frame.getContentPane().add(btnRemover);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();
		if ("Adicionar".equals(c)) {
			Alimento a = (Alimento) cmbAlimento.getSelectedItem();
			a.setQuantidade(Integer.parseInt(txtQtde.getValue().toString()));
			ctrlAlimentoTableModel.adicionaLista(a);
		}
		if ("Finalizar".equals(c)) {
			RefeicaoController ctrlRefeicao = new RefeicaoController();

			Refeicao refeicao = new Refeicao();
			refeicao.setData(new Date());
			refeicao.setListAlimentos(ctrlAlimentoTableModel.getAlimentos());
			refeicao.setTipoRefeicao((TipoRefeicao) cmbRefeicao.getSelectedItem());

			Usuario u = new Usuario();
			u.setId(8);

			refeicao.setUsuario(u);

			ctrlRefeicao.adicionar(refeicao);

		}
		if ("Limpar Tudo".equals(c)) {
			if (0 == JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Limpar tudo?", "Confirmar",
					JOptionPane.CANCEL_OPTION)) {
				cmbRefeicao.setSelectedIndex(0);
				cmbAlimento.setSelectedIndex(0);
				ctrlAlimentoTableModel.limparLista();
			}
		}
		if ("Remover".equals(c)) {
			if (0 == JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover?", "Confirmar",
					JOptionPane.CANCEL_OPTION)) {
				int index = table.getSelectionModel().getMinSelectionIndex();

				ctrlAlimentoTableModel.removeLista(index);

				cmbAlimento.setSelectedIndex(0);
			}
		}

		tableRevalidate();
	}

	private void tableRevalidate() {
		table.revalidate();
		table.repaint();
	}
}
