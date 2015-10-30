package controle.calorias.model;

public enum NivelAtividadeFisica {
	SEDENTARIA(1, "Sedentária"), 
	LIGEIRA(2, "Ligeira"), 
	MODERADA(3, "Moderada"),
	INTENSA(4, "Intensa"),
	MUITO_INTENSA(5, "Muito Intensa");

	private int id;
	private String texto;

	private NivelAtividadeFisica(int id, String texto) {
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