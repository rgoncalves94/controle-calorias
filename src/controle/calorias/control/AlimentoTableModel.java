package controle.calorias.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import controle.calorias.model.Alimento;
import controle.calorias.model.AtividadeFisica;
import controle.calorias.model.Porcao;
import controle.calorias.view.AdministrativoViewer;
import resource.dao.AlimentoDAO;
import resource.dao.AlimentoDAOException;
import resource.dao.AlimentoDAOImpl;

public class AlimentoTableModel implements TableModel {

	private List<Alimento> listaAlimentos = null;

	public AlimentoTableModel() {
		listaAlimentos = new ArrayList<Alimento>();
	}

	public void adicionaLista(Alimento a) {
		listaAlimentos.add(a);
	}

	public void removeLista(int index) {
		listaAlimentos.remove(index);
	}

	public void limparLista() {
		listaAlimentos.clear();
	}

	public boolean isEmpty() {
		return listaAlimentos.isEmpty();
	}

	public List<Alimento> getAlimentos() {
		return listaAlimentos;
	}

	@Override
	public Object getValueAt(int row, int col) {
		Alimento alimento = this.listaAlimentos.get(row);
		switch (col) {
		case 0:
			return alimento.getId();
		case 1:
			return alimento.getNome();
		case 2:
			return alimento.getValorEnergetico();
		case 3:
			return alimento.getPorcao().toString();
		case 4:
			return alimento.getValorPorcao();
		case 5:
			return alimento.getQuantidade();
		}
		return "";
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return this.listaAlimentos.size();
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Código";
		case 1:
			return "Nome";
		case 2:
			return "Valor Energetico";
		case 3:
			return "Porção";
		case 4:
			return "Valor Porção";
		case 5:
			return "Quantidade";
		}
		return "";
	}

	@Override
	public void addTableModelListener(TableModelListener l) {

	}

	@Override
	public Class<?> getColumnClass(int col) {
		switch (col) {
		case 0:
			return Long.class;
		case 1:
			return String.class;
		case 2:
			return Double.class;
		case 3:
			return Integer.class;
		case 4:
			return Double.class;
		case 5:
			return Integer.class;
		default:
			throw new IndexOutOfBoundsException("Coluna fora dos limites.");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}

}
