package br.ufc.model;

import java.util.ArrayList;
import java.util.List;

public class Teste {
	public Jogador jogador1 = new Jogador();
	public Jogador jogador2 = new Jogador();
	public Jogador jogador3 = new Jogador();
	public Jogo jogo = new Jogo();
	public Rodada rodada = new Rodada();
	public Time time1 = new Time();
	public Time time2 = new Time();
	
	public void inicio() {
		
		jogador1.setNome("Afonso");
		jogador2.setNome("Teste");
		jogador3.setNome("dsadsad");
		time1.setNome("São Paulo");
		time2.setNome("Flamengo");
		jogo.setTime1(time1);
		jogo.setTime2(time2);
		List<Jogo> jogos = new ArrayList<Jogo>();
		List<Time> times = new ArrayList<Time>();
		jogos.add(jogo);
		times.add(time1);
		times.add(time2);
		rodada.setJogos(jogos);
		
	}
}
