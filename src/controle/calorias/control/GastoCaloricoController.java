package controle.calorias.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import controle.calorias.model.RegistroAtividadeFisica;
import resource.dao.RegistroAtividadeFisicaDAO;

public class GastoCaloricoController implements TableModel{
	private List<RegistroAtividadeFisica> lista;
//	private RegistroAtividadeFisicaDAO registroAtividadeFisicaDAO;
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		lista = new ArrayList<>();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0: return String.class;
		case 1: return Double.class;
		case 2: return Double.class;
		default:
			return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0: return "Atividade F�sica";
		case 1: return "Dura��o";
		case 2: return "Gasto Cal�rico";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return null;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		
	}

}