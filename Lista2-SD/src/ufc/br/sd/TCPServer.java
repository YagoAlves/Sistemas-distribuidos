package ufc.br.sd;
import java.net.*;
import java.io.*;
public class TCPServer {
	
	//Calculadora calc = new Calculadora();
    public static void main (String args[]) throws InterruptedException {
	try{
		int serverPort = 7896; 
		ServerSocket listenSocket = new ServerSocket(serverPort);
		while(true) {
			Socket clientSocket = listenSocket.accept();
			Connection c = new Connection(clientSocket);
		}	
	} catch(IOException e) {System.out.println("Listen :"+e.getMessage());}
    }
}

class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	public Connection (Socket aClientSocket) throws InterruptedException {
	    try {
			clientSocket = aClientSocket;
			in = new DataInputStream( clientSocket.getInputStream());
			out =new DataOutputStream( clientSocket.getOutputStream());
			this.start();
			this.sleep(100);
	     } catch(IOException e)  {System.out.println("Connection:"+e.getMessage());}
	}
	public void run(){
	    try {			                 // an echo server
	    	String data = in.readUTF();	 
	    	Calculadora calc = new Calculadora();
	    	String resultado = calc.calcula(data);
	    	out.writeUTF(resultado);
	    	//System.out.println(resultado);
	    } catch(EOFException e) {System.out.println("EOF:"+e.getMessage());
	    } catch(IOException e) {System.out.println("IO:"+e.getMessage());
	    } finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
	}
}