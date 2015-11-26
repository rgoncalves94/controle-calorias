package resource.dao;

import java.util.Date;
import java.util.List;
import controle.calorias.model.Refeicao;

public interface RefeicaoDAO {
	public long insert(Refeicao refeicao) throws RefeicaoDAOException;

	public boolean update(Refeicao refeicao) throws RefeicaoDAOException;

	public boolean delete(long id) throws RefeicaoDAOException;

	public Refeicao selectById(long id) throws RefeicaoDAOException;

	public List<Refeicao> selectByDateAndUsuario(Date data, long usuario) throws RefeicaoDAOException;

	public List<Refeicao> selectByUsuario(long usuario) throws RefeicaoDAOException;
}
