package resource.dao;

import java.util.List;

import controle.calorias.model.TipoRefeicao;

public interface TipoRefeicaoDAO {
	public List<TipoRefeicao> selecionaTodos() throws TipoRefeicaoDAOException;

}
