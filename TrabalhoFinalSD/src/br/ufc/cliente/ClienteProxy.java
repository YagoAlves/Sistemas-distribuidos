package br.ufc.cliente;

import java.util.List;

import br.ufc.constantes.Constantes;
import br.ufc.model.Jogador;
import br.ufc.model.Rodada;

public class ClienteProxy {
	ClienteUDP cliente = new ClienteUDP(Constantes.IP,Constantes.PORTA);
	
	public Rodada jogosDaRodada() {
		return null;
	}
	public void enviarPalpite() {
		
	}
	public List<Jogador> rankingJogadores() {
		return null;
	}
	public List<Jogador> resultadoPreliminar() {
		return null;
	}
	public String doOperation(String objectRef, String method, byte[] args) {
		return null;
	}
	private String empacotaMensagem(String objectRef, String method, byte[] args) {
		return null;
	}
	private String desempacotaMensagem(byte[] resposta) {	
		return null;
	}
	public void finaliza() {
		cliente.close();
	}
}
