package org.serratec.ContaBancaria.dominio;

public class Conta {
	private Integer numero;
	private String titular;
	private Double saldo;
	private static int count = 1;
	
	public Conta(String titular, Double saldo) {
		this.numero = count;
		this.titular = titular;
		this.saldo = saldo;
		count++;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
