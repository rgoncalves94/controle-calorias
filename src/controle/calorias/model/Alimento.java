package controle.calorias.model;

public class Alimento {
	private long codigo;
	private String descricao;
	private double valorEnergetico;
	private double proteinas;
	private double fibras;
	private double carboidrato;
	private double sodio;
	private double gordurasTotais;
	private double gordurasSaturadas;
	private double gordurasTrans;
	
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

	public double getValorEnergetico() {
		return valorEnergetico;
	}

	public void setValorEnergetico(double valorEnergetico) {
		this.valorEnergetico = valorEnergetico;
	}

	public double getProteinas() {
		return proteinas;
	}

	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	public double getFibras() {
		return fibras;
	}

	public void setFibras(double fibras) {
		this.fibras = fibras;
	}

	public double getCarboidrato() {
		return carboidrato;
	}

	public void setCarboidrato(double carboidrato) {
		this.carboidrato = carboidrato;
	}

	public double getSodio() {
		return sodio;
	}

	public void setSodio(double sodio) {
		this.sodio = sodio;
	}

	public double getGordurasTotais() {
		return gordurasTotais;
	}

	public void setGordurasTotais(double gordurasTotais) {
		this.gordurasTotais = gordurasTotais;
	}

	public double getGordurasSaturadas() {
		return gordurasSaturadas;
	}

	public void setGordurasSaturadas(double gordurasSaturadas) {
		this.gordurasSaturadas = gordurasSaturadas;
	}

	public double getGordurasTrans() {
		return gordurasTrans;
	}

	public void setGordurasTrans(double gordurasTrans) {
		this.gordurasTrans = gordurasTrans;
	}
}
