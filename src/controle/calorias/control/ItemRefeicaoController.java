package controle.calorias.control;

import resource.dao.ItemRefeicaoDAO;
import resource.dao.ItemRefeicaoDAOException;
import resource.dao.ItemRefeicaoDAOImpl;

public class ItemRefeicaoController {

	public ItemRefeicaoController() {

	}

	public void insert(long id, long l, int qtde) {
		ItemRefeicaoDAO dao = new ItemRefeicaoDAOImpl();

		try {
			dao.insert(id, l, qtde);
		} catch (ItemRefeicaoDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertMultiple(int idRefeicao, int[] idAlimentos, int[] qtdes) {
		ItemRefeicaoDAO dao = new ItemRefeicaoDAOImpl();

		int total = idAlimentos.length, i = 0;

		while (total > i) {
			try {
				dao.insert(idRefeicao, idAlimentos[i], qtdes[i]);
			} catch (ItemRefeicaoDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
