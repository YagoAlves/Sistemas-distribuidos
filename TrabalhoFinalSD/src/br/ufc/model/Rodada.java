package br.ufc.model;

import java.util.Date;
import java.util.List;

public class Rodada {
	private Integer id;
	private List<Jogo> jogos;
	private Date dataIni;
	private Date dataFim;
	
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
	public Date getDataIni() {
		return dataIni;
	}
	public void setDataIni(Date dataIni) {
		this.dataIni = dataIni;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	@Override
	public String toString() {
		return "Rodada [jogos=" + jogos + "]";
	}
	
}
