package org.serratec.ContaBancaria.exceptions;

public class ValorInsuficienteException extends Exception {

	private static final long serialVersionUID = -3594071208645791701L;
	private Integer id;
	private String msg;
	
	public ValorInsuficienteException(Integer id, String msg) {
		super();
		this.id = id;
		this.msg = msg;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
