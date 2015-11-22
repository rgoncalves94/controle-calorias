package resource.dao;

import java.util.Date;
import java.util.List;
import controle.calorias.model.Refeicao;

public interface RefeicaoDAO {
	public long insert(Refeicao refeicao);

	public boolean update(Refeicao refeicao);

	public boolean delete(long id);

	public Refeicao selectById(long id);

	public List<Refeicao> selectByDateAndUsuario(Date data, long usuario);

	public List<Refeicao> selectByUsuario(long usuario);
}
