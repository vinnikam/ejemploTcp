
package co.vinni.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Vinni
 */
public class ServidorTCP {
    private final int PORT = 12345;    
    
    public ServidorTCP() {
        try {
            ServerSocket s = new ServerSocket(PORT);
            InetAddress addrs = InetAddress.getLocalHost();
            System.out.println("Servidor TCP en ejecución: " + addrs + " ,Puerto " + s.getLocalPort());
            while (true) {
                
                Socket socket = s.accept();
                try {
                    new EscucharServidor(socket);  
                } catch (IOException e) {
                    
                    socket.close();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
}
class EscucharServidor extends Thread {

  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;

  public EscucharServidor (Socket s) 
      throws IOException {
    socket = s;
    System.out.println("CONECTO A : "+socket); 
    in = 
      new BufferedReader(
        new InputStreamReader(
          socket.getInputStream()));

    out = 
      new PrintWriter(
        new BufferedWriter(
          new OutputStreamWriter(
            socket.getOutputStream())), true);
    
    start(); 
  }
    public void run() {
	try {
	while (true)
	{  
             System.out.println("....Servidor en funcionamiento...");
	     String str = in.readLine();
	     if (str== null ) break;  
	     System.out.println("MENSAJE RECIBIDO / Rx: " + str);
	     System.out.println("DE: "+ socket);
	     
	     out.println(str);
	}
	System.out.println("DISCONECTO EL USUARIO .."+socket);
	} catch (IOException e) {
	} finally {
	    try {
                socket.close();
	    } catch(IOException e) {}
	}
    }


    public static void main(String[] args) {
        ServidorTCP ser = new ServidorTCP();
        
    }
}


