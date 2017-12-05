package br.ufc.model;

import java.util.List;

public class Time {
	
	private String nome;
	private List<Jogador> jogadores;
	private int pontos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	

}
