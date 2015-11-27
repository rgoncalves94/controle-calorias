package controle.calorias.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import controle.calorias.control.RegistroAtividadeFisicaController;
import controle.calorias.model.AtividadeFisica;
import controle.calorias.model.RegistroAtividadeFisica;
import controle.calorias.model.Usuario;
import resource.dao.AtividadeFisicaDao;
import resource.events.MouseEvents;

public class RegistroAtividadeFisicaViewer implements ItemListener{
	private RegistroAtividadeFisicaController ctrlRegistroAtividadeFisica;
	
	private JFrame frame;
	private JPanel contentPane;
	private JScrollPane pnlTabela;
	private JTable tabela;
	private JPanel PnlFormulario;
	private JButton btnIncluir;
	private JButton btnRemover;
	private JButton btnLimpar;
	private JComboBox<AtividadeFisica> cmbAtividades;
	private JTextField txtGastoCalorico;
//	private JTextField txtDuracao;
	private JSpinner spnDuracao;
	private Usuario usuario;
	private List<AtividadeFisica> itensCombobox;

	public RegistroAtividadeFisicaViewer(Usuario usuario) {
		ctrlRegistroAtividadeFisica = new RegistroAtividadeFisicaController(this, usuario, new Date(System.currentTimeMillis()));
		this.usuario = usuario;
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.add(getPnlFormulario());
		contentPane.add(getPnlTabela());
		
		frame = new JFrame("SLIMSOFT");
		frame.setBounds(0, 0, 800, 600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(contentPane);
	}
	
	private JPanel getPnlFormulario() {
		Color colorOne = Color.DARK_GRAY;
		Color colorTwo = Color.decode("#66CDAA");		
		MouseEvents mouseEvents = new MouseEvents(colorOne, colorTwo); 
		
		PnlFormulario = new JPanel();
		PnlFormulario.setLayout(null);
		PnlFormulario.setBounds(0, 0, 794, 300);
		PnlFormulario.setBackground(Color.WHITE);
		
		JLabel lblTitulo = new JLabel("Registros de Atividades Físicas");
		lblTitulo.setBounds(10, 5, 400, 20);
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
		PnlFormulario.add(lblTitulo);
		
		JSeparator separador = new JSeparator();
		separador.setBorder(BorderFactory.createEmptyBorder());
		separador.setBackground(colorOne);
		separador.setBounds(0, 28, 794, 1);
		PnlFormulario.add(separador);
		
		JLabel lblComboAtividades = new JLabel("<html><b>Selecione uma Atividade Fisica</b></html>");
		lblComboAtividades.setBounds(7, 45, 300, 18);
		PnlFormulario.add(lblComboAtividades);
		
		cmbAtividades = new JComboBox<AtividadeFisica>();
		cmbAtividades.setBounds(7, 63, 500, 25);
		cmbAtividades.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		cmbAtividades.addItemListener(this);
		PnlFormulario.add(cmbAtividades);
		
		JLabel lblGastoCalorico = new JLabel("<html><b>Gasto Calórico</b> <i>(kcal)</i></html>");
		lblGastoCalorico.setBounds(527, 45, 150, 18);
		PnlFormulario.add(lblGastoCalorico);
		
		txtGastoCalorico = new JTextField();
		txtGastoCalorico.setBounds(527, 63, 150, 25);
		txtGastoCalorico.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtGastoCalorico.setEditable(false);
		PnlFormulario.add(txtGastoCalorico);
		
		JLabel lblDuracao = new JLabel("<html><b>Duração</b> <i>(horas)</i></html>");
		lblDuracao.setBounds(7, 100, 150, 18);
		PnlFormulario.add(lblDuracao);
		
//		txtDuracao = new JTextField();
//		txtDuracao.setBounds(7, 118, 150, 25);
//		txtDuracao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
//		PnlFormulario.add(txtDuracao);
		
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 0.5, 24, 0.5);
		
		spnDuracao = new JSpinner(spinnerModel);
		spnDuracao.setBounds(7, 118, 150, 25);
		spnDuracao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		PnlFormulario.add(spnDuracao);

		btnIncluir = new JButton("     Incluir");
		btnIncluir.setIcon(new ImageIcon(AdministrativoViewer.class.getResource("/resource/icons/incluir.png")));
		btnIncluir.setActionCommand("Salvar");
		btnIncluir.setBounds(7, 250, 258, 40);
		btnIncluir.setForeground(colorTwo);
		btnIncluir.setBackground(colorOne);
		btnIncluir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnIncluir.setBorder(BorderFactory.createEmptyBorder());
		btnIncluir.addMouseListener(mouseEvents);
		btnIncluir.addActionListener(ctrlRegistroAtividadeFisica);
		PnlFormulario.add(btnIncluir);

		btnRemover = new JButton("     Remover");
		btnRemover.setIcon(new ImageIcon(AdministrativoViewer.class.getResource("/resource/icons/remover.png")));
		btnRemover.setActionCommand("Remover");
		btnRemover.setBounds(268, 250, 258, 40);
		btnRemover.setForeground(colorTwo);
		btnRemover.setBackground(colorOne);
		btnRemover.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRemover.setBorder(BorderFactory.createEmptyBorder());
		btnRemover.addMouseListener(mouseEvents);
		btnRemover.addActionListener(ctrlRegistroAtividadeFisica);
		PnlFormulario.add(btnRemover);
		
		btnLimpar = new JButton("     Limpar Campos");
		btnLimpar.setIcon(new ImageIcon(AdministrativoViewer.class.getResource("/resource/icons/limpar.png")));
		btnLimpar.setActionCommand("Limpar Campos");
		btnLimpar.setBounds(529, 250, 258, 40);
		btnLimpar.setForeground(colorTwo);
		btnLimpar.setBackground(colorOne);
		btnLimpar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLimpar.setBorder(BorderFactory.createEmptyBorder());
		btnLimpar.addMouseListener(mouseEvents);
		btnLimpar.addActionListener(ctrlRegistroAtividadeFisica);
		PnlFormulario.add(btnLimpar);

		carregarComboBox();
		return PnlFormulario;		
	}
	
	public JScrollPane getPnlTabela(){
		tabela = new JTable(ctrlRegistroAtividadeFisica);
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
		pnlTabela.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY));
		pnlTabela.setViewportView(tabela);
		return pnlTabela;
	}
	
	public JTable getTabela() {
		return tabela;
	}
	
	public RegistroAtividadeFisica viewToControl(){
		RegistroAtividadeFisica registroAtividadeFisica = new RegistroAtividadeFisica();
		int duracao = (int) (Double.parseDouble(spnDuracao.getValue().toString()) * 60);
		
		AtividadeFisica atividade = itensCombobox.get(cmbAtividades.getSelectedIndex());
		
		registroAtividadeFisica.setUsuario(usuario);
		registroAtividadeFisica.setAtividade(atividade);
		registroAtividadeFisica.setData(new Date(System.currentTimeMillis()));
		registroAtividadeFisica.setDuracao(duracao);
		return registroAtividadeFisica;
	}
	
	public void carregarComboBox(){
		AtividadeFisicaDao dao = new AtividadeFisicaDao();
		itensCombobox = dao.selectAll();
		for (AtividadeFisica atividadeFisica : itensCombobox) {
			cmbAtividades.addItem(atividadeFisica);			
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		AtividadeFisica a = (AtividadeFisica) e.getItem();
		txtGastoCalorico.setText(String.format("%.2f", a.getGastoCalorico()));
	}
}
