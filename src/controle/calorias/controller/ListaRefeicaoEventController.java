package controle.calorias.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import controle.calorias.model.Refeicao;
import controle.calorias.view.ListaRefeicaoView;
import controle.calorias.view.RefeicaoView;

public class ListaRefeicaoEventController implements ActionListener, MouseListener {

	private ListaRefeicaoView view;

	public ListaRefeicaoEventController(ListaRefeicaoView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String acao = evento.getActionCommand();
		if ("Pesquisar Local".equals(acao)) {
			this.pesquisarAction();
		} else if ("Novo Local".equals(acao)) {
			this.novoLocalAction();
		}

	}

	private void pesquisarAction() {
		if (view.txtNomeLocal.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do local e clique em Pesquisar");
			view.txtNomeLocal.setBackground(Color.YELLOW);
			return;
		}

		Refeicao local = new Refeicao();

		// local.setData((txtNomeLocal.getText());

		controllerLocal.setRefeicoes(controllerLocal.selecionarPorNome(local));
		tableLocais.revalidate();
		tableLocais.repaint();
	}

	private void novoLocalAction() {
		if (this.formLocal != null)
			this.formLocal.frameLocal.setVisible(false);
		this.formLocal = new RefeicaoView();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if ((System.currentTimeMillis() - this.timeToDoubleClick) < 250) {

			if (this.formLocal != null)
				this.formLocal.frameLocal.setVisible(false);

			int numRow = tableLocais.rowAtPoint(e.getPoint());

			long id = Long.parseLong(String.valueOf(tableLocais.getValueAt(numRow, 0)));

			Refeicao local = new controle.calorias.model.Refeicao();

			local.setId(id);

			local = controllerLocal.selecionarPorId(local);

			this.formLocal = new RefeicaoView(local);

		}
		this.timeToDoubleClick = System.currentTimeMillis();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new ListaRefeicaoView();
	}

}
