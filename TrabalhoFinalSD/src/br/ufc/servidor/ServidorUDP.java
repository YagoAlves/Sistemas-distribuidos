package br.ufc.servidor;

import java.io.IOException;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import br.ufc.constantes.Constantes;
import br.ufc.model.Mensagem;

public class ServidorUDP {
	DatagramSocket datagramSocket;
	DatagramPacket request;
	public ServidorUDP() {
		try {
			datagramSocket = new DatagramSocket(Constantes.PORTA);
			ServiodorDespachante despachante = new ServiodorDespachante();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getRequest() {
		byte[] msg = new byte[1000];
		request = new DatagramPacket(msg, msg.length);
		try {
			datagramSocket.receive(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String input = new String(msg);		
		return input;
	}
	public void sendResponse(String mensagem) {
		byte[] msgSend = new byte[1000];
		msgSend = mensagem.getBytes();
		DatagramPacket reply = new DatagramPacket(msgSend, 
			   	msgSend.length, request.getAddress(), request.getPort());
		try {
			datagramSocket.send(reply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String empacotaMensagem(int requestId, String resultado) {
		Gson gson = new Gson();
		Mensagem msg = new Mensagem();
		msg.setMessageType(requestId);
		msg.setArgumentos(resultado);
		msg.setObjReference("ServidorEsqueleto");
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
	public static void main(String argv[]) throws Exception {
		ServidorUDP server = new ServidorUDP();
		String resultado;
		while (true) {
			String input = server.getRequest();			
			ServiodorDespachante despachante = new ServiodorDespachante();			
			System.out.println("I" + input);
			Mensagem msg = server.desempacotaMensagem(input);
			resultado  = despachante.invoke(msg);
			System.out.println("R" + resultado);
			String empacotado = server.empacotaMensagem(1, resultado);
			server.sendResponse(empacotado);
		}
			
	}

}
