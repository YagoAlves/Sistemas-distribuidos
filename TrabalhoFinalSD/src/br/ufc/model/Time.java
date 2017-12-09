package br.ufc.model;

public class Time {
	
	private Integer id;
	private String nome;
	
	public Time(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Time [nome=" + nome + "]";
	}
	
}
