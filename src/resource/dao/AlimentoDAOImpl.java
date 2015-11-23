package resource.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controle.calorias.model.Alimento;
import controle.calorias.model.Porcao;

public class AlimentoDAOImpl implements AlimentoDAO {

	private Connection conn;

	public AlimentoDAOImpl() {
		conn = ResourceManager.getInstance().getConnection();
	}

	@Override
	public long insert(Alimento alimento) {
		long id = 0;
		try {
			String query = "INSERT INTO alimento (nome, valor_energetico, id_porcao, valor_porcao, proteinas, "
					+ "fibras, carboidratos, sodio, gorduras_totais, gorduras_saturadas, gorduras_trans) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, alimento.getNome());
			stmt.setDouble(2, alimento.getValorEnergetico());
			stmt.setInt(3, alimento.getPorcao().getId());
			stmt.setDouble(4, alimento.getValorPorcao());
			stmt.setDouble(5, alimento.getProteinas());
			stmt.setDouble(6, alimento.getFibras());
			stmt.setDouble(7, alimento.getCarboidrato());
			stmt.setDouble(8, alimento.getSodio());
			stmt.setDouble(9, alimento.getGordurasTotais());
			stmt.setDouble(10, alimento.getGordurasSaturadas());
			stmt.setDouble(11, alimento.getGordurasTrans());

			stmt.executeUpdate();

			ResultSet r = stmt.getGeneratedKeys();
			r.next();
			id = r.getLong(1);

		} catch (SQLException e) {
			new AlimentoDAOException("Erro ao Inserir");
		}

		return id;
	}

	@Override
	public boolean update(Alimento alimento) {
		boolean status = false;
		try {
			String query = "UPDATE alimento SET nome=?, valor_energetico=?, id_porcao=?, valor_porcao=?, proteinas=?, fibras=?, carboidratos=?, sodio=?, gorduras_totais=?, gorduras_saturadas=?, gorduras_trans=? WHERE  id=?;";

			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setString(1, alimento.getNome());
			stmt.setDouble(2, alimento.getValorEnergetico());
			stmt.setInt(3, alimento.getPorcao().getId());
			stmt.setDouble(4, alimento.getValorPorcao());
			stmt.setDouble(5, alimento.getProteinas());
			stmt.setDouble(6, alimento.getFibras());
			stmt.setDouble(7, alimento.getCarboidrato());
			stmt.setDouble(8, alimento.getSodio());
			stmt.setDouble(9, alimento.getGordurasTotais());
			stmt.setDouble(10, alimento.getGordurasSaturadas());
			stmt.setDouble(11, alimento.getGordurasTrans());

			stmt.setLong(12, alimento.getId());

			int rowsAffected = stmt.executeUpdate();

			status = (rowsAffected == 1) ? true : false;

		} catch (SQLException e) {
			new AlimentoDAOException("Erro ao atualizar");
		}
		return status;
	}

	@Override
	public boolean delete(long id) {
		boolean status = false;
		try {
			String query = "DELETE FROM alimento WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setLong(1, id);

			status = (stmt.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {
			new AlimentoDAOException("Erro ao Deletar");
		}

		return status;
	}

	@Override
	public Alimento selectById(long id) {
		Alimento alimento = null;
		try {
			String query = "SELECT * FROM alimento WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setLong(1, id);

			ResultSet resultados = stmt.executeQuery();

			resultados.next();

			alimento = new Alimento();

			alimento.setId(resultados.getLong("id"));
			alimento.setNome(resultados.getString("nome"));
			alimento.setValorEnergetico(resultados.getDouble("valor_energetico"));
			alimento.setPorcao(new Porcao());
			alimento.getPorcao().setId(resultados.getInt("id_porcao"));
			alimento.setValorPorcao(resultados.getDouble("valor_porcao"));
			alimento.setProteinas(resultados.getDouble("proteinas"));
			alimento.setFibras(resultados.getDouble("fibras"));
			alimento.setCarboidrato(resultados.getDouble("carboidratos"));
			alimento.setSodio(resultados.getDouble("sodio"));
			alimento.setGordurasTotais(resultados.getDouble("gorduras_totais"));
			alimento.setGordurasSaturadas(resultados.getDouble("gorduras_saturadas"));
			alimento.setGordurasTrans(resultados.getDouble("gorduras_trans"));

		} catch (SQLException e) {
			new AlimentoDAOException("Erro ao Selecionar por ID");

		}
		return alimento;
	}

	@Override
	public List<Alimento> selectByName(String name) {
		List<Alimento> alimentos = null;
		try {
			String query = "SELECT * FROM alimento WHERE nome LIKE ?;";
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setString(1, "%" + name + "%");

			ResultSet resultados = stmt.executeQuery();

			alimentos = new ArrayList<Alimento>();

			while (resultados.next()) {

				Alimento alimento = new Alimento();

				alimento.setId(resultados.getLong("id"));
				alimento.setNome(resultados.getString("nome"));
				alimento.setValorEnergetico(resultados.getDouble("valor_energetico"));
				alimento.setPorcao(new Porcao());
				alimento.getPorcao().setId(resultados.getInt("id_porcao"));
				alimento.setValorPorcao(resultados.getDouble("valor_porcao"));
				alimento.setProteinas(resultados.getDouble("proteinas"));
				alimento.setFibras(resultados.getDouble("fibras"));
				alimento.setCarboidrato(resultados.getDouble("carboidratos"));
				alimento.setSodio(resultados.getDouble("sodio"));
				alimento.setGordurasTotais(resultados.getDouble("gorduras_totais"));
				alimento.setGordurasSaturadas(resultados.getDouble("gorduras_saturadas"));
				alimento.setGordurasTrans(resultados.getDouble("gorduras_trans"));

				alimentos.add(alimento);

			}
		} catch (SQLException e) {
			new AlimentoDAOException("Erro ao Selecionar por ID");
		}
		return alimentos;
	}

	@Override
	public List<Alimento> selectAll() {
		List<Alimento> alimentos = null;
		try {
			String query = "SELECT * FROM alimento;";
			PreparedStatement stmt = conn.prepareStatement(query);

			ResultSet resultados = stmt.executeQuery();

			alimentos = new ArrayList<Alimento>();

			while (resultados.next()) {

				Alimento alimento = new Alimento();

				alimento.setId(resultados.getLong("id"));
				alimento.setNome(resultados.getString("nome"));
				alimento.setValorEnergetico(resultados.getDouble("valor_energetico"));
				alimento.setPorcao(new Porcao());
				alimento.getPorcao().setId(resultados.getInt("id_porcao"));
				alimento.setValorPorcao(resultados.getDouble("valor_porcao"));
				alimento.setProteinas(resultados.getDouble("proteinas"));
				alimento.setFibras(resultados.getDouble("fibras"));
				alimento.setCarboidrato(resultados.getDouble("carboidratos"));
				alimento.setSodio(resultados.getDouble("sodio"));
				alimento.setGordurasTotais(resultados.getDouble("gorduras_totais"));
				alimento.setGordurasSaturadas(resultados.getDouble("gorduras_saturadas"));
				alimento.setGordurasTrans(resultados.getDouble("gorduras_trans"));

				alimentos.add(alimento);

			}
		} catch (SQLException e) {
			new AlimentoDAOException("Erro ao Selecionar por ID");
		}
		return alimentos;
	}

}
