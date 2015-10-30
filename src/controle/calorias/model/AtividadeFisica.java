package controle.calorias.model;

public class AtividadeFisica {
	private int id;
	private String nome;
	private double gastoCalorico;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getGastoCalorico() {
		return gastoCalorico;
	}

	public void setGastoCalorico(double gastoCalorico) {
		this.gastoCalorico = gastoCalorico;
	}
}