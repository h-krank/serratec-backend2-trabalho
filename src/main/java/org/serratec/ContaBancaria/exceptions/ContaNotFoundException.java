package org.serratec.ContaBancaria.exceptions;

public class ContaNotFoundException extends Exception{

	private static final long serialVersionUID = 5371794928188622986L;
	private Integer id;

	public ContaNotFoundException(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
