package br.ufc.cliente;

import java.io.StringReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import br.ufc.constantes.Constantes;
import br.ufc.model.Jogador;
import br.ufc.model.Mensagem;
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
	public void enviarPalpite() {
		
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
	public List<Jogador> rankingJogadores() {
		return null;
	}
	public List<Jogador> resultadoPreliminar() {
		return null;
	}
	public String doOperation(String objectRef, String method, Object args) {
		String str = empacotaMensagem(objectRef, method, args);
		System.out.println("I" + str);
		cliente.sendRequest(str);
		String st = cliente.getResponse();
		System.out.println("O" + st);
		Mensagem msg = desempacotaMensagem(st);
		
		return (String) msg.getArgumentos();
	}	
	private String empacotaMensagem(String objectRef, String method, Object args) {
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
