package resource.dao;

public interface ItemRefeicaoDAO {
	public int insert(long id, long l, int qtde) throws ItemRefeicaoDAOException;

	public boolean delete(int idRefeicao, int idAlimento) throws ItemRefeicaoDAOException;

	public boolean deleteByRefeicao(int idRefeicao) throws ItemRefeicaoDAOException;
}
