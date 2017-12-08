package br.ufc.model;

import java.util.Date;

public class Jogo{

	public Jogo(Integer id, Time time1, Time time2
) {
		super();
		this.id = id;
		this.time1 = time1;
		this.time2 = time2;
	}
	private Integer id;
	private Time time1;
	private Time time2;
	private String resultado = "sem";
	private Date date;
	
	public Time getTime1() {
		return time1;
	}
	public void setTime1(Time time1) {
		this.time1 = time1;
	}
	public Time getTime2() {
		return time2;
	}
	public void setTime2(Time time2) {
		this.time2 = time2;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Jogo [time1=" + time1 + ", time2=" + time2 + ", resultado="
				+ resultado + "]";
	}
	

}
