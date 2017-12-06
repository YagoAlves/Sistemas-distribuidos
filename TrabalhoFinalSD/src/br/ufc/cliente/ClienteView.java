package br.ufc.cliente;

import java.util.Scanner;

public class ClienteView {

	private static void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite seu nome");
		String nome = scanner.nextLine();
		System.out.println("Digite sua senha");
		String senha = scanner.nextLine();
		
	}
	private static int menu() {
		ClienteProxy proxy = new ClienteProxy();
		int opcao = 0;
		Scanner scanner = new Scanner(System.in);
		String menu = "1 para Login\n"
				+ "2 para cadastro\n"
				+ "3 para sair\n";
		String subMenu = "Digite 1 para Jogos da Rodada \n"
				+ "2 para Ranking dos Jogadores\n"
				+ "3 para resultados preliminares\n";
		System.out.print(menu);
		try {
			String jogos = null;
			opcao = scanner.nextInt();
			switch (opcao) {
				case 1:	login();break;
				//case 1:	jogos = proxy.jogosDaRodada().toString();break;
				default: 
					break;
			}
			System.out.println(jogos);
		} catch (Exception e) {
			System.err.println("ERRO!");
			e.printStackTrace();
		}
		return opcao;
	}
	public static void main(String[] args) {
		menu();
	}
}
