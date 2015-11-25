package controle.calorias.control;

import java.util.List;

import controle.calorias.model.TipoRefeicao;

public class TipoRefeicaoController {

	public List<TipoRefeicao> listaRefeicao;

	public TipoRefeicaoController() {
		TipoRefeicaoDAO dao = new TipoRefeicaoDAOImpl();
	}

}
