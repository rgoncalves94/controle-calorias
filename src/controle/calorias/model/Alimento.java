package controle.calorias.model;

public class Alimento {

	private long codigo;
	private String nome;
	private double valorEnergetico;
	private Porcao unidadePorcao;
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

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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

	public Porcao getUnidadePorcao() {
		return unidadePorcao;
	}

	public void setUnidadePorcao(Porcao unidadePorcao) {
		this.unidadePorcao = unidadePorcao;
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
