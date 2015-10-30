package controle.calorias.model;

import java.util.Date;

public class RegistroAtividadeFisica {
	private Usuario usuario;
	private AtividadeFisica atividade;
	private Date data;
	private double duracao;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public AtividadeFisica getAtividade() {
		return atividade;
	}

	public void setAtividade(AtividadeFisica atividade) {
		this.atividade = atividade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
}