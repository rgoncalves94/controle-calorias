package resource.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import controle.calorias.model.AtividadeFisica;
import controle.calorias.model.RegistroAtividadeFisica;

public class RegistroAtividadeFisicaDAO {
	private UsuarioDao usuarioDao = new UsuarioDao();
	private AtividadeFisicaDao atividadeDao = new AtividadeFisicaDao();
	
	public void insert(RegistroAtividadeFisica registroAtividade) {
		String query = "INSERT INTO registro_atividade (id_usuario, id_atividade, data_atividade, duracao) VALUES (?, ?, ?, ?);";
		 
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date d = java.sql.Date.valueOf(f.format(registroAtividade.getData()));
		
		Connection con;
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, registroAtividade.getUsuario().getId());
			stmt.setInt(2, registroAtividade.getAtividade().getId());
			stmt.setDate(3, d);
			stmt.setInt(4, (int) registroAtividade.getDuracao());
			stmt.executeUpdate();
			
			con.close();
			
			JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<RegistroAtividadeFisica> selectAll(int idUsuario, Date data) {
		List<RegistroAtividadeFisica> lista = new ArrayList<RegistroAtividadeFisica>();
		lista.clear();
		
		String query = "SELECT * FROM registro_atividade WHERE id_usuario = ? and data_atividade = ?;";
		Connection con;
		RegistroAtividadeFisica registroAtividade;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date d = java.sql.Date.valueOf(f.format(data));
		
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, idUsuario);
			stmt.setDate(2, d);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				registroAtividade = new RegistroAtividadeFisica();
				registroAtividade.setUsuario(usuarioDao.getUsuario(rs.getInt(1)));
				registroAtividade.setAtividade(atividadeDao.selectById(rs.getInt(2)));
				registroAtividade.setData(rs.getDate(3));
				registroAtividade.setDuracao(rs.getDouble(4));
				lista.add(registroAtividade);
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
}