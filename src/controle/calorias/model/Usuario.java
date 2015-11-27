package controle.calorias.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
	private int id;
	private String nome;
	private Date dataNascimento;
	private double peso;
	private double pesoDesejado;
	private double altura;
	private Intensidade intensidade;
	private NivelAtividadeFisica nivelAtvFisica;
	private Meta meta;
	
	private List<RegistroAtividadeFisica> registroAtividades = new ArrayList<RegistroAtividadeFisica>();
	private List<Historico> historico = new ArrayList<Historico>();
	
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

	public Intensidade getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(Intensidade intensidade) {
		this.intensidade = intensidade;
	}

	public NivelAtividadeFisica getNivelAtvFisica() {
		return nivelAtvFisica;
	}

	public void setNivelAtvFisica(NivelAtividadeFisica nivelAtvFisica) {
		this.nivelAtvFisica = nivelAtvFisica;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<RegistroAtividadeFisica> getRegistroAtividades() {
		return registroAtividades;
	}

	public void setRegistroAtividades(
			List<RegistroAtividadeFisica> registroAtividades) {
		this.registroAtividades = registroAtividades;
	}

	public List<Historico> getHistorico() {
		return historico;
	}

	public void setHistorico(List<Historico> historico) {
		this.historico = historico;
	}
	
	@Override
	public String toString() {
		return getNome();
	}
}