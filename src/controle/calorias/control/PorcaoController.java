package controle.calorias.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import controle.calorias.model.Porcao;
import resource.dao.PorcaoDAO;
import resource.dao.PorcaoDAOImpl;

public class PorcaoController implements ComboBoxModel<Porcao> {

	private List<Porcao> listaPorcao;
	private Porcao porcaoSelecionada;

	public PorcaoController() {
		listaPorcao = this.selecionaTodos();

		porcaoSelecionada = listaPorcao.get(0);
	}

	public List<Porcao> selecionaTodos() {
		PorcaoDAO dao = new PorcaoDAOImpl();
		return dao.selectAll();
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
	}

	@Override
	public Porcao getElementAt(int index) {
		return this.listaPorcao.get(index);
	}

	@Override
	public int getSize() {
		return listaPorcao.size();
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
	}

	@Override
	public Porcao getSelectedItem() {
		return porcaoSelecionada;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		porcaoSelecionada = (Porcao) anItem;
	}
	
	
	

}
