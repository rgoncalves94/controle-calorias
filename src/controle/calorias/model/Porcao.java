package controle.calorias.model;

public enum Porcao {
	VOLUME(1, "ml"), PESO(2, "gr"), UNIDADE(3, "Unidade");

	private int id;
	private String texto;

	private Porcao(int id, String texto) {
		this.id = id;
		this.texto = texto;
	}

	public int getId() {
		return id;
	}

	public String getTexto() {
		return texto;
	}
}