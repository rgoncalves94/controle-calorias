package controle.calorias.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import controle.calorias.control.AlimentoController;

public class AlimentoViewer {

	private JFrame frame;
	private JPanel contentPane;
	private JScrollPane pnlTabela;
	private AlimentoController ctrlAlimento;
	private JTable tabela;

	public AlimentoViewer() {
		ctrlAlimento = new AlimentoController();
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.add(getPnlTabela());

		frame = new JFrame("SLIMSOFT");
		frame.setBounds(0, 0, 800, 600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(contentPane);
	}

	public JScrollPane getPnlTabela() {
		tabela = new JTable(ctrlAlimento);
		tabela.setBackground(Color.WHITE);
		tabela.getTableHeader().setBackground(Color.decode("#5F9EA0"));
		tabela.getTableHeader().setForeground(Color.WHITE);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(250);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(9).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(10).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(11).setPreferredWidth(70);

		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(4).setResizable(false);
		tabela.getColumnModel().getColumn(5).setResizable(false);
		tabela.getColumnModel().getColumn(6).setResizable(false);
		tabela.getColumnModel().getColumn(7).setResizable(false);
		tabela.getColumnModel().getColumn(8).setResizable(false);
		tabela.getColumnModel().getColumn(9).setResizable(false);
		tabela.getColumnModel().getColumn(10).setResizable(false);
		tabela.getColumnModel().getColumn(11).setResizable(false);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.LEFT);
		tabela.getColumnModel().getColumn(2).setCellRenderer(dtcr);

		pnlTabela = new JScrollPane();
		pnlTabela.setAutoscrolls(true);
		pnlTabela.setBounds(7, 300, 780, 240);
		pnlTabela.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY));
		pnlTabela.setViewportView(tabela);
		return pnlTabela;
	}

	public static void main(String[] args) {
		new AlimentoViewer();
	}
}
