package controle.calorias.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controle.calorias.model.TipoRefeicao;
import resource.dao.ResourceManager;

public class TipoRefeicaoDAOImpl implements TipoRefeicaoDAO {

	private Connection conn;

	public TipoRefeicaoDAOImpl() {
		conn = ResourceManager.getInstance().getConnection();
	}

	@Override
	public List<TipoRefeicao> selecionaTodos() throws TipoRefeicaoDAOException {
		List<TipoRefeicao> tipoRefeicoes = null;
		try {
			String query = "SELECT * FROM tipo_refeicao;";

			PreparedStatement stmt = conn.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			tipoRefeicoes = new ArrayList<TipoRefeicao>();

			while (rs.next()) {
				TipoRefeicao ref = new TipoRefeicao();
				ref.setId(rs.getInt("id"));
				ref.setDescricao(rs.getString("nome"));

				tipoRefeicoes.add(ref);
			}

		} catch (SQLException e) {
			throw new TipoRefeicaoDAOException("Não foi possivel realizar a consulta.");
		}
		return tipoRefeicoes;
	}

}
