package br.ufc.servico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import br.ufc.model.Jogador;
import br.ufc.model.Rodada;
import br.ufc.model.Teste;

public class ServicoBolao {
	public Jogador login(Jogador jogador) {
		return null;
	}	
	public Jogador cadastrarJogador(Jogador jogador) {
		return null;
	}
	public Rodada jogosDaRodada() {
		return null;
		//return teste.rodada;
	}
	public void enviarPalpite() {

	}
	public List<Jogador> rankingJogadores() {
		return null;
	}
	public List<Jogador> resultadoPreliminar() {
		return null;
	}

	private static String lerArquivo(String path) throws IOException {
		Path caminho = Paths.get(path);
		byte[] arquivo = Files.readAllBytes(caminho);
		String linha = new String(arquivo);
		return linha;
	}

	private static void escreverArquivo(String path,String txt) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		buffWrite.write(txt);
		buffWrite.close();
		System.out.println(path);
	}
	/*public static void main(String[] args) {
		Teste teste = new Teste();
		teste.inicio();
		Gson gson = new Gson();
		String path = System.getProperty("user.dir");
		String texto = null;
		try {
			texto = lerArquivo(path+"/resource/rodada.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Rodada rodada = gson.fromJson(texto.toString(), Rodada.class);
		System.out.println(rodada.toString());
		String popular = gson.toJson(teste.rodada);
		
		System.out.println(popular);
		try {
			escreverArquivo(path+"/resource/rodada.txt",popular);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
