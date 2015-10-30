package controle.calorias.model;

public enum Intensidade {
	LEVE(1, "Leve"), 
	MODERADA(2, "Moderada"), 
	INTENSA(3, "Intensa"), 
	MUITO_INTENSA(4, "Muito Intensa");

	private int id;
	private String texto;

	private Intensidade(int id, String texto) {
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