package controle.calorias.model;

public enum Meta {
	PERDER_PESO(1, "Perder Peso"), 
	MANTER_PESO(2, "Manter Peso"), 
	GANHAR_PESO(3, "Ganhar Peso");

	private int id;
	private String texto;

	private Meta(int id, String texto) {
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