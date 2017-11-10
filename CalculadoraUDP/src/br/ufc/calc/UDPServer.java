package br.ufc.calc;
import java.net.*;
import java.io.*;
public class UDPServer{
	public static void main(String args[]){ 
		DatagramSocket aSocket = null;
	    try{
	    	aSocket = new DatagramSocket(6789);
	    	byte[] buffer = new byte[1000];
	    	
	 		while(true){
	 			int count = 0;
	 			DatagramPacket request = new DatagramPacket(buffer, buffer.length);
 				aSocket.receive(request);
 				Calculadora calc = new Calculadora();
 				String a = new String (request.getData());
 				System.out.println(a);
 				String resul = calc.calcula(a);	
 				DatagramPacket reply = new DatagramPacket(resul.getBytes(), 
			   	resul.length(), request.getAddress(), request.getPort());
 				if (count % 2 == 0) {
 					aSocket.send(reply);
 				}
			}
	    } catch (SocketException e) {
	    	System.out.println("Socket: " + e.getMessage());
	    } catch (IOException e) {
	    	System.out.println("IO: " + e.getMessage());
		} finally {
			if(aSocket != null) {
				aSocket.close();
			}
		}
    }
}