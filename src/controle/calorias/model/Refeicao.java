package controle.calorias.model;

import java.util.Date;
import java.util.List;

public class Refeicao {
	private long id;
	private Date data;
	private Usuario usuario;
	private TipoRefeicao tipoRefeicao;
	private List<Alimento> listAlimentos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}

	public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}

	public List<Alimento> getListAlimentos() {
		return listAlimentos;
	}

	public void setListAlimentos(List<Alimento> listAlimentos) {
		this.listAlimentos = listAlimentos;
	}
}