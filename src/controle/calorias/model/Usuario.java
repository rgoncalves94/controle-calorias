package controle.calorias.model;

import java.util.Date;
import java.util.List;

public class Usuario {
	private long codigo;
	private String nome;
	private Date dataNascimento;
	private double peso;
	private double pesoDesejado;
	private double altura;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPesoDesejado() {
		return pesoDesejado;
	}

	public void setPesoDesejado(double pesoDesejado) {
		this.pesoDesejado = pesoDesejado;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

}