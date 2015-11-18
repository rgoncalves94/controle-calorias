package controle.calorias.view;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DateFormatter;

import controle.calorias.control.GastoCaloricoController;

public class RegistroAtividadeFisicaViewer {
	
	private JFrame frame;
	private JPanel contentPane;
	private JScrollPane pnlTabela;
	private GastoCaloricoController ctrlGastoCalorico;
	private JTable tabela;

	public RegistroAtividadeFisicaViewer() {
		ctrlGastoCalorico = new GastoCaloricoController();
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
	
	public JScrollPane getPnlTabela(){
		tabela = new JTable(ctrlGastoCalorico);
		tabela.setBackground(Color.WHITE);
		tabela.getTableHeader().setBackground(Color.decode("#5F9EA0"));
		tabela.getTableHeader().setForeground(Color.WHITE);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(580);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.LEFT);
		tabela.getColumnModel().getColumn(2).setCellRenderer(dtcr);
		
		pnlTabela = new JScrollPane();
		pnlTabela.setAutoscrolls(true);
		pnlTabela.setBounds(7, 300, 780, 240);
//		pnlTabela.setBorder(BorderFactory.createEmptyBorder());
		pnlTabela.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY));
		pnlTabela.setViewportView(tabela);
		return pnlTabela;
	}
	
	public static void main(String[] args) {
		new RegistroAtividadeFisicaViewer();
	}
}
