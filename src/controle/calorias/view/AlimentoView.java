package controle.calorias.view;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class AlimentoView {

	private JFrame janela = new JFrame("Cadastro de Alimentos");
	private JTextField textField;

	public static void main(String[] args) {
		new AlimentoView();
	}

	public AlimentoView() {
		janela.setSize(800, 550);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(168, 90, 235, 31);
		janela.getContentPane().add(textField);
		textField.setColumns(10);

	}
}
