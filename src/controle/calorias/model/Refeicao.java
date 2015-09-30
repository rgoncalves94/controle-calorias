package controle.calorias.model;

import java.util.List;

public class Refeicao {
	private long codigo;
	private TipoRefeicao tipoRefeicao;

	private List<Alimento> listAlimentos;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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
