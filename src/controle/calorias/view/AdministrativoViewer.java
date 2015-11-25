package controle.calorias.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import controle.calorias.control.AlimentoController;
import controle.calorias.control.AtividadeFisicaController;
import controle.calorias.control.PorcaoController;
import controle.calorias.model.Alimento;
import controle.calorias.model.AtividadeFisica;
import controle.calorias.model.Porcao;
import resource.events.MouseEvents;

public class AdministrativoViewer implements ActionListener {
	private AtividadeFisicaController ctrlAtividade = new AtividadeFisicaController(this);
	private AlimentoController ctrlAlimento = new AlimentoController(this);

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

	private JScrollPane pnlTabelaAlimento;
	private JTable tabelaAlimento;

	private JTextField txtAlimentoId;
	private JTextField txtAlimentoNome;
	private JTextField txtValorEnergetico;
	private JComboBox cmbPorcao;
	private JTextField txtValorPorcao;
	private JTextField txtProteinas;
	private JTextField txtFibras;
	private JTextField txtCarboidratos;
	private JTextField txtSodio;
	private JTextField txtGordurasTotais;
	private JTextField txtGordurasSaturadas;
	private JTextField txtGordurasTrans;
	private JTextField txtFiltroAlimento;

	private JButton btnSalvarAlimento;
	private JButton btnExcluirAlimento;
	private JButton btnLimparAlimento;

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
		btnAcessoAdministrativo
				.setIcon(new ImageIcon(PrincipalViewer.class.getResource("/resource/icons/config2.png")));
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

		Color colorOne = Color.DARK_GRAY;
		Color colorTwo = Color.decode("#66CDAA");
		MouseEvents mouseEvents = new MouseEvents(colorOne, colorTwo);

		pnlAlimento = new JPanel();
		pnlAlimento.setLayout(null);
		pnlAlimento.setBounds(0, 131, 1024, 540);
		pnlAlimento.setBackground(Color.WHITE);
		pnlAlimento.setVisible(false);
		pnlAlimento.setEnabled(false);

		JLabel lblTitulo = new JLabel("Manutenção de Alimentos");
		lblTitulo.setBounds(10, 5, 400, 20);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		pnlAlimento.add(lblTitulo);

		JSeparator separador = new JSeparator();
		separador.setBorder(BorderFactory.createEmptyBorder());
		separador.setBackground(colorOne);
		separador.setBounds(0, 24, 1024, 1);
		pnlAlimento.add(separador);

		JLabel lblAlimentoId = new JLabel("Id");
		lblAlimentoId.setBounds(107, 60, 30, 18);
		lblAlimentoId.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblAlimentoId);

		txtAlimentoId = new JTextField();
		txtAlimentoId.setBounds(107, 78, 30, 25);
		txtAlimentoId.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtAlimentoId.setEditable(false);
		pnlAlimento.add(txtAlimentoId);

		JLabel lblAlimentoNome = new JLabel("Nome do Alimento");
		lblAlimentoNome.setBounds(107, 108, 200, 18);
		lblAlimentoNome.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblAlimentoNome);

		txtAlimentoNome = new JTextField();
		txtAlimentoNome.setBounds(107, 126, 200, 25);
		txtAlimentoNome.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		pnlAlimento.add(txtAlimentoNome);

		JLabel lblValorEnergetico = new JLabel("Valor Energético");
		lblValorEnergetico.setBounds(107, 156, 150, 18);
		lblValorEnergetico.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblValorEnergetico);

		txtValorEnergetico = new JTextField();
		txtValorEnergetico.setName("txtValorEnergetico");
		txtValorEnergetico.setBounds(107, 174, 70, 25);
		txtValorEnergetico.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtValorEnergetico.addKeyListener(ctrlAlimento);
		pnlAlimento.add(txtValorEnergetico);

		JLabel lblPorcao = new JLabel("Porção");
		lblPorcao.setBounds(350, 60, 150, 18);
		lblPorcao.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblPorcao);

		PorcaoController ctrlPorcao = new PorcaoController();

		cmbPorcao = new JComboBox(ctrlPorcao);
		cmbPorcao.setName("cmbPorcao");
		cmbPorcao.setBounds(350, 78, 150, 25);
		cmbPorcao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		cmbPorcao.addKeyListener(ctrlAlimento);
		pnlAlimento.add(cmbPorcao);

		JLabel lblValorPorcao = new JLabel("Valor Porção");
		lblValorPorcao.setBounds(350, 108, 200, 18);
		lblValorPorcao.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblValorPorcao);

		txtValorPorcao = new JTextField();
		txtValorPorcao.setName("txtValorPorcao");
		txtValorPorcao.setBounds(350, 126, 110, 25);
		txtValorPorcao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtValorPorcao.addKeyListener(ctrlAlimento);
		pnlAlimento.add(txtValorPorcao);

		JLabel lblProteinas = new JLabel("Proteínas");
		lblProteinas.setBounds(350, 156, 200, 18);
		lblProteinas.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblProteinas);

		txtProteinas = new JTextField();
		txtProteinas.setName("txtProteinas");
		txtProteinas.setBounds(350, 174, 110, 25);
		txtProteinas.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtProteinas.addKeyListener(ctrlAlimento);
		pnlAlimento.add(txtProteinas);

		JLabel lblFibras = new JLabel("Fibras");
		lblFibras.setBounds(550, 60, 200, 18);
		lblFibras.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblFibras);

		txtFibras = new JTextField();
		txtFibras.setName("txtFibras");
		txtFibras.setBounds(550, 78, 110, 25);
		txtFibras.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtFibras.addKeyListener(ctrlAlimento);
		pnlAlimento.add(txtFibras);

		JLabel lblCarboidratos = new JLabel("Carboidratos");
		lblCarboidratos.setBounds(550, 108, 200, 18);
		lblCarboidratos.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblCarboidratos);

		txtCarboidratos = new JTextField();
		txtCarboidratos.setName("txtCarboidratos");
		txtCarboidratos.setBounds(550, 126, 110, 25);
		txtCarboidratos.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtCarboidratos.addKeyListener(ctrlAlimento);
		pnlAlimento.add(txtCarboidratos);

		JLabel lblSodio = new JLabel("Sódio");
		lblSodio.setBounds(550, 156, 200, 18);
		lblSodio.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblSodio);

		txtSodio = new JTextField();
		txtSodio.setName("txtSodio");
		txtSodio.setBounds(550, 174, 110, 25);
		txtSodio.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtSodio.addKeyListener(ctrlAlimento);
		pnlAlimento.add(txtSodio);

		JLabel lblGordurasTotais = new JLabel("G. Totais");
		lblGordurasTotais.setBounds(800, 60, 200, 18);
		lblGordurasTotais.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblGordurasTotais);

		txtGordurasTotais = new JTextField();
		txtGordurasTotais.setName("txtGordurasTotais");
		txtGordurasTotais.setBounds(800, 78, 110, 25);
		txtGordurasTotais.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtGordurasTotais.addKeyListener(ctrlAlimento);
		pnlAlimento.add(txtGordurasTotais);

		JLabel lblGordurasSaturadas = new JLabel("G. Saturadas");
		lblGordurasSaturadas.setBounds(800, 108, 200, 18);
		lblGordurasSaturadas.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblGordurasSaturadas);

		txtGordurasSaturadas = new JTextField();
		txtGordurasSaturadas.setName("txtGordurasSaturadas");
		txtGordurasSaturadas.setBounds(800, 126, 110, 25);
		txtGordurasSaturadas.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtGordurasSaturadas.addKeyListener(ctrlAlimento);
		pnlAlimento.add(txtGordurasSaturadas);

		JLabel lblGordurasTrans = new JLabel("G. Trans");
		lblGordurasTrans.setBounds(800, 156, 200, 18);
		lblGordurasTrans.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblGordurasTrans);

		txtGordurasTrans = new JTextField();
		txtGordurasTrans.setName("txtGordurasTrans");
		txtGordurasTrans.setBounds(800, 174, 110, 25);
		txtGordurasTrans.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		txtGordurasTrans.addKeyListener(ctrlAlimento);
		pnlAlimento.add(txtGordurasTrans);

		btnSalvarAlimento = new JButton("     Salvar");
		btnSalvarAlimento.setIcon(new ImageIcon(AdministrativoViewer.class.getResource("/resource/icons/save2.png")));
		btnSalvarAlimento.setActionCommand("SalvarAlimento");
		btnSalvarAlimento.setBounds(107, 215, 268, 40);
		btnSalvarAlimento.setForeground(colorTwo);
		btnSalvarAlimento.setBackground(colorOne);
		btnSalvarAlimento.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSalvarAlimento.setBorder(BorderFactory.createEmptyBorder());
		btnSalvarAlimento.addMouseListener(mouseEvents);
		btnSalvarAlimento.addActionListener(ctrlAlimento);
		pnlAlimento.add(btnSalvarAlimento);

		btnExcluirAlimento = new JButton("     Excluir");
		btnExcluirAlimento.setIcon(new ImageIcon(AdministrativoViewer.class.getResource("/resource/icons/remove.png")));
		btnExcluirAlimento.setActionCommand("ExcluirAlimento");
		btnExcluirAlimento.setBounds(377, 215, 268, 40);
		btnExcluirAlimento.setForeground(colorTwo);
		btnExcluirAlimento.setBackground(colorOne);
		btnExcluirAlimento.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnExcluirAlimento.setBorder(BorderFactory.createEmptyBorder());
		btnExcluirAlimento.addMouseListener(mouseEvents);
		btnExcluirAlimento.addActionListener(ctrlAlimento);
		pnlAlimento.add(btnExcluirAlimento);

		btnLimparAlimento = new JButton("     Limpar Campos");
		btnLimparAlimento.setIcon(new ImageIcon(AdministrativoViewer.class.getResource("/resource/icons/erase.png")));
		btnLimparAlimento.setActionCommand("Limpar Campos Alimento");
		btnLimparAlimento.setBounds(647, 215, 268, 40);
		btnLimparAlimento.setForeground(colorTwo);
		btnLimparAlimento.setBackground(colorOne);
		btnLimparAlimento.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLimparAlimento.setBorder(BorderFactory.createEmptyBorder());
		btnLimparAlimento.addMouseListener(mouseEvents);
		btnLimparAlimento.addActionListener(ctrlAlimento);
		pnlAlimento.add(btnLimparAlimento);

		JLabel lblFiltroAlimento = new JLabel(" Filtrar tabela");
		lblFiltroAlimento.setBounds(0, 276, 100, 24);
		lblFiltroAlimento.setForeground(colorOne);
		lblFiltroAlimento.setBackground(Color.decode("#5F9EA0"));
		lblFiltroAlimento.setOpaque(true);
		lblFiltroAlimento.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlAlimento.add(lblFiltroAlimento);

		txtFiltroAlimento = new JTextField();
		txtFiltroAlimento.setName("txtFiltroAlimento");
		txtFiltroAlimento.setBounds(100, 276, 924, 24);
		txtFiltroAlimento.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#5F9EA0")));
		txtFiltroAlimento.addKeyListener(ctrlAlimento);
		pnlAlimento.add(txtFiltroAlimento);

		pnlAlimento.add(getPnlTabelaAlimento());

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

	public JScrollPane getPnlTabela() {
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

	public JScrollPane getPnlTabelaAlimento() {
		tabelaAlimento = new JTable(ctrlAlimento);
		tabelaAlimento.setBackground(Color.WHITE);
		tabelaAlimento.getTableHeader().setBackground(Color.decode("#5F9EA0"));
		tabelaAlimento.getTableHeader().setForeground(Color.WHITE);
		tabelaAlimento.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabelaAlimento.getColumnModel().getColumn(1).setPreferredWidth(250);
		tabelaAlimento.getColumnModel().getColumn(2).setPreferredWidth(70);
		tabelaAlimento.getColumnModel().getColumn(3).setPreferredWidth(70);
		tabelaAlimento.getColumnModel().getColumn(4).setPreferredWidth(70);
		tabelaAlimento.getColumnModel().getColumn(5).setPreferredWidth(70);
		tabelaAlimento.getColumnModel().getColumn(6).setPreferredWidth(70);
		tabelaAlimento.getColumnModel().getColumn(7).setPreferredWidth(70);
		tabelaAlimento.getColumnModel().getColumn(8).setPreferredWidth(70);
		tabelaAlimento.getColumnModel().getColumn(9).setPreferredWidth(70);
		tabelaAlimento.getColumnModel().getColumn(10).setPreferredWidth(70);
		tabelaAlimento.getColumnModel().getColumn(11).setPreferredWidth(70);

		tabelaAlimento.getColumnModel().getColumn(0).setResizable(false);
		tabelaAlimento.getColumnModel().getColumn(1).setResizable(false);
		tabelaAlimento.getColumnModel().getColumn(2).setResizable(false);
		tabelaAlimento.getColumnModel().getColumn(3).setResizable(false);
		tabelaAlimento.getColumnModel().getColumn(4).setResizable(false);
		tabelaAlimento.getColumnModel().getColumn(5).setResizable(false);
		tabelaAlimento.getColumnModel().getColumn(6).setResizable(false);
		tabelaAlimento.getColumnModel().getColumn(7).setResizable(false);
		tabelaAlimento.getColumnModel().getColumn(8).setResizable(false);
		tabelaAlimento.getColumnModel().getColumn(9).setResizable(false);
		tabelaAlimento.getColumnModel().getColumn(10).setResizable(false);
		tabelaAlimento.getColumnModel().getColumn(11).setResizable(false);

		tabelaAlimento.getSelectionModel().addListSelectionListener(ctrlAlimento);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.LEFT);
		tabelaAlimento.getColumnModel().getColumn(2).setCellRenderer(dtcr);

		pnlTabelaAlimento = new JScrollPane();
		pnlTabelaAlimento.setAutoscrolls(true);
		pnlTabelaAlimento.setBounds(0, 300, 1024, 240);
		pnlTabelaAlimento.setBorder(BorderFactory.createEmptyBorder());
		pnlTabelaAlimento.setViewportView(tabelaAlimento);
		return pnlTabelaAlimento;
	}

	public JTable getTabela() {
		return this.tabela;
	}

	public JTable getTabelaAlimento() {
		return this.tabelaAlimento;
	}

	public void limparCampos() {
		txtId.setText("");
		txtNome.setText("");
		txtGastoCalorico.setText("");
	}

	public void limparCamposAlimento() {
		txtAlimentoId.setText("");
		txtAlimentoNome.setText("");
		txtValorEnergetico.setText("");
		cmbPorcao.setSelectedIndex(0);
		txtValorPorcao.setText("");
		txtProteinas.setText("");
		txtFibras.setText("");
		txtCarboidratos.setText("");
		txtSodio.setText("");
		txtGordurasTotais.setText("");
		txtGordurasSaturadas.setText("");
		txtGordurasTrans.setText("");
	}

	public boolean validarPreenchimento() {
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

	public boolean validarPreenchimentoAlimento() {
		boolean resultado = true;

		if (txtAlimentoNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Nome do Alimento!");
			resultado = false;
		} else if (txtValorEnergetico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Valor Energético!");
			resultado = false;
		} else if (txtValorPorcao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Valor Energético!");
			resultado = false;
		} else if (txtProteinas.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Proteinas!");
			resultado = false;
		} else if (txtFibras.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Fibras!");
			resultado = false;
		} else if (txtCarboidratos.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Carboidratos!");
			resultado = false;
		} else if (txtSodio.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Sódio!");
			resultado = false;
		} else if (txtGordurasTotais.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Gordutas Totais!");
			resultado = false;
		} else if (txtGordurasSaturadas.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Gorduras Saturadas!");
			resultado = false;
		} else if (txtGordurasTrans.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor Preencher Campo Gorduras Trans!");
			resultado = false;
		}

		return resultado;
	}

	public AtividadeFisica viewToControl() {
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

	public Alimento viewAlimentoToControl() {
		Alimento alimento = new Alimento();

		if (txtAlimentoId.getText().isEmpty()) {
			alimento.setId(0);
		} else {
			alimento.setId(Long.parseLong(txtAlimentoId.getText()));
		}
		alimento.setNome(txtAlimentoNome.getText());
		alimento.setValorEnergetico(Double.parseDouble(txtValorEnergetico.getText().replace(',', '.')));
		alimento.setPorcao((Porcao) cmbPorcao.getSelectedItem());
		alimento.setValorPorcao(Double.parseDouble(txtValorPorcao.getText().replace(',', '.')));
		alimento.setProteinas(Double.parseDouble(txtProteinas.getText().replace(',', '.')));
		alimento.setFibras(Double.parseDouble(txtFibras.getText().replace(',', '.')));
		alimento.setCarboidrato(Double.parseDouble(txtCarboidratos.getText().replace(',', '.')));
		alimento.setSodio(Double.parseDouble(txtSodio.getText().replace(',', '.')));
		alimento.setGordurasTotais(Double.parseDouble(txtGordurasTotais.getText().replace(',', '.')));
		alimento.setGordurasSaturadas(Double.parseDouble(txtGordurasSaturadas.getText().replace(',', '.')));
		alimento.setGordurasTrans(Double.parseDouble(txtGordurasTrans.getText().replace(',', '.')));

		return alimento;
	}

	public void controlToView(AtividadeFisica atividade) {
		txtId.setText(String.valueOf(atividade.getId()));
		txtNome.setText(atividade.getNome());
		txtGastoCalorico.setText(String.format("%.2f", atividade.getGastoCalorico()));
	}

	public void controlToAlimentoView(Alimento alimento) {
		txtAlimentoId.setText(String.valueOf(alimento.getId()));
		txtAlimentoNome.setText(alimento.getNome());

		cmbPorcao.setSelectedItem(alimento.getPorcao());

		txtValorEnergetico.setText(String.format("%.2f", alimento.getValorEnergetico()));
		txtValorPorcao.setText(String.format("%.2f", alimento.getValorPorcao()));
		txtProteinas.setText(String.format("%.2f", alimento.getProteinas()));
		txtFibras.setText(String.format("%.2f", alimento.getFibras()));
		txtCarboidratos.setText(String.format("%.2f", alimento.getCarboidrato()));
		txtSodio.setText(String.format("%.2f", alimento.getSodio()));
		txtGordurasTotais.setText(String.format("%.2f", alimento.getGordurasTotais()));
		txtGordurasSaturadas.setText(String.format("%.2f", alimento.getGordurasSaturadas()));
		txtGordurasTrans.setText(String.format("%.2f", alimento.getGordurasTrans()));
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
		} else if (cmd.equals("Voltar")) {
			new PrincipalViewer();
			this.frame.dispose();
		}
	}

	public static void main(String[] args) {
		new AdministrativoViewer();
	}
}