package ufc.br.sd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadTestaServidor extends Thread {
	
	
	public void run() {
		
		Socket s = null;
	    try{
	    	int serverPort = 7896;
		   	s = new Socket("localhost", serverPort);
		   	DataInputStream in = new DataInputStream( s.getInputStream());
			DataOutputStream out =
				new DataOutputStream( s.getOutputStream());
			out.writeUTF("Multiplicacao,1,2");        	// UTF is a string encoding see Sn 4.3
			String data = in.readUTF();	      
		//	System.out.println("Received: "+ data);      
	    } catch (UnknownHostException e){System.out.println("Sock:"+e.getMessage()); 
	    } catch (EOFException e){ System.out.println("EOF:"+e.getMessage());
	    } catch (IOException e){ System.out.println("IO:"+e.getMessage());
		} finally { if(s!=null) { try { s.close(); } catch (IOException e){System.out.println("close:"+e.getMessage()); } }
		}
  	}	
	

}
