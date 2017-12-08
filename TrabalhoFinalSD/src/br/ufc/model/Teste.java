package br.ufc.model;

import java.util.ArrayList;
import java.util.List;

public class Teste {
	public Jogador jogador1 = new Jogador("Afonso", "1234");
	public Jogador jogador2 = new Jogador("Yago","teste");
	public Jogador jogador3 = new Jogador("Teste","12");
	public Jogo jogo = new Jogo();
	public Rodada rodada = new Rodada();
	public Time time1 = new Time();
	public Time time2 = new Time();
	
	public void inicio() {
		
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
