package resource.dao;

import java.util.List;

import controle.calorias.model.Alimento;

public interface AlimentoDAO {
	public long insert(Alimento alimento) throws AlimentoDAOException;

	public boolean update(Alimento alimento) throws AlimentoDAOException;

	public boolean delete(long id) throws AlimentoDAOException;

	public Alimento selectById(long id) throws AlimentoDAOException;

	public List<Alimento> selectByName(String name) throws AlimentoDAOException;

	public List<Alimento> selectAll() throws AlimentoDAOException;
}
