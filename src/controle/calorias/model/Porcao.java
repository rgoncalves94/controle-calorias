package controle.calorias.model;

public class Porcao {
	private int id;
	private String texto;

	public Porcao() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return id + " - " + texto;

	}

}