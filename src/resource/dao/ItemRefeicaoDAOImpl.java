package resource.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRefeicaoDAOImpl implements ItemRefeicaoDAO {

	private Connection conn;

	public ItemRefeicaoDAOImpl() {
		conn = ResourceManager.getInstance().getConnection();
	}

	public int insert(long idRefeicao, long idAlimento, int qtde) throws ItemRefeicaoDAOException {
		int id = 0;
		try {
			String query = "INSERT INTO item_refeicao VALUES (?, ? , ?);";
			PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, idRefeicao);
			stmt.setLong(2, idAlimento);
			stmt.setInt(3, qtde);

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			rs.next();

			id = rs.getInt(1);
		} catch (SQLException e) {
			throw new ItemRefeicaoDAOException("Não foi possível realizar o insert.");
		}
		return id;
	}

	@Override
	public boolean delete(int idRefeicao, int idAlimento) throws ItemRefeicaoDAOException {
		boolean status = false;
		try {
			String query = "DELETE FROM item_refeicao WHERE id_refeicao = ? AND id_alimento = ?;";
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setInt(1, idRefeicao);
			stmt.setInt(2, idAlimento);

			status = (stmt.executeUpdate() > 0) ? true : false;

		} catch (SQLException e) {
			throw new ItemRefeicaoDAOException("Não foi possível realizar o delete.");
		}
		return status;
	}

	@Override
	public boolean deleteByRefeicao(int idRefeicao) throws ItemRefeicaoDAOException {
		boolean status = false;
		try {
			String query = "DELETE FROM item_refeicao WHERE id_refeicao = ?;";
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setInt(1, idRefeicao);

			status = (stmt.executeUpdate() > 0) ? true : false;

		} catch (SQLException e) {
			throw new ItemRefeicaoDAOException("Não foi possível realizar o delete pela refeicao.");
		}
		return status;
	}

}
