package controle.calorias.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controle.calorias.model.Usuario;
import controle.calorias.view.AdministrativoViewer;
import controle.calorias.view.PrincipalViewer;
import controle.calorias.view.RegistroAtividadeFisicaViewer;

public class PrincipalController implements ActionListener{
	private PrincipalViewer principal;
	private Usuario usuario;
	private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate hoje = LocalDate.now();
	
	public PrincipalController(PrincipalViewer principal, Usuario usuario) {
		this.principal = principal;
		this.usuario = usuario;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals("AcessoAdm")) {
			new AdministrativoViewer(usuario);
			principal.dispose();
		} else if (cmd.equals("DiaAnterior")) {
			LocalDate d = principal.getDataDoLblData();
			d = d.minusDays(1);
			principal.setData(d.format(formatador));
			principal.setLblData(principal.getData());
		} else if (cmd.equals("DiaPosterior")) {
			LocalDate d = principal.getDataDoLblData();
			d = d.plusDays(1);
			principal.setData(d.format(formatador));
			if (hoje.isAfter(d) || hoje.equals(d)) {
				principal.setLblData(principal.getData());					
			}
		} else if(cmd.equals("AtualizarGasto")){
			new RegistroAtividadeFisicaViewer(this.usuario);
		}
	}
}