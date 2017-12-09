package br.ufc.model;

public class Mensagem {

	private Integer messageType;
	private Integer requestId;
	private String metodo;
	private String objReference;
	private Object argumentos;
	public Integer getMessageType() {
		return messageType;
	}
	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public Object getArgumentos() {
		return argumentos;
	}
	public void setArgumentos(Object argumentos) {
		this.argumentos = argumentos;
	}
	public String getObjReference() {
		return objReference;
	}
	public void setObjReference(String objReference) {
		this.objReference = objReference;
	}
}
