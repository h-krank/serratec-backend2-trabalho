package org.serratec.ContaBancaria.dominio;

public class Operacao {
	private Tipo tipo;
	private Double valor;
	
	public Operacao(Tipo tipo, Double valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
