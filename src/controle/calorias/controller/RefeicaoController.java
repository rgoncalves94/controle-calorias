package controle.calorias.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import controle.calorias.model.Refeicao;
import controle.calorias.persistence.RefeicaoDAO;

public class RefeicaoController implements TableModel {

	private List<Refeicao> refeicoes = new ArrayList<Refeicao>();

	public RefeicaoController() {
		RefeicaoDAO dao = new RefeicaoDAO();
	}

	public List<Refeicao> getRefeicoes() {
		return refeicoes;
	}

	public void setRefeicoes(List<Refeicao> refeicoes) {
		this.refeicoes = refeicoes;
	}

	/**
	 * CRUD
	 * 
	 */

	public long adicionar(Refeicao local) {
		return 1;
	}

	public String atualizar(Refeicao local) {
		return null;
	}

	public String deletar(Refeicao local) {
		return null;
	}

	public Refeicao selecionarPorId(Refeicao local) {

		return null;
	}

	public List<Refeicao> selecionarPorNome(Refeicao local) {
		return null;
	}

	public List<Refeicao> selecionarTodos() {
		return null;
	}

	/**
	 * M�todos Table Model
	 * 
	 */

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}
}