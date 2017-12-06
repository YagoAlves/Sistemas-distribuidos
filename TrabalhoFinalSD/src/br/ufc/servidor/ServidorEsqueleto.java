package br.ufc.servidor;

import java.io.StringReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import br.ufc.model.Jogador;
import br.ufc.model.Mensagem;
import br.ufc.model.Rodada;
import br.ufc.servico.ServicoBolao;

public class ServidorEsqueleto {
	ServicoBolao bolao;
	
	public ServidorEsqueleto() {
		bolao = new ServicoBolao();
	}
	
	public String jogosDaRodada(String args) {
		Gson gson = new Gson();
		//JsonReader reader = new JsonReader(new StringReader(args));
		//reader.setLenient(true);
		//Rodada rodada = gson.fromJson(reader, Rodada.class);
		String strRodada = gson.toJson(bolao.jogosDaRodada());
		return strRodada;
	}
	public String enviarPalpite(String args) {
		return null;
	}
	public String rankingJogadores(String args) {
		return null;
	}
	public String resultadoPreliminar(String args) {
		return null;
	}
	public String login(String args) {
		return null;
	}
	public String cadastrarJogador(String args) {
		return null;
	}
}
