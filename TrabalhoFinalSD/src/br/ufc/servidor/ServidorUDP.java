package br.ufc.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import br.ufc.constantes.Constantes;

public class ServidorUDP {
	DatagramSocket datagramSocket;
	DatagramPacket request;
	public ServidorUDP() {
		try {
			datagramSocket = new DatagramSocket(Constantes.PORTA);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String argv[]) throws Exception {
		
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
}
