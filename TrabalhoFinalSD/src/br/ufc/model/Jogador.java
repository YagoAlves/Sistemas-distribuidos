package br.ufc.model;

public class Jogador {
	
	private String nome;
	private String posiçao;
	private int numero_gols;
	private int numero_assistencias;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPosiçao() {
		return posiçao;
	}
	public void setPosiçao(String posiçao) {
		this.posiçao = posiçao;
	}
	public int getNumero_gols() {
		return numero_gols;
	}
	public void setNumero_gols(int numero_gols) {
		this.numero_gols = numero_gols;
	}
	public int getNumero_assistencias() {
		return numero_assistencias;
	}
	public void setNumero_assistencias(int numero_assistencias) {
		this.numero_assistencias = numero_assistencias;
	} 
	
}

