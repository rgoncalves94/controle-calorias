package controle.calorias.model;

public enum TipoRefeicao {
	CAFE_MANHA(1, "Café da Manhã"),
	LANCHE_MANHA(2, "Lanche da Manhã"),
	ALMOCO(3, "Almoço"),
	LANCHE_TARDE(4, "Lanche da Tarde"),
	JANTAR(5, "Jantar"),
	CEIA(6, "Ceia");

	private int id;
	private String texto;

	private TipoRefeicao(int id, String texto) {
		this.id = id;
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}

	public int getId() {
		return id;
	}
}