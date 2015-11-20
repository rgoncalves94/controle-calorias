package controle.calorias.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import controle.calorias.model.Alimento;

public class AlimentoDAO {
	public long insert(Alimento alimento) {
		long id = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `controle_calorias`.`alimento` (`alimento_nome`, `alimento_valor_energetico`, `porcao_id`, `alimento_valor_porcao`, `alimento_proteinas`, `alimento_fibras`, `alimento_carboidratos`, `alimento_sodio`, `alimento_gorduras_totais`, `alimento_gorduras_saturadas`, `alimento_gorduras_trans`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, alimento.getNome());
			stmt.setDouble(2, alimento.getValorEnergetico());
			stmt.setLong(3, alimento.getUnidadePorcao().getId());
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

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	public int update(Alimento alimento) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE `alimento_emprestimo` SET `alimento_emprestimo_nome`=?, `alimento_emprestimo_email`=?, `alimento_emprestimo_telefone`=?, `alimento_emprestimo_responsavel`=?, `alimento_emprestimo_cep`=?, `alimento_emprestimo_tipo_logradouro`=?, `alimento_emprestimo_logradouro`=?, `alimento_emprestimo_numero`=?, `alimento_emprestimo_complemento`=?, `alimento_emprestimo_bairro`=?, `alimento_emprestimo_cCodigoade`=?, `alimento_emprestimo_uf`=?, `alimento_emprestimo_ativo`=? WHERE `alimento_emprestimo_Codigo`=?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			// stmt.setString(1, alimento.getNomealimento());
			// stmt.setString(2, alimento.getEmail());
			// stmt.setString(3, alimento.getTelefone());
			// stmt.setString(4, alimento.getResponsavel());
			// stmt.setString(5, alimento.getCep());
			// stmt.setString(6, alimento.getTipoLogradouro());
			// stmt.setString(7, alimento.getLogradouro());
			// stmt.setString(8, alimento.getNumero());
			// stmt.setString(9, alimento.getComplemento());
			// stmt.setString(10, alimento.getBairro());
			// stmt.setString(11, alimento.getCCodigoade());
			// stmt.setString(12, alimento.getUf());
			// stmt.setBoolean(13, alimento.isAtivo());

			stmt.setLong(14, alimento.getCodigo());

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	public int delete(long Codigo) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "DELETE FROM `alimento_emprestimo` WHERE `alimento_emprestimo_Codigo`=?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, Codigo);

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	public Alimento selectByCodigo(long Codigo) {
		Alimento alimento = new Alimento();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM alimento_emprestimo WHERE alimento_emprestimo_Codigo = ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setLong(1, Codigo);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// alimento.setCodigo(rs.getLong("alimento_emprestimo_Codigo"));
				// alimento.setNomealimento(rs.getString("alimento_emprestimo_nome"));
				// alimento.setEmail(rs.getString("alimento_emprestimo_email"));
				// alimento.setTelefone(rs.getString("alimento_emprestimo_telefone"));
				// alimento.setResponsavel(rs.getString("alimento_emprestimo_responsavel"));
				// alimento.setCep(rs.getString("alimento_emprestimo_cep"));
				// alimento.setTipoLogradouro(rs.getString("alimento_emprestimo_tipo_logradouro"));
				// alimento.setLogradouro(rs.getString("alimento_emprestimo_logradouro"));
				// alimento.setNumero(rs.getString("alimento_emprestimo_numero"));
				// alimento.setComplemento(rs.getString("alimento_emprestimo_complemento"));
				// alimento.setBairro(rs.getString("alimento_emprestimo_bairro"));
				// alimento.setCCodigoade(rs.getString("alimento_emprestimo_cCodigoade"));
				// alimento.setUf(rs.getString("alimento_emprestimo_uf"));
				// alimento.setAtivo(rs.getBoolean("alimento_emprestimo_ativo"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return alimento;
	}

	public List<Alimento> selectByName(String name) {
		List<Alimento> locais = new ArrayList<Alimento>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM alimento_emprestimo WHERE alimento_emprestimo_nome LIKE ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + name + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Alimento alimento = new Alimento();
				// alimento.setCodigo(rs.getLong("alimento_emprestimo_Codigo"));
				// alimento.setNomealimento(rs.getString("alimento_emprestimo_nome"));
				// alimento.setEmail(rs.getString("alimento_emprestimo_email"));
				// alimento.setTelefone(rs.getString("alimento_emprestimo_telefone"));
				// alimento.setResponsavel(rs.getString("alimento_emprestimo_responsavel"));
				// alimento.setCep(rs.getString("alimento_emprestimo_cep"));
				// alimento.setTipoLogradouro(rs.getString("alimento_emprestimo_tipo_logradouro"));
				// alimento.setLogradouro(rs.getString("alimento_emprestimo_logradouro"));
				// alimento.setNumero(rs.getString("alimento_emprestimo_numero"));
				// alimento.setComplemento(rs.getString("alimento_emprestimo_complemento"));
				// alimento.setBairro(rs.getString("alimento_emprestimo_bairro"));
				// alimento.setCCodigoade(rs.getString("alimento_emprestimo_cCodigoade"));
				// alimento.setUf(rs.getString("alimento_emprestimo_uf"));
				// alimento.setAtivo(rs.getBoolean("alimento_emprestimo_ativo"));

				locais.add(alimento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return locais;
	}

	public List<Alimento> selectAll() {
		List<Alimento> locais = new ArrayList<Alimento>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM alimento_emprestimo";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Alimento alimento = new Alimento();
				alimento.setCodigo(rs.getLong("alimento_emprestimo_Codigo"));
				// alimento.setNomealimento(rs.getString("alimento_emprestimo_nome"));
				// alimento.setEmail(rs.getString("alimento_emprestimo_email"));
				// alimento.setTelefone(rs.getString("alimento_emprestimo_telefone"));
				// alimento.setResponsavel(rs.getString("alimento_emprestimo_responsavel"));
				// alimento.setCep(rs.getString("alimento_emprestimo_cep"));
				// alimento.setTipoLogradouro(rs.getString("alimento_emprestimo_tipo_logradouro"));
				// alimento.setLogradouro(rs.getString("alimento_emprestimo_logradouro"));
				// alimento.setNumero(rs.getString("alimento_emprestimo_numero"));
				// alimento.setComplemento(rs.getString("alimento_emprestimo_complemento"));
				// alimento.setBairro(rs.getString("alimento_emprestimo_bairro"));
				// alimento.setCCodigoade(rs.getString("alimento_emprestimo_cCodigoade"));
				// alimento.setUf(rs.getString("alimento_emprestimo_uf"));
				// alimento.setAtivo(rs.getBoolean("alimento_emprestimo_ativo"));

				locais.add(alimento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return locais;
	}
}
