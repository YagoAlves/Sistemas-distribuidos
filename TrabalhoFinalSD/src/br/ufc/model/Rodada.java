package br.ufc.model;

import java.util.List;

public class Rodada {
	
	List<Jogo> jogos;
	List<Time> times;
	public List<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	public List<Time> getTimes() {
		return times;
	}
	public void setTimes(List<Time> times) {
		this.times = times;
	}

}
