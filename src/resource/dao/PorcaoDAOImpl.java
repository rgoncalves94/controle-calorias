package resource.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controle.calorias.model.Porcao;

public class PorcaoDAOImpl implements PorcaoDAO {

	private Connection conn;

	public PorcaoDAOImpl() {
		conn = ResourceManager.getInstance().getConnection();
	}

	public List<Porcao> selectAll() {
		List<Porcao> porcoes = null;

		try {
			String query = "SELECT * FROM porcao";
			PreparedStatement stmt = conn.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			porcoes = new ArrayList<Porcao>();
			while (rs.next()) {
				Porcao porcao = new Porcao();

				porcao.setId(rs.getInt("id"));
				porcao.setTexto(rs.getString("desc"));

				porcoes.add(porcao);
			}

		} catch (SQLException e) {
			new PorcaoDAOException("Erro ao selecionar todos os registros.");
		}

		return porcoes;
	}
}
