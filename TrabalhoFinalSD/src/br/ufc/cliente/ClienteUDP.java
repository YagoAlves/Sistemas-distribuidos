package br.ufc.cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class ClienteUDP {
	private DatagramSocket datagramSocket = null;
	private InetAddress host = null;
	private Integer porta;
	public ClienteUDP(String ip, Integer porta) {				
	    try{
	    	this.porta = porta;
	    	datagramSocket = new DatagramSocket();
	    	host = InetAddress.getByName(ip);    	
			
	    } catch (UnknownHostException e) {
	    	System.out.println("Sock:"+e.getMessage()); 
	    } catch (IOException e){ 
	    	System.out.println("IO:"+e.getMessage());
		}

	}
	
	public void sendRequest(String mensagem) {	
		byte [] msg = mensagem.getBytes();
		DatagramPacket reqPacket = new DatagramPacket(msg, msg.length,host,porta);
		try {
			datagramSocket.send(reqPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public String getResponse() {
		byte[] buffer = new byte[1000];
		DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	

		try {
			datagramSocket.setSoTimeout(3000);
			datagramSocket.receive(reply);
			return new String(reply.getData());
		} catch(SocketTimeoutException e) {					
			e.getStackTrace();
			System.out.println("tenta enviar");
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return "FAIL";
	}
	public void close () {
		if(datagramSocket != null) { 
			datagramSocket.close();
		}
	}	
}
