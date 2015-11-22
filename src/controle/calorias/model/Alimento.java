package controle.calorias.model;

public class Alimento {

	private long id;
	private String nome;
	private double valorEnergetico;
	private Porcao porcao;
	private double valorPorcao;
	private double proteinas;
	private double fibras;
	private double carboidrato;
	private double sodio;
	private double gordurasTotais;
	private double gordurasSaturadas;
	private double gordurasTrans;

	public Alimento() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorEnergetico() {
		return valorEnergetico;
	}

	public void setValorEnergetico(double valorEnergetico) {
		this.valorEnergetico = valorEnergetico;
	}

	public Porcao getPorcao() {
		return porcao;
	}

	public void setPorcao(Porcao porcao) {
		this.porcao = porcao;
	}

	public double getValorPorcao() {
		return valorPorcao;
	}

	public void setValorPorcao(double valorPorcao) {
		this.valorPorcao = valorPorcao;
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
