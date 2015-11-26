package controle.calorias.control;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import controle.calorias.model.Alimento;
import controle.calorias.model.TipoRefeicao;
import resource.dao.TipoRefeicaoDAO;
import resource.dao.TipoRefeicaoDAOException;
import resource.dao.TipoRefeicaoDAOImpl;

public class TipoRefeicaoComboModel implements ComboBoxModel {

	private List<TipoRefeicao> listaTipoRefeicao;
	private TipoRefeicao current;

	public TipoRefeicaoComboModel() {
		try {
			TipoRefeicaoDAO dao = new TipoRefeicaoDAOImpl();
			listaTipoRefeicao = dao.selecionaTodos();
		} catch (TipoRefeicaoDAOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getElementAt(int index) {
		return this.listaTipoRefeicao.get(index);
	}

	@Override
	public Object getSelectedItem() {
		return current;
	}

	@Override
	public int getSize() {
		return listaTipoRefeicao.size();
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectedItem(Object anItem) {
		current = (TipoRefeicao) anItem;
	}

}
