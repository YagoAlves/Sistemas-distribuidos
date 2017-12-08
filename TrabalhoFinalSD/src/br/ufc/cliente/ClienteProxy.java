package br.ufc.cliente;

import java.io.StringReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import br.ufc.constantes.Constantes;
import br.ufc.model.Jogador;
import br.ufc.model.Mensagem;
import br.ufc.model.Palpite;
import br.ufc.model.Rodada;

public class ClienteProxy {
	ClienteUDP cliente = new ClienteUDP(Constantes.IP,Constantes.PORTA);
	int idRequest = 0;
	
	public Rodada jogosDaRodada() {
		Gson gson = new Gson(); 
		Rodada rodada = new Rodada();
		String jsonRodada = gson.toJson(rodada);
		String msg = doOperation("ServidorEsqueleto", "jogosDaRodada", jsonRodada);
		
		JsonReader reader = new JsonReader(new StringReader(msg));
		reader.setLenient(true);
		rodada = (Rodada) gson.fromJson(reader, Rodada.class);
		return rodada;
	}
	public Palpite enviarPalpite(Palpite palpite) {
		Gson gson = new Gson(); 
		String jsonPalpite = gson.toJson(palpite);
		String msg = doOperation("ServidorEsqueleto", "enviarPalpites", jsonPalpite);
		
		JsonReader reader = new JsonReader(new StringReader(msg));
		reader.setLenient(true);
		palpite = (Palpite) gson.fromJson(reader, Palpite.class);
		return palpite;
		
	}
	
	public Jogador login(Jogador jogador) {
		Gson gson = new Gson(); 
		String jsonJogadores = gson.toJson(jogador);
		
		String login = doOperation("ServidorEsqueleto", "login", jsonJogadores);
		JsonReader reader = new JsonReader(new StringReader(login));
		reader.setLenient(true);
		jogador = (Jogador) gson.fromJson(reader, Jogador.class);
		return jogador;
	}
	public Jogador cadastrarJogador(Jogador jogador) {
		Gson gson = new Gson(); 
		String jsonJogadores = gson.toJson(jogador);
		String login = doOperation("ServidorEsqueleto", "cadastrarJogador", jsonJogadores);
		JsonReader reader = new JsonReader(new StringReader(login));
		reader.setLenient(true);
		jogador = (Jogador) gson.fromJson(reader, Jogador.class);
		return jogador;
	}
	
	public List<Jogador> rankingJogadores() {
		return null;
	}
	public List<Jogador> resultadoPreliminar() {
		return null;
	}
	
	public String doOperation(String objectRef, String method, String args) {
		String str = empacotaMensagem(objectRef, method, args);		
		cliente.sendRequest(str);
		String st = cliente.getResponse();
		Mensagem msg = desempacotaMensagem(st);
		
		return (String) msg.getArgumentos();
	}	
	private String empacotaMensagem(String objectRef, String method, String args) {
		Gson gson = new Gson();
		Mensagem msg = new Mensagem();
		msg.setMessageType(idRequest);
		msg.setMetodo(method);
		msg.setArgumentos(args);
		msg.setObjReference(objectRef);
		String str = gson.toJson(msg);
		return str;
	}
	private Mensagem desempacotaMensagem(String resposta) {	
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(resposta));
		reader.setLenient(true);
		Mensagem msg = gson.fromJson(reader, Mensagem.class);
		return msg;
	}
	public void finaliza() {
		cliente.close();
	}
}
