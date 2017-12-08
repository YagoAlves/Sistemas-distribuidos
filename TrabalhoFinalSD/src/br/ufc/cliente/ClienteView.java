package br.ufc.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.ufc.model.Jogador;
import br.ufc.model.Jogo;
import br.ufc.model.Palpite;
import br.ufc.model.Rodada;

public class ClienteView {

	private ClienteProxy proxy;
	
	public ClienteView() {
		proxy = new ClienteProxy();
	}
	private Jogador login() {		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite seu nome");
		String nome = scanner.nextLine();
		System.out.println("Digite sua senha");
		String senha = scanner.nextLine();
		Jogador j = proxy.login(new Jogador(nome, senha));
		return j != null ? j : null;
	}
	private Jogador cadastrar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite seu nome");
		String nome = scanner.nextLine();
		System.out.println("Digite sua senha");
		String senha = scanner.nextLine();		
		Jogador j = proxy.cadastrarJogador(new Jogador(nome,senha));
		return j != null ? j : null; 
	}
	private int menu() {
		
		int opcao = 0;
		Scanner scanner = new Scanner(System.in);
		String menu = "1 para Login\n"
				+ "2 para cadastro\n"
				+ "3 para sair\n";
		System.out.print(menu);
		try {		
			opcao = scanner.nextInt();
			if(opcao == 3) System.exit(1);
		} catch (Exception e) {
			System.err.println("ERRO!");
			e.printStackTrace();
		}
		return opcao;
	}
	public int subMenu() {
		int opcao = 0;
		Scanner scanner = new Scanner(System.in);
		String subMenu = "1 para Jogos da Rodada \n"
				+ "2 para Ranking dos Jogadores\n"
				+ "3 para resultados preliminares\n"
				+ "5 para sair\n";
		System.out.print(subMenu);
		try {			
			opcao = scanner.nextInt();
		} catch (Exception e) {
			System.err.println("ERRO!");
			e.printStackTrace();
		}
		return opcao;
	}
	
	public Rodada mostrarRodada(Jogador j) {
		Rodada rodada = new Rodada();
		rodada = proxy.jogosDaRodada();
		if(rodada != null) {
			List<Jogo> jogosDaRodada = rodada.getJogos();
			for (Jogo jogo : jogosDaRodada) {
				System.out.println(jogo.getTime1().getNome() + " x " + jogo.getTime2().getNome());
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("1 para fazer uma aposta\n"
					+ "2 para voltar");
			int op = scanner.nextInt();
			if (op == 1) {
				fazerAposta(rodada, j);
			}
		}
		return rodada;
	}
	
	public void fazerAposta(Rodada rodada, Jogador jogador) {
		System.out.println("Escolha o time vencedor ou empate\n");
		List<Jogo> jogos = rodada.getJogos();
		Palpite palpite = new Palpite();
		palpite.setRodada(rodada.getId());
		palpite.setJogador(jogador);
		Scanner scanner = new Scanner(System.in);
		String resultado = "";
		List<String> list = new ArrayList<String>();
		for (Jogo jogo : jogos) {
			System.out.println(jogo.getTime1().getNome() + "x" + jogo.getTime2().getNome() +"\n");
			resultado = scanner.next();			
			list.add( resultado);
		}
		palpite.setPalpite(list);
		proxy.enviarPalpite(palpite);
	}
	
	public void rankingJogadores() {
		List<Jogador> jogadores = proxy.rankingJogadores();
		if(jogadores == null) return;
		for (Jogador jogador : jogadores) {
			System.out.println("Nome " + jogador.getNome() + " Quantidade de acertos "+ jogador.getAcertos());
		}
	}
	public void resultadoPreliminar() {
		List<Jogador> jogadores = proxy.resultadoPreliminar();
		if(jogadores == null) return;
		for (Jogador jogador : jogadores) {
			System.out.println("Nome " + jogador.getNome() + " Quantidade de acertos ate o momento "+ jogador.getParcial());
		}
	}
	
	public static void main(String[] args) {
		ClienteView view = new ClienteView();
		int op = -1;
		Jogador jogador;
		op = view.menu();
		jogador = op == 1 ? view.login(): view.cadastrar();
		if(jogador != null) {
			while (true) {
				op = view.subMenu();
				switch (op) {
				case 1: 
					view.mostrarRodada(jogador);
					break;
				case 2:
					view.rankingJogadores();
					break; 
				case 3:
					view.resultadoPreliminar();
					break;
				default: System.exit(1);
					break;
				}
			}
		}
		System.err.println("ERRO");
	}	
}
