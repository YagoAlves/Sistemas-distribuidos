package br.ufc.cliente;

import java.util.Scanner;

public class ClienteView {
	ClienteProxy proxy = new ClienteProxy();
	private static int menu() {
		int opcao = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite 1 para Jogos da Rodada \n"
				+ "2 para Ranking dos Jogadores"
				+ "3 para resultados preliminares");
		try {
			opcao = scanner.nextInt();
		} catch (Exception e) {
			System.err.println("ERRO!");
			e.printStackTrace();
		}
		System.out.print("Você digitou: " + opcao);
		return opcao;
	}
	public static void main(String[] args) {
		menu();
	}
}
