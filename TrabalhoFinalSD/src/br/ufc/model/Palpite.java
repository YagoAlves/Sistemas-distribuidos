package br.ufc.model;

import java.util.List;
import java.util.Map;

public class Palpite {

	private Integer id;
	private Rodada rodada;
	private List<String> palpite;
	private Jogador jogador;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Rodada getRodada() {
		return rodada;
	}
	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public List<String> getPalpite() {
		return palpite;
	}
	public void setPalpite(List<String> palpite) {
		this.palpite = palpite;
	}
}
