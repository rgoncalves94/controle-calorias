package controle.calorias.control;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import controle.calorias.model.Alimento;
import controle.calorias.model.Refeicao;
import resource.dao.RefeicaoDAO;
import resource.dao.RefeicaoDAOException;
import resource.dao.RefeicaoDAOImpl;

public class RefeicaoController implements TableModel, ListSelectionListener {

	private List<Refeicao> listaRefeicoes = new ArrayList<Refeicao>();

	private Date data;
	private long idUsuario;

	public RefeicaoController() {

		RefeicaoDAO dao = new RefeicaoDAOImpl();

		this.data = new Date();

		this.idUsuario = 9;

		try {
			listaRefeicoes = dao.selectByDateAndUsuario(data, 9);
		} catch (RefeicaoDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Refeicao> getRefeicoes() {
		return listaRefeicoes;
	}

	public void setRefeicoes(List<Refeicao> refeicoes) {
		this.listaRefeicoes = refeicoes;
	}

	/**
	 * CRUD
	 * 
	 */

	public String adicionar(Refeicao refeicao) {
		RefeicaoDAO dao = new RefeicaoDAOImpl();

		long id = 0;
		try {
			id = dao.insert(refeicao);
		} catch (RefeicaoDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (refeicao.getListAlimentos().size() > 0) {
			ItemRefeicaoController ctrl = new ItemRefeicaoController();

			List<Alimento> a = refeicao.getListAlimentos();
			for (Alimento alimento : a) {
				ctrl.insert(id, alimento.getId(), alimento.getQuantidade());
			}
		}

		this.revalidateRegisters();

		return (id > 0) ? "Registro excluído com sucesso." : "Não foi possível realizar a alteração do item.";
	}

	public String atualizar(Refeicao refeicao) {
		RefeicaoDAO dao = new RefeicaoDAOImpl();

		if (refeicao.getId() <= 0)
			return "Não foi possível realizar a alteração do item.";

		boolean result = false;
		try {
			result = dao.update(refeicao);
		} catch (RefeicaoDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.revalidateRegisters();

		return (result) ? "Registro excluído com sucesso." : "Não foi possível realizar a alteração do item.";
	}

	public String deletar(long id) {
		RefeicaoDAO dao = new RefeicaoDAOImpl();

		boolean result = false;
		try {
			result = dao.delete(id);
		} catch (RefeicaoDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.revalidateRegisters();

		return (result) ? "Registro excluído com sucesso." : "Não foi possível realizar a exclusão do item";
	}

	public Refeicao selecionarPorId(long id) {
		RefeicaoDAO dao = new RefeicaoDAOImpl();

		Refeicao refeicao = null;
		try {
			refeicao = dao.selectById(id);
		} catch (RefeicaoDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return refeicao;
	}

	public List<Refeicao> selecionarPorUsuario(long id) {
		RefeicaoDAO dao = new RefeicaoDAOImpl();

		List<Refeicao> refeicoes = null;
		try {
			refeicoes = dao.selectByUsuario(id);
		} catch (RefeicaoDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return refeicoes;
	}

	public List<Refeicao> selecionarTodos(Date data, long user) {
		RefeicaoDAO dao = new RefeicaoDAOImpl();

		List<Refeicao> refeicoes = null;
		try {
			refeicoes = dao.selectByDateAndUsuario(data, user);
		} catch (RefeicaoDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return refeicoes;
	}

	/**
	 * Métodos Table Model
	 * 
	 */

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Long.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Id";
		case 1:
			return "Data";
		case 2:
			return "Usuário";
		case 3:
			return "Tipo Refeição";
		}

		return "";
	}

	@Override
	public int getRowCount() {
		return this.listaRefeicoes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Refeicao refeicao = listaRefeicoes.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return refeicao.getId();
		case 1:
			return refeicao.getData().toString();
		case 2:
			return refeicao.getUsuario().getNome();
		case 3:
			return refeicao.getTipoRefeicao().toString();
		default:
			throw new ArrayIndexOutOfBoundsException("Erro no total to valor da table Refeicao");
		}

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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}

	private void revalidateRegisters() {
		RefeicaoDAO dao = new RefeicaoDAOImpl();

		try {
			listaRefeicoes = dao.selectByDateAndUsuario(data, idUsuario);
		} catch (RefeicaoDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
