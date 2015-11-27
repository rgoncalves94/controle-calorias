package controle.calorias.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import controle.calorias.model.RegistroAtividadeFisica;
import controle.calorias.model.Usuario;
import controle.calorias.view.RegistroAtividadeFisicaViewer;
import resource.dao.RegistroAtividadeFisicaDAO;

public class RegistroAtividadeFisicaController implements TableModel, ActionListener{
	private List<RegistroAtividadeFisica> lista;
	private RegistroAtividadeFisicaDAO registroAtividadeFisicaDAO;
	private RegistroAtividadeFisicaViewer formulario;
	
	public RegistroAtividadeFisicaController(RegistroAtividadeFisicaViewer formulario, Usuario usuario, Date data) {
		this.formulario = formulario;
		registroAtividadeFisicaDAO = new RegistroAtividadeFisicaDAO();
		lista = registroAtividadeFisicaDAO.selectAll(usuario.getId(), data);
	}
	
	public void adicionar(RegistroAtividadeFisica registro){
		registroAtividadeFisicaDAO.insert(registro);
		lista.add(registro);
		atualizarTabela();
	}
	
	public void atualizarTabela(){
		formulario.getTabela().revalidate();
		formulario.getTabela().repaint();
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
		case 0: return "Atividade Física";
		case 1: return "Duração";
		case 2: return "Gasto Calórico";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}
	
	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		double gasto = lista.get(rowIndex).getDuracao() * lista.get(rowIndex).getAtividade().getGastoCalorico();
		
		switch (columnIndex) {
		case 0: return lista.get(rowIndex).getAtividade().getNome();
		case 1: return lista.get(rowIndex).getDuracao();
		case 2: return gasto;
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		lista = new ArrayList<>();
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals("Salvar")) {
			adicionar(formulario.viewToControl());
		}
	}
}