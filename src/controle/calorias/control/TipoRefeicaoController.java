package controle.calorias.control;

import java.util.List;

import controle.calorias.model.TipoRefeicao;
import resource.dao.TipoRefeicaoDAO;
import resource.dao.TipoRefeicaoDAOImpl;

public class TipoRefeicaoController {

	public List<TipoRefeicao> listaRefeicao;

	public TipoRefeicaoController() {
		TipoRefeicaoDAO dao = new TipoRefeicaoDAOImpl();
	}

}
