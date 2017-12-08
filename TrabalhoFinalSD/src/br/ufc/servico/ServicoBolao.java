package br.ufc.servico;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import br.ufc.model.Jogador;
import br.ufc.model.Palpite;
import br.ufc.model.Rodada;
import br.ufc.model.Teste;

public class ServicoBolao {
	
	public Jogador login(Jogador jogador) {
		String path = System.getProperty("user.dir");
		String jogadoresBanco = null;		
		Gson gson = new Gson();
		try {
			jogadoresBanco = lerArquivo(path+"/resource/jogadores.txt");
			if(jogadoresBanco.length() == 0) {				
				return null;
			}
			else {
				JsonReader reader = new JsonReader(new StringReader(jogadoresBanco));
				reader.setLenient(true);			
				Jogador[] jogadoresVetor = gson.fromJson(reader, Jogador[].class);
				for (int i = 0; i < jogadoresVetor.length; i++) {
					if(jogador.getNome().equals(jogadoresVetor[i].getNome()) &&
							jogador.getSenha().equals(jogadoresVetor[i].getSenha())) {
						return jogadoresVetor[i];
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;	
	}	
	
	public Jogador cadastrarJogador(Jogador jogador) {
		String path = System.getProperty("user.dir");
		String jogadoresBanco = null;
		String jsonJogadores = null;
		Gson gson = new Gson();
		List<Jogador> jogadores = new ArrayList<Jogador>();
		try {
			jogadoresBanco = lerArquivo(path+"/resource/jogadores.txt");
			if(jogadoresBanco.length() == 0) {				
				
				jogadores.add(jogador);
				jsonJogadores = gson.toJson(jogadores);
			}
			else {
				JsonReader reader = new JsonReader(new StringReader(jogadoresBanco));
				reader.setLenient(true);			
				Jogador[] jogadoresVetor = gson.fromJson(reader, Jogador[].class);
				jogadores = vetorToArray(jogadoresVetor);
				jogadores.add(jogador);
				jsonJogadores = gson.toJson(jogadores);
			}
			escreverArquivo(path+"/resource/jogadores.txt", jsonJogadores);
			return jogador;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public Rodada jogosDaRodada() {
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
		
		return rodada;
		
	}
	
	public Palpite enviarPalpite(Palpite palpite) {
		String path = System.getProperty("user.dir");
		String palpitesBanco = null;
		String jsonPalpites = null;
		Gson gson = new Gson();
		List<Palpite> palpites = new ArrayList<Palpite>();
		try {
			palpitesBanco = lerArquivo(path+"/resource/palpites.txt");
			if(palpitesBanco.length() == 0) {				
				
				palpites.add(palpite);
				jsonPalpites = gson.toJson(palpites);

			}
			else {
				JsonReader reader = new JsonReader(new StringReader(palpitesBanco));
				reader.setLenient(true);			
				
				Palpite[] jogadoresVetor = gson.fromJson(reader, Palpite[].class);
				palpites = vetorToArray(jogadoresVetor);
				palpites.add(palpite);
				jsonPalpites = gson.toJson(palpites);
			}
			
			escreverArquivo(path+"/resource/palpites.txt", jsonPalpites);
			
			return palpite;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
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
	}
	public static void main(String[] args) {
		/*ServicoBolao bolao = new ServicoBolao();
		Jogador j = bolao.login(new Jogador("Afonso", "1234"));
		System.out.println(j.getNome()+" " + j.getSenha());
		*/
		/*Teste teste = new Teste();
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
		}*/
	}
	private List<Jogador> vetorToArray(Jogador[] j) {
		List<Jogador> list = new ArrayList<Jogador>();
		for (int i = 0; i < j.length; i++) {
			list.add(j[i]);
		}
		return list;
	}
	private List<Palpite> vetorToArray(Palpite[] p) {
		List<Palpite> list = new ArrayList<Palpite>();
		for (int i = 0; i < p.length; i++) {
			list.add(p[i]);
		}
		return list;
	}

}
