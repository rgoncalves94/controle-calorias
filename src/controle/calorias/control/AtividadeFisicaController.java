package controle.calorias.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import resource.dao.AtividadeFisicaDao;
import controle.calorias.model.AtividadeFisica;
import controle.calorias.view.AdministrativoViewer;

public class AtividadeFisicaController implements TableModel , ListSelectionListener, ActionListener, KeyListener{
	private AdministrativoViewer formulario;
	private List<AtividadeFisica> lista;
	private AtividadeFisicaDao atividadeDao;
	
	public AtividadeFisicaController(AdministrativoViewer formulario) {
		this.formulario = formulario;
		this.atividadeDao = new AtividadeFisicaDao();
		this.lista =  atividadeDao.selectAll();
	}

	public void adicionar(AtividadeFisica atividade){
		int id = atividadeDao.insert(atividade);
		atividade.setId(id);
		lista.add(atividade);
	}
	
	public void atualizar(AtividadeFisica atividade, int linha){
		lista.set(linha, atividade);
		atividadeDao.update(atividade);
	}
	
	public void excluir(int id, int linha){
		atividadeDao.delete(id);
		lista.remove(linha);
	}
	
	public void filtrar (String nome){
		lista.clear();
		lista = atividadeDao.selectByNome(nome);
		atualizarTabela();
	}
	
	public void atualizarTabela(){
		formulario.getTabela().revalidate();
		formulario.getTabela().repaint();
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return Float.class;
		default:
			return String.class;
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Gasto Calórico";
		default:
			return "";
		}
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: return lista.get(rowIndex).getId();
		case 1: return lista.get(rowIndex).getNome();
		case 2: return String.format("%.2f", lista.get(rowIndex).getGastoCalorico());
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals("Salvar")) {
			if (formulario.validarPreenchimento()) {
				AtividadeFisica atividade = formulario.viewToControl();
				
				if (atividade.getId() == 0) {
					adicionar(atividade);
				} else{
					atualizar(atividade, getSelectedLine());
				}				
			}
		} else if (cmd.equals("Excluir")) {
			int txtId = formulario.viewToControl().getId();
			if (txtId == 0) {
				JOptionPane.showMessageDialog(null, "Favor selecione um registro!");
			} else{
				excluir(txtId, getSelectedLine());
				formulario.limparCampos();
			}
		} else if (cmd.equals("Limpar Campos")) {
			formulario.limparCampos();
		}
		
		atualizarTabela();
		formulario.limparCampos();
	}
	
	public int getSelectedLine(){
		int linha = formulario.getTabela().getSelectionModel().getMinSelectionIndex();
		return linha;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		AtividadeFisica atividade = lista.get(getSelectedLine());
		formulario.controlToView(atividade);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String nomeComponente = e.getComponent().getName();
		
		if (nomeComponente.equals("txtFiltro")) {
			JTextField txtFiltro = (JTextField) e.getComponent();
			filtrar(txtFiltro.getText());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		String nomeComponente = e.getComponent().getName();

		if (nomeComponente.equals("txtGastoCalorico")) {
			String aceitos = "0123456789.";
			if (!aceitos.contains("" + e.getKeyChar())) {
				e.consume();
			}			
		}
	}
}