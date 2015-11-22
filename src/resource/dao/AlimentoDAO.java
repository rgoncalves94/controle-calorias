package resource.dao;

import java.util.List;

import controle.calorias.model.Alimento;

public interface AlimentoDAO {
	public long insert(Alimento alimento);

	public boolean update(Alimento alimento);

	public boolean delete(long id);

	public Alimento selectById(long id);

	public List<Alimento> selectByName(String name);

	public List<Alimento> selectAll();
}
