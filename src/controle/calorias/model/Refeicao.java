package controle.calorias.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Refeicao {
	private int id;
	private Date data;
	private TipoRefeicao tipoRefeicao;
	
	private List<ItemRefeicao> alimentos = new ArrayList<ItemRefeicao>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}

	public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}

	public List<ItemRefeicao> getAlimentos() {
		return alimentos;
	}
	
	public void setAlimentos(List<ItemRefeicao> alimentos) {
		this.alimentos = alimentos;
	}
}