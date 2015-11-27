package controle.calorias.view;

import javax.swing.JOptionPane;

import controle.calorias.model.Usuario;
import resource.dao.UsuarioDao;

public class Index {
	public static void main(String[] args) {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = null;
		String user = "";
		
		while (usuario == null) {
			user = JOptionPane.showInputDialog("Digite o nome de usuario:");
			if (!user.isEmpty()) {
				usuario = dao.getUsuario(user);
				if (usuario != null) {
					new PrincipalViewer(usuario);
				}
			}
		}
	}
}
