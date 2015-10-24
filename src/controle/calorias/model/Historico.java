package controle.calorias.model;

import java.util.Date;

public class Historico {
	private Date data;
	private double imc;
	private double tbmNormal;
	private double tbmRecomendada;
	private double pesoDia;
	private double consumoDia;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public double getTbmNormal() {
		return tbmNormal;
	}

	public void setTbmNormal(double tbmNormal) {
		this.tbmNormal = tbmNormal;
	}

	public double getTbmRecomendada() {
		return tbmRecomendada;
	}

	public void setTbmRecomendada(double tbmRecomendada) {
		this.tbmRecomendada = tbmRecomendada;
	}

	public double getPesoDia() {
		return pesoDia;
	}

	public void setPesoDia(double pesoDia) {
		this.pesoDia = pesoDia;
	}

	public double getConsumoDia() {
		return consumoDia;
	}

	public void setConsumoDia(double consumoDia) {
		this.consumoDia = consumoDia;
	}
}