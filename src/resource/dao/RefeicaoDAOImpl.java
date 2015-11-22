package resource.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controle.calorias.model.Alimento;
import controle.calorias.model.Refeicao;

public class RefeicaoDAOImpl implements RefeicaoDAO {

	private Connection conn;

	public RefeicaoDAOImpl() {
		conn = ResourceManager.getInstance().getConnection();
	}

	@Override
	public long insert(Refeicao refeicao) {
		long id = 0;
		try {
			String query = "INSERT INTO refeicao (id_usuario, data_refeicao, id_tipo_refeicao) VALUES (?, ?, ?);";

			PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, refeicao.getUsuario().getId());
			stmt.setDate(2, new java.sql.Date(refeicao.getData().getTime()));
			stmt.setLong(3, refeicao.getTipoRefeicao().getId());

			stmt.executeUpdate();

			ResultSet r = stmt.getGeneratedKeys();
			r.next();
			id = r.getLong(1);

		} catch (SQLException e) {
			new RefeicaoDAOException("Erro ao Inserir");
		}

		return id;
	}

	@Override
	public boolean update(Refeicao refeicao) {
		boolean status = false;
		try {
			String query = "UPDATE refeicao SET id_usuario=?, data_refeicao=?, id_tipo_refeicao=? WHERE  id=?;";

			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setLong(1, refeicao.getUsuario().getId());
			stmt.setDate(2, new java.sql.Date(refeicao.getData().getTime()));

			status = (stmt.executeUpdate() == 1) ? true : false;

		} catch (SQLException e) {
			new RefeicaoDAOException("Erro ao atualizar");
		}

		return status;
	}

	@Override
	public boolean delete(long id) {
		boolean status = false;
		try {
			String query = "DELETE FROM refeicao WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setLong(1, id);

			status = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			new RefeicaoDAOException("Erro ao Deletar");
		}

		return status;
	}

	@Override
	public Refeicao selectById(long id) {
		Refeicao refeicao = null;
		try {
			String query = "SELECT * FROM refeicao WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setLong(1, id);

			ResultSet resultados = stmt.executeQuery();

			resultados.next();

			refeicao = new Refeicao();

			refeicao.setId(resultados.getLong("id"));

		} catch (SQLException e) {
			new RefeicaoDAOException("Erro ao Selecionar por ID");

		}
		return refeicao;
	}

	@Override
	public List<Refeicao> selectByUsuario(long usuario) {
		List<Refeicao> refeicoes = null;
		try {
			String query = "SELECT * FROM refeicao WHERE id_usuario = ?";
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setLong(1, usuario);

			ResultSet resultados = stmt.executeQuery();

			refeicoes = new ArrayList<Refeicao>();

			while (resultados.next()) {

				Refeicao refeicao = new Refeicao();

				refeicao.setId(resultados.getLong("id"));

				refeicoes.add(refeicao);

			}
		} catch (SQLException e) {
			new RefeicaoDAOException("Erro ao Selecionar por ID");
		}
		return refeicoes;
	}

	@Override
	public List<Refeicao> selectByDateAndUsuario(Date data, long usuario) {
		List<Refeicao> refeicoes = null;
		try {
			String query = "SELECT * FROM refeicao WHERE id_usuario = ? AND data_refeicao >= ? AND data_refeicao <= ?";
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setLong(1, usuario);
			stmt.setDate(2, new java.sql.Date(data.getTime()));
			stmt.setDate(3, new java.sql.Date(data.getTime()));

			ResultSet resultados = stmt.executeQuery();

			refeicoes = new ArrayList<Refeicao>();

			while (resultados.next()) {

				Refeicao refeicao = new Refeicao();

				refeicao.setId(resultados.getLong("id"));

				refeicoes.add(refeicao);

			}
		} catch (SQLException e) {
			new RefeicaoDAOException("Erro ao Selecionar por ID");
		}
		return refeicoes;
	}

}
