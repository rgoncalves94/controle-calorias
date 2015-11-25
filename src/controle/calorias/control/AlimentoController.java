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

import controle.calorias.model.Alimento;
import controle.calorias.model.AtividadeFisica;
import controle.calorias.model.Porcao;
import controle.calorias.view.AdministrativoViewer;
import resource.dao.AlimentoDAO;
import resource.dao.AlimentoDAOImpl;

public class AlimentoController implements TableModel, ListSelectionListener, ActionListener, KeyListener {

	private AdministrativoViewer formulario = null;
	private List<Alimento> listaAlimentos = null;
	private List<Porcao> listaPorcao = null;

	public AlimentoController(AdministrativoViewer form) {
		AlimentoDAO dao = new AlimentoDAOImpl();
		listaAlimentos = dao.selectAll();

		PorcaoController pc = new PorcaoController();

		listaPorcao = pc.selecionaTodos();

		this.formulario = form;
	}

	public AlimentoController() {
		this(null);
	}

	public String adicionar(Alimento alimento) {
		AlimentoDAO dao = new AlimentoDAOImpl();

		long id = dao.insert(alimento);

		this.revalidateRegisters();

		return (id > 0) ? "Registro excluído com sucesso." : "Não foi possível realizar a alteração do item.";
	}

	public String alterar(Alimento alimento) {
		AlimentoDAO dao = new AlimentoDAOImpl();

		if (alimento.getId() <= 0)
			return "Não foi possível realizar a alteração do item.";

		boolean result = dao.update(alimento);

		this.revalidateRegisters();

		return (result) ? "Registro excluído com sucesso." : "Não foi possível realizar a alteração do item.";
	}

	public String deletar(long id) {

		AlimentoDAO dao = new AlimentoDAOImpl();

		boolean result = dao.delete(id);

		this.revalidateRegisters();

		return (result) ? "Registro excluído com sucesso." : "Não foi possível realizar a exclusão do item";
	}

	public Alimento selecionaPorId(long id) {
		AlimentoDAO dao = new AlimentoDAOImpl();

		return dao.selectById(id);
	}

	public List<Alimento> selecionaPorNome(String nome) {
		AlimentoDAO dao = new AlimentoDAOImpl();

		return dao.selectByName(nome);
	}

	public List<Alimento> selecionaTodos() {

		AlimentoDAO dao = new AlimentoDAOImpl();

		return dao.selectAll();
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
			for (Porcao p : listaPorcao) {
				if (alimento.getPorcao().getId() == p.getId()) {
					alimento.setPorcao(p);
					break;
				}
			}
			return alimento.getPorcao().toString();
		case 4:
			return alimento.getValorPorcao();
		case 5:
			return alimento.getProteinas();
		case 6:
			return alimento.getFibras();
		case 7:
			return alimento.getCarboidrato();
		case 8:
			return alimento.getSodio();
		case 9:
			return alimento.getGordurasTotais();
		case 10:
			return alimento.getGordurasSaturadas();
		case 11:
			return alimento.getGordurasTrans();
		}
		return "";
	}

	@Override
	public int getColumnCount() {
		return 12;
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
			return "Proteinas";
		case 6:
			return "Fibras";
		case 7:
			return "Carboidrato";
		case 8:
			return "Sodio";
		case 9:
			return "G. Totais";
		case 10:
			return "G. Saturadas";
		case 11:
			return "G. Trans";
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
			return Double.class;
		case 6:
			return Double.class;
		case 7:
			return Double.class;
		case 8:
			return Double.class;
		case 9:
			return Double.class;
		case 10:
			return Double.class;
		case 11:
			return Double.class;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equals("SalvarAlimento")) {
			if (formulario.validarPreenchimentoAlimento()) {
				Alimento alimento = formulario.viewAlimentoToControl();
				if (alimento.getId() == 0) {
					this.adicionar(alimento);
				} else {
					this.alterar(alimento);
				}
			}
		} else if (cmd.equals("ExcluirAlimento")) {
			long txtId = formulario.viewAlimentoToControl().getId();
			if (txtId == 0) {
				JOptionPane.showMessageDialog(null, "Favor selecione um registro!");
			} else {
				this.deletar(txtId);
				formulario.limparCamposAlimento();
			}
		} else if (cmd.equals("Limpar Campos Alimento")) {
			formulario.limparCamposAlimento();
		}

		this.atualizarTabela();
		formulario.limparCamposAlimento();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		String nomeComponente = e.getComponent().getName();

		if (nomeComponente.equals("txtFiltroAlimento")) {
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Alimento alimento = listaAlimentos.get(this.getSelectedLine());
		formulario.controlToAlimentoView(alimento);

	}

	public int getSelectedLine() {
		int linha = formulario.getTabelaAlimento().getSelectionModel().getMinSelectionIndex();
		return linha;
	}

	public void filtrar(String nome) {
		listaAlimentos.clear();

		listaAlimentos = this.selecionaPorNome(nome);
		atualizarTabela();
	}

	private void revalidateRegisters() {
		AlimentoDAO dao = new AlimentoDAOImpl();

		listaAlimentos = dao.selectAll();
	}

	void atualizarTabela() {
		formulario.getTabelaAlimento().revalidate();
		formulario.getTabelaAlimento().repaint();
	}
}
