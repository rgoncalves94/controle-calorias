package controle.calorias.view;

import javax.swing.JFrame;

import controle.calorias.model.Refeicao;

public class RefeicaoView {

	public RefeicaoView(Refeicao refeicao) {

	}

	public RefeicaoView() {
		this(null);
	}

	public JFrame frameLocal = new JFrame("Manter Refeição - Sistema de Controle de Calorias");
}
