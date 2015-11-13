package resource.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import controle.calorias.model.AtividadeFisica;

public class AtividadeFisicaDao {
	public int insert(AtividadeFisica atividade) {
		int id = 0;
		String query = "INSERT INTO atividade_fisica (nome, gasto_calorico) VALUES (?, ?);";

		Connection con;
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, atividade.getNome());
			stmt.setDouble(2, atividade.getGastoCalorico());
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			id = rs.getInt(1);
			
			con.close();
			
			JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}
	
	public List<AtividadeFisica> selectAll() {
		List<AtividadeFisica> lista = new ArrayList<AtividadeFisica>();
		lista.clear();
		
		String query = "SELECT * FROM atividade_fisica;";
		Connection con;
		AtividadeFisica atividade;
		
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				atividade = new AtividadeFisica();
				atividade.setId(rs.getInt(1));
				atividade.setNome(rs.getString(2));
				atividade.setGastoCalorico(rs.getFloat(3));
				lista.add(atividade);
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public void update(AtividadeFisica atividade) {
		String query = "UPDATE atividade_fisica SET nome = ?, gasto_calorico = ? WHERE id = ?;";

		Connection con;
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, atividade.getNome());
			stmt.setDouble(2, atividade.getGastoCalorico());
			stmt.setInt(3, atividade.getId());
			stmt.executeUpdate();
						
			con.close();
			
			JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String query = "DELETE FROM atividade_fisica WHERE id = ?;";

		Connection con;
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
						
			con.close();
			
			JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<AtividadeFisica> selectByNome(String nome){
		List<AtividadeFisica> lista = new ArrayList<AtividadeFisica>();
		lista.clear();
		
		String query = "SELECT * FROM atividade_fisica WHERE nome LIKE ?;";
		Connection con;
		AtividadeFisica atividade;
		
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				atividade = new AtividadeFisica();
				atividade.setId(rs.getInt(1));
				atividade.setNome(rs.getString(2));
				atividade.setGastoCalorico(rs.getFloat(3));
				lista.add(atividade);
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
}