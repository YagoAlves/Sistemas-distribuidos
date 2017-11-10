package br.ufc.calc;
import java.net.*;
import java.io.*;
public class UDPClient{
	public static void main(String args[]){ 
	// args give message contents and server hostname
	DatagramSocket aSocket = null;
	String m1 = "Multiplicacao;3;5";
	try {
			
			aSocket = new DatagramSocket();    
			byte [] m = m1.getBytes();
			
			InetAddress aHost = InetAddress.getByName(args[1]);
			int serverPort = 6789;		                                                 
			DatagramPacket request = new DatagramPacket(m,  m.length, aHost, serverPort);
			aSocket.send(request);
			aSocket.setSoTimeout(100);
			
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
			
			try {
				aSocket.receive(reply);
			} catch (SocketTimeoutException e) {
				request = new DatagramPacket(m,  m1.length(), aHost, serverPort);
				aSocket.send(request);
				aSocket.setSoTimeout(100);
				System.out.println("enviando");
			
			}
			
			
			System.out.println("Reply: " + new String(reply.getData()));	
		} catch (SocketException e){
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e){
			System.out.println("IO: " + e.getMessage());
		} finally {
			if(aSocket != null) {
				aSocket.close();
			}
		}
	} 
}