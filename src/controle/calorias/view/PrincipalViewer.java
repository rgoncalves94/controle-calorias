package controle.calorias.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import resource.events.MouseEvents;

public class PrincipalViewer implements ActionListener{
	private JFrame frame;
	private JPanel contentPane;
	private JPanel pnlCabecalho;
	private JPanel pnlGeral;
	private JPanel pnlCalendario;
	private JPanel pnlRefeicao;
	private JPanel pnlBotoes;
	private JPanel pnlExercicio;
	private JPanel pnlRodape;

	private JLabel lblData;
	private JLabel lblTotalConsumo;
	private JLabel lblTotalGasto;

	private JButton btnAcessoAdministrativo;
	private JButton diaAnterior;
	private JButton diaPosterior;
	private JButton btnAtualizarConsumo;
	private JButton btnAtualizarGasto;
	private JButton btnGerarRelatorio;

	private String data;
	private LocalDate hoje = LocalDate.now();
	private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private String totalConsumo = "+ 2000.0 kcal";
	private String totalGasto = "- 0.0 kcal";

	public PrincipalViewer() {
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.add(getPnlCabecalho());
		contentPane.add(getPnlGeral());
		contentPane.add(getPnlCalendario());
		contentPane.add(getPnlRefeicao());
		contentPane.add(getPnlBotoes());
		contentPane.add(getPnlExercicio());
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
		
		btnAcessoAdministrativo = new JButton(" Acesso Administrativo");
		btnAcessoAdministrativo.setActionCommand("AcessoAdm");
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

	private JPanel getPnlGeral() {
		pnlGeral = new JPanel();
		pnlGeral.setBounds(0, 30, 1024, 302);
//		pnlGeral.setBackground(Color.BLUE);
		pnlGeral.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		
		return pnlGeral;
	}

	private JPanel getPnlCalendario() {
		pnlCalendario = new JPanel();
		pnlCalendario.setLayout(null);
		pnlCalendario.setBounds(0, 332, 1024, 40);
		pnlCalendario.setBackground(Color.decode("#5F9EA0"));

		JLabel lblAlimentosConsumidos = new JLabel("Alimentos Consumidos");
		lblAlimentosConsumidos.setBounds(0, 0, 432, 20);
		lblAlimentosConsumidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlimentosConsumidos.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCalendario.add(lblAlimentosConsumidos);
		
		JLabel lblAtividadesRealizadas = new JLabel("Atividades Realizadas");
		lblAtividadesRealizadas.setBounds(592, 0, 432, 20);
		lblAtividadesRealizadas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtividadesRealizadas.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCalendario.add(lblAtividadesRealizadas);
		
		lblTotalConsumo = new JLabel(totalConsumo);
		lblTotalConsumo.setBounds(0, 20, 432, 20);
		lblTotalConsumo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTotalConsumo.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCalendario.add(lblTotalConsumo);

		lblTotalGasto = new JLabel(totalGasto);
		lblTotalGasto.setBounds(592, 20, 432, 20);
		lblTotalGasto.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTotalGasto.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCalendario.add(lblTotalGasto);

		data = hoje.format(formatador);
		lblData = new JLabel(data);
		lblData.setBounds(472, 0, 80, 40);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCalendario.add(lblData);
		
		diaAnterior = new JButton("");
		diaAnterior.setBounds(432, 0, 40, 40);
		diaAnterior.setBackground(null);
		diaAnterior.setCursor(new Cursor(Cursor.HAND_CURSOR));
		diaAnterior.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.LIGHT_GRAY));
		diaAnterior.setIcon(new ImageIcon(PrincipalViewer.class.getResource("/resource/icons/past.png")));
		diaAnterior.setActionCommand("DiaAnterior");
		diaAnterior.addActionListener(this);
		pnlCalendario.add(diaAnterior);
		
		diaPosterior = new JButton("");
		diaPosterior.setBounds(552, 0, 40, 40);
		diaPosterior.setBackground(null);
		diaPosterior.setCursor(new Cursor(Cursor.HAND_CURSOR));
		diaPosterior.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY));
		diaPosterior.setIcon(new ImageIcon(PrincipalViewer.class.getResource("/resource/icons/next.png")));
		diaPosterior.setActionCommand("DiaPosterior");
		diaPosterior.addActionListener(this);
		pnlCalendario.add(diaPosterior);
		
		return pnlCalendario;
	}
	
	private JPanel getPnlRefeicao() {
		pnlRefeicao = new JPanel();
		pnlRefeicao.setBounds(0, 372, 432, 300);
//		pnlRefeicao.setBackground(Color.GREEN);
		pnlRefeicao.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		
		return pnlRefeicao;
	}
	
	private JPanel getPnlBotoes() {
		Color colorOne = Color.DARK_GRAY;
		Color colorTwo = Color.decode("#66CDAA");
		MouseEvents mouseEvents = new MouseEvents(colorOne, colorTwo);
		
		pnlBotoes = new JPanel();
		pnlBotoes.setLayout(null);
		pnlBotoes.setBounds(432, 372, 160, 300);
		pnlBotoes.setBackground(Color.decode("#5F9EA0"));
		pnlBotoes.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.LIGHT_GRAY));
		
		btnAtualizarConsumo = new JButton("<html><center>Atualizar<br>Consumo Cal�rico</center></html>");
		btnAtualizarConsumo.setBounds(1, 0, 158, 60);
		btnAtualizarConsumo.addMouseListener(mouseEvents);
		btnAtualizarConsumo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAtualizarConsumo.setForeground(colorTwo);
		btnAtualizarConsumo.setBackground(colorOne);
		btnAtualizarConsumo.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.LIGHT_GRAY));
		pnlBotoes.add(btnAtualizarConsumo);
		
		btnAtualizarGasto = new JButton("<html><center>Atualizar<br>Gasto Cal�rico</center></html>");
		btnAtualizarGasto.setBounds(1, 59, 158, 60);
		btnAtualizarGasto.addMouseListener(mouseEvents);
		btnAtualizarGasto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAtualizarGasto.setForeground(colorTwo);
		btnAtualizarGasto.setBackground(colorOne);
		btnAtualizarGasto.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.LIGHT_GRAY));
		pnlBotoes.add(btnAtualizarGasto);
		
		btnGerarRelatorio = new JButton("Gerar Relat�rio");
		btnGerarRelatorio.setBounds(1, 118, 158, 60);
		btnGerarRelatorio.addMouseListener(mouseEvents);
		btnGerarRelatorio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGerarRelatorio.setForeground(colorTwo);
		btnGerarRelatorio.setBackground(colorOne);
		btnGerarRelatorio.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.LIGHT_GRAY));
		pnlBotoes.add(btnGerarRelatorio);
		
		return pnlBotoes;
	}
	
	private JPanel getPnlExercicio() {
		pnlExercicio = new JPanel();
		pnlExercicio.setBounds(592, 372, 432, 300);
//		pnlExercicio.setBackground(Color.ORANGE);
		pnlExercicio.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		
		return pnlExercicio;
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
	
	public LocalDate getDataDoLblData(){
		String[] v = lblData.getText().split("/");
		int dia = Integer.parseInt(v[0]);
		int mes = Integer.parseInt(v[1]);
		int ano = Integer.parseInt(v[2]);
		
		LocalDate d = LocalDate.of(ano, mes, dia);
		return d;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals("AcessoAdm")) {
			new AdministrativoViewer();
			this.frame.dispose();
		} else if (cmd.equals("DiaAnterior")) {
			LocalDate d = getDataDoLblData();
			d = d.minusDays(1);
			data = d.format(formatador);
			lblData.setText(data);
		} else if (cmd.equals("DiaPosterior")) {
			LocalDate d = getDataDoLblData();
			d = d.plusDays(1);
			data = d.format(formatador);
			if (hoje.isAfter(d) || hoje.equals(d)) {
				lblData.setText(data);					
			}
		}
	}

	public static void main(String[] args) {
		new PrincipalViewer();
	}
}