package controle.calorias.model;

public class AtividadeFisica {
	private long codigo;
	private String descricao;
	private double gastoCalorico;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getGastoCalorico() {
		return gastoCalorico;
	}

	public void setGastoCalorico(double gastoCalorico) {
		this.gastoCalorico = gastoCalorico;
	}

}
