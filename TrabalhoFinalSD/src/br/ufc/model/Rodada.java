package br.ufc.model;

import java.util.List;

public class Rodada {
	private Integer id;
	private List<Jogo> jogos;
	
	public List<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Rodada [jogos=" + jogos + "]";
	}
	
}
