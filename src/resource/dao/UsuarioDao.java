package resource.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import controle.calorias.model.AtividadeFisica;
import controle.calorias.model.Intensidade;
import controle.calorias.model.Meta;
import controle.calorias.model.NivelAtividadeFisica;
import controle.calorias.model.Usuario;

public class UsuarioDao {
	
	public Usuario getUsuario(String nome){
		
		String query = "SELECT * FROM usuario WHERE nome = ?;";
		Connection con;
		Usuario usuario = null;
		
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setDataNascimento(rs.getDate(3));
				usuario.setAltura(rs.getDouble(4));
				usuario.setPeso(rs.getDouble(5));
				usuario.setPesoDesejado(rs.getDouble(6));
				usuario.setMeta(getMeta(rs.getInt(7)));
				usuario.setIntensidade(getIntensidade(rs.getInt(8)));
				usuario.setNivelAtvFisica(getNivelAtividadeFisica(rs.getInt(9)));				
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
	
	public Usuario getUsuario(int id){
		
		String query = "SELECT * FROM usuario WHERE id = ?;";
		Connection con;
		Usuario usuario = null;
		
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setDataNascimento(rs.getDate(3));
				usuario.setAltura(rs.getDouble(4));
				usuario.setPeso(rs.getDouble(5));
				usuario.setPesoDesejado(rs.getDouble(6));
				usuario.setMeta(getMeta(rs.getInt(7)));
				usuario.setIntensidade(getIntensidade(rs.getInt(8)));
				usuario.setNivelAtvFisica(getNivelAtividadeFisica(rs.getInt(9)));				
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
	
	public Meta getMeta(int id){
		String query = "SELECT * FROM meta WHERE id = ?;";
		Connection con;
		Meta meta = null;
		
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			meta = new Meta();
			meta.setId(rs.getInt(1));
			meta.setTexto(rs.getString(2));
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return meta;
	}
	
	public NivelAtividadeFisica getNivelAtividadeFisica(int id){
		String query = "SELECT * FROM nivel_atividade_fisica WHERE id = ?;";
		Connection con;
		NivelAtividadeFisica nivelAtividadeFisica = null;
		
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			nivelAtividadeFisica = new NivelAtividadeFisica();
			nivelAtividadeFisica.setId(rs.getInt(1));
			nivelAtividadeFisica.setTexto(rs.getString(2));
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nivelAtividadeFisica;
	}
	
	public Intensidade getIntensidade(int id){
		String query = "SELECT * FROM nivel_atividade_fisica WHERE id = ?;";
		Connection con;
		Intensidade intensidade = null;
		
		try {
			con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			intensidade = new Intensidade();
			intensidade.setId(rs.getInt(1));
			intensidade.setTexto(rs.getString(2));
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return intensidade;
	}
}