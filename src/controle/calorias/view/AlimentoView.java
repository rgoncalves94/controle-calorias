package controle.calorias.view;

import javax.swing.JFrame;

public class AlimentoView {

	private JFrame janela = new JFrame("Cadastro de Alimentos");

	public static void main(String[] args) {
		new AlimentoView();
	}

	public AlimentoView() {
		janela.setSize(800, 550);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.getContentPane().setLayout(null);

	}

}
