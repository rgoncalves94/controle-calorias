package controle.calorias.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import controle.calorias.control.AtividadeFisicaController;
import controle.calorias.model.AtividadeFisica;
import resource.events.MouseEvents;

public class AdministrativoViewer implements ActionListener{
	private AtividadeFisicaController ctrlAtividade = new AtividadeFisicaController(this);

	private JFrame frame;
	private JPanel contentPane;
	private JPanel pnlCabecalho;
	private JPanel pnlMenu;
	private JPanel pnlAlimento;
	private JPanel pnlAtividade;
	private JPanel pnlRodape;
	
	private JScrollPane pnlTabela;
	private JTable tabela;

	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtGastoCalorico;
	private JTextField txtFiltro;

	private JButton btnAcessoAdministrativo;
	private JButton btnAlimento;
	private JButton btnAtividade;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnLimpar;

	public AdministrativoViewer() {
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.add(getPnlCabecalho());
		contentPane.add(getPnlMenu());
		contentPane.add(getPnlAlimento());
		contentPane.add(getPnlAtividade());
		contentPane.add(getPnlRodape());

		frame = new JFrame("SLIMSOFT");
		frame.setBounds(0, 0, 1030, 728);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setContentPane(contentPane);
	}
	
	private JPanel getPnlCabecalho() {
		pnlCabecalho = new JPanel();
		pnlCabecalho.setLayout(null);	
		pnlCabecalho.setBounds(0, 0, 1024, 30);
		pnlCabecalho.setBackground(Color.DARK_GRAY);
		
		btnAcessoAdministrativo = new JButton(" Voltar Principal");
		btnAcessoAdministrativo.setActionCommand("Voltar");
		btnAcessoAdministrativo.addActionListener(this);
		btnAcessoAdministrativo.setBounds(844, 5, 180, 20);
		btnAcessoAdministrativo.setForeground(Color.WHITE);
		btnAcessoAdministrativo.setBackground(Color.DARK_GRAY);
		btnAcessoAdministrativo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAcessoAdministrativo.setBorder(BorderFactory.createEmptyBorder());
		btnAcessoAdministrativo.setIcon(new ImageIcon(PrincipalViewer.class.getResource("/resource/icons/config2.png")));
		pnlCabecalho.add(btnAcessoAdministrativo);
		
		return pnlCabecalho;
	}

	private JPanel getPnlMenu() {
		Color colorOne = Color.DARK_GRAY;
		Color colorTwo = Color.decode("#66CDAA");
		MouseEvents mouseEvents = new MouseEvents(colorOne, colorTwo);
		
		pnlMenu = new JPanel();
		pnlMenu.setLayout(null);
		pnlMenu.setBounds(0, 30, 1024, 100);
		pnlMenu.setBackground(Color.decode("#5F9EA0"));
		
		btnAlimento = new JButton("     Controle de Alimentos");
		btnAlimento.setIcon(new ImageIcon(AdministrativoViewer.class.getResource("/resource/icons/alimento.png")));
		btnAlimento.setActionCommand("Controle de Alimentos");
		btnAlimento.setBounds(390, 20, 300, 60);
		btnAlimento.setForeground(colorTwo);
		btnAlimento.setBackground(colorOne);
		btnAlimento.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAlimento.setBorder(BorderFactory.createEmptyBorder());
		btnAlimento.addMouseListener(mouseEvents);
		btnAlimento.addActionListener(this);
		pnlMenu.add(btnAlimento);
		
		btnAtividade = new JButton("     Controle de Atividades Físicas");
		btnAtividade.setIcon(new ImageIcon(AdministrativoViewer.class.getResource("/resource/icons/atividade.png")));
		btnAtividade.setActionCommand("Controle de Atividades Físicas");
		btnAtividade.setBounds(700, 20, 300, 60);
		btnAtividade.setForeground(colorTwo);
		btnAtividade.setBackground(colorOne);
		btnAtividade.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAtividade.setBorder(BorderFactory.createEmptyBorder());
		btnAtividade.addMouseListener(mouseEvents);
		btnAtividade.addActionListener(this);
		pnlMenu.add(btnAtividade);
		
		return pnlMenu;	
	}

	private JPanel getPnlAlimento() {
		pnlAlimento = new JPanel();
		
		return pnlAlimento;		
	}

	private JPanel getPnlAtividade() {
		Color colorOne = Color.DARK_GRAY;
		Color colorTwo = Color.decode("#66CDAA");		
		MouseEvents mouseEvents = new MouseEvents(colorOne, colorTwo); 
		
		pnlAtividade = new JPanel();
		pnlAtividade.setLayout(null);
		pnlAtividade.setBounds(0, 131, 1024, 540);
		pnlAtividade.setBackground(Color.WHITE);
		pnlAtividade.setVisible(false);
		pnlAtividade.setEnabled(false);
		
		JLabel lblTitulo = new JLabel("Controle de Atividades Físicas");
		lblTitulo.setBounds(10, 5, 400, 20);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		pnlAtividade.add(lblTitulo);
		
		JSeparator separador = new JSeparator();
		separador.setBorder(BorderFactory.createEmptyBorder());
		separador.setBackground(colorOne);
		separador.setBounds(0, 24, 1024, 1);
		pnlAtividade.add(separador);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(107, 60, 100, 18);
		lblId.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAtividade.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(107, 78, 110, 25);
		txtId.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtId.setEditable(false);
		pnlAtividade.add(txtId);
		
		JLabel lblNome = new JLabel("Atividade Física");
		lblNome.setBounds(107, 108, 200, 18);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAtividade.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(107, 126, 540, 25);
		txtNome.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		pnlAtividade.add(txtNome);
		
		JLabel lblGastoCalorico = new JLabel("Gasto Calórico");
		lblGastoCalorico.setBounds(107, 156, 200, 18);
		lblGastoCalorico.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAtividade.add(lblGastoCalorico);
		
		txtGastoCalorico = new JTextField();
		txtGastoCalorico.setName("txtGastoCalorico");
		txtGastoCalorico.setBounds(107, 174, 110, 25);
		txtGastoCalorico.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtGastoCalorico.addKeyListener(ctrlAtividade);
		pnlAtividade.add(txtGastoCalorico);
		
		btnSalvar = new JButton("     Salvar");
		btnSalvar.setIcon(new ImageIcon(AdministrativoViewer.class.getResource("/resource/icons/save2.png")));
		btnSalvar.setActionCommand("Salvar");
		btnSalvar.setBounds(107, 215, 268, 40);
		btnSalvar.setForeground(colorTwo);
		btnSalvar.setBackground(colorOne);
		btnSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSalvar.setBorder(BorderFactory.createEmptyBorder());
		btnSalvar.addMouseListener(mouseEvents);
		btnSalvar.addActionListener(ctrlAtividade);
		pnlAtividade.add(btnSalvar);

		btnExcluir = new JButton("     Excluir");
		btnExcluir.setIcon(new ImageIcon(AdministrativoViewer.class.getResource("/resource/icons/remove.png")));
		btnExcluir.setActionCommand("Excluir");
		btnExcluir.setBounds(377, 215, 268, 40);
		btnExcluir.setForeground(colorTwo);
		btnExcluir.setBackground(colorOne);
		btnExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnExcluir.setBorder(BorderFactory.createEmptyBorder());
		btnExcluir.addMouseListener(mouseEvents);
		btnExcluir.addActionListener(ctrlAtividade);
		pnlAtividade.add(btnExcluir);
		
		btnLimpar = new JButton("     Limpar Campos");
		btnLimpar.setIcon(new ImageIcon(AdministrativoViewer.class.getResource("/resource/icons/erase.png")));
		btnLimpar.setActionCommand("Limpar Campos");
		btnLimpar.setBounds(647, 215, 268, 40);
		btnLimpar.setForeground(colorTwo);
		btnLimpar.setBackground(colorOne);
		btnLimpar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLimpar.setBorder(BorderFactory.createEmptyBorder());
		btnLimpar.addMouseListener(mouseEvents);
		btnLimpar.addActionListener(ctrlAtividade);
		pnlAtividade.add(btnLimpar);
		
		JLabel lblFiltro = new JLabel(" Filtrar tabela");
		lblFiltro.setBounds(0, 276, 100, 24);
		lblFiltro.setForeground(colorOne);
		lblFiltro.setBackground(Color.decode("#5F9EA0"));
		lblFiltro.setOpaque(true);
		lblFiltro.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAtividade.add(lblFiltro);
		
		txtFiltro = new JTextField();
		txtFiltro.setName("txtFiltro");
		txtFiltro.setBounds(100, 276, 924, 24);
		txtFiltro.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#5F9EA0")));
		txtFiltro.addKeyListener(ctrlAtividade);
		pnlAtividade.add(txtFiltro);
		
		pnlAtividade.add(getPnlTabela());
		
		return pnlAtividade;		
	}

