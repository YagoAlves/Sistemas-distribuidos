package ufc.br.sd;
import java.net.*;
import java.io.*;
public class TCPClient {
	
	public static void main (String args[]) throws InterruptedException {
	// arguments supply message and hostname of destination
	
	
	long start = System.currentTimeMillis();
	
	for (int i = 0; i < 200; i++) {
		
		ThreadTestaServidor t = new ThreadTestaServidor();
		t.start();
		}
	
	long elapsed = System.currentTimeMillis() - start;
	System.out.println("Tempo total : " + elapsed/1000);
	}
	

}
