package controle.calorias.control;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import controle.calorias.model.Alimento;
import controle.calorias.model.Porcao;
import resource.dao.AlimentoDAO;
import resource.dao.AlimentoDAOImpl;
import resource.dao.PorcaoDAO;
import resource.dao.PorcaoDAOImpl;

public class AlimentoComboModel implements ComboBoxModel {

	private AlimentoController ctrl = new AlimentoController();
	private List<Alimento> listaAlimentos;
	private Alimento current;

	public AlimentoComboModel() {
		listaAlimentos = ctrl.selecionaTodos();
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getElementAt(int index) {
		return this.listaAlimentos.get(index);
	}

	@Override
	public Object getSelectedItem() {
		return current;
	}

	@Override
	public int getSize() {
		return listaAlimentos.size();
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectedItem(Object anItem) {
		current = (Alimento) anItem;

	}

}