	private JPanel getPnlRodape() {
		pnlRodape = new JPanel();
		pnlRodape.setBounds(0, 672, 1024, 28);
		pnlRodape.setBackground(Color.DARK_GRAY);
		
		JLabel lblPowered = new JLabel("powered by R2F Developers");
		lblPowered.setBounds(824, 5, 200, 20);
		lblPowered.setForeground(Color.WHITE);
		lblPowered.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblPowered.setFont(new Font("Dialog", Font.ITALIC, 12));
		pnlRodape.add(lblPowered);
		
		return pnlRodape;
	}
	
	public JScrollPane getPnlTabela(){
		tabela = new JTable(ctrlAtividade);
		tabela.setBackground(Color.WHITE);
		tabela.getTableHeader().setBackground(Color.decode("#5F9EA0"));
		tabela.getTableHeader().setForeground(Color.WHITE);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(600);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(324);
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getSelectionModel().addListSelectionListener(ctrlAtividade);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.LEFT);
		tabela.getColumnModel().getColumn(2).setCellRenderer(dtcr);
		
		pnlTabela = new JScrollPane();
		pnlTabela.setAutoscrolls(true);
		pnlTabela.setBounds(0, 300, 1024, 240);
		pnlTabela.setBorder(BorderFactory.createEmptyBorder());
		pnlTabela.setViewportView(tabela);
		return pnlTabela;
	}
	
	public JTable getTabela(){
		return this.tabela;
	}
	
	public void limparCampos(){
		txtId.setText("");
		txtNome.setText("");
		txtGastoCalorico.setText("");
	}
	
	public boolean validarPreenchimento(){
		boolean resultado = true;
		
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Atividade Física!");
			resultado = false;
		} else if (txtGastoCalorico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Gasto Calórico!");			
			resultado = false;
		}
		
		return resultado;
	}
	
	public AtividadeFisica viewToControl(){
		AtividadeFisica atividade = new AtividadeFisica();
		
		if (txtId.getText().isEmpty()) {
			atividade.setId(0);			
		} else {
			atividade.setId(Integer.parseInt(txtId.getText()));
		}
		atividade.setNome(txtNome.getText());
		atividade.setGastoCalorico(Float.parseFloat(txtGastoCalorico.getText().replace(",", ".")));
		
		return atividade;
	}
	
	public void controlToView(AtividadeFisica atividade){
		txtId.setText(String.valueOf(atividade.getId()));
		txtNome.setText(atividade.getNome());
		txtGastoCalorico.setText(String.format("%.2f", atividade.getGastoCalorico()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals("Controle de Alimentos")) {
			this.pnlAlimento.setVisible(true);
			this.pnlAlimento.setEnabled(true);
			this.pnlAtividade.setVisible(false);
			this.pnlAtividade.setEnabled(false);
		} else if (cmd.equals("Controle de Atividades Físicas")) {
			this.pnlAtividade.setVisible(true);
			this.pnlAtividade.setEnabled(true);
			this.pnlAlimento.setVisible(false);
			this.pnlAlimento.setEnabled(false);
			this.txtNome.requestFocus();
		} else if (cmd.equals("Voltar")){
			new PrincipalViewer();
			this.frame.dispose();
		}
	}
	
	public static void main(String[] args) {
		new AdministrativoViewer();
	}
}