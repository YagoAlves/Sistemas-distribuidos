package br.ufc.servidor;

import java.io.StringReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import br.ufc.model.Jogador;
import br.ufc.model.Mensagem;
import br.ufc.model.Palpite;
import br.ufc.model.Rodada;
import br.ufc.servico.ServicoBolao;

public class ServidorEsqueleto {
	ServicoBolao bolao;
	
	public ServidorEsqueleto() {
		bolao = new ServicoBolao();
	}
	
	public String jogosDaRodada(String args) {
		Gson gson = new Gson();
		String strRodada = gson.toJson(bolao.jogosDaRodada());
		return strRodada;
	}
	public String enviarPalpites(String args) {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(args));
		reader.setLenient(true);
		Palpite palpite = gson.fromJson(reader, Palpite.class);
		String strPalpite = gson.toJson(bolao.enviarPalpite(palpite));
		return strPalpite;
	}
	public String rankingJogadores(String args) {
		Gson gson = new Gson();
		String strJogadores = gson.toJson(bolao.rankingJogadores());	
		return strJogadores;
	}
	public String resultadoPreliminar(String args) {
		Gson gson = new Gson();
		String strJogadores = gson.toJson(bolao.resultadoPreliminar());	
		return strJogadores;
	}
	public String login(String args) {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(args));
		reader.setLenient(true);
		Jogador jogador = gson.fromJson(reader, Jogador.class);
		String strJogador = gson.toJson(bolao.login(jogador));
		return strJogador;
	}
	public String cadastrarJogador(String args) {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(args));
		reader.setLenient(true);
		Jogador jogador = gson.fromJson(reader, Jogador.class);
		String strJogador = gson.toJson(bolao.cadastrarJogador(jogador));
		return strJogador;	
	}
	
}
