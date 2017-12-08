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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import br.ufc.model.Jogador;
import br.ufc.model.Jogo;
import br.ufc.model.Palpite;
import br.ufc.model.Rodada;
import br.ufc.model.Teste;
import br.ufc.model.Time;

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
		Rodada[] rodada = gson.fromJson(texto.toString(), Rodada[].class);
		List<Rodada> list = vetorToArray(rodada);
		Date dataAtua = new Date(System.currentTimeMillis());
		Calendar c = new GregorianCalendar(2017,11,7);
		for (Rodada rodada2 : list) {
			System.out.println("ini "+ rodada2.getDataIni() +" " + c.getTime() + " fim " + rodada2.getDataFim());
			if(rodada2.getDataIni().before(c.getTime()) && rodada2.getDataFim().after(c.getTime())) {
				return rodada2;
			}
		}
		return null;
		
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
	
	public int resultadoPreliminar() {
		return 0;
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
		//povoaBanco();
		ServicoBolao serv = new ServicoBolao();
		Rodada r = new Rodada();
		r= serv.jogosDaRodada();
		System.out.println(r);
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

	private List<Rodada> vetorToArray(Rodada[] p) {
		List<Rodada> list = new ArrayList<Rodada>();
		for (int i = 0; i < p.length; i++) {
			list.add(p[i]);
		}
		return list;
	}

	private static void povoaBanco() {
		//CRIAR TIMES
		Gson gson = new Gson();
		String[] times = new String[] {"Atlético","Avaí","Bahia","Botafogo","Chapecoense"};
		List<Time> list = new ArrayList<Time>();
		for (int i = 0; i < times.length; i++) {
			list.add(new Time(i, times[i]));
		}
		String path = System.getProperty("user.dir");
		String txt = gson.toJson(list);
		
		
		//CRIAR JOGOS
		
		List<Jogo> jogos = new ArrayList<Jogo>();
		for (int i = 0; i < times.length - 1; i++) {
			for (int j = 0; j < times.length; j++) {
				if (i != j) {
					jogos.add(new Jogo(i,list.get(i),list.get(j)));
				}				
			}
		}
		
		//CRIAR RODADA
		
		List<Rodada> rodadaList = new ArrayList<Rodada>();
		int cont = 0;
		int diaRef = 1;
		while(cont <= 3) {
			List<Jogo> jogosDaRodada = new ArrayList<Jogo>();
			for (int i = cont; i < times.length; i = i + 3) {
				jogosDaRodada.add(jogos.get(i));
			}
			Rodada rodada = new Rodada();
			rodada.setId(cont);
			rodada.setJogos(jogosDaRodada);
			Calendar c = new GregorianCalendar(2017,11,diaRef);
			
			rodada.setDataIni(c.getTime());
			
			c.add(Calendar.DAY_OF_MONTH, 2);
			rodada.setDataFim(c.getTime());
			diaRef = diaRef + 5;
			rodadaList.add(rodada);
			cont++;
		}
		
		
		txt = gson.toJson(rodadaList);
		

		try {
			//escreverArquivo(path+"/resource/time.txt", txt);
			//escreverArquivo(path+"/resource/jogo.txt", txt);
			escreverArquivo(path+"/resource/rodada.txt", txt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
