package co.vinni.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinni
 */
public class ClienteTCP {
    public void iniciar()
    {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            Socket socket = new Socket(addr, 12345);
            System.out.println("SOCKET = " + socket);
            BufferedReader in =
                new BufferedReader(
                new InputStreamReader(
                socket.getInputStream()));

            PrintWriter out =
                new PrintWriter(
                new BufferedWriter(
                new OutputStreamWriter(
                socket.getOutputStream())), true);

            DataInputStream myinput =
                new DataInputStream(
                new BufferedInputStream(System.in));

            for (;;) {
                System.out.println("DIGITE EL MENSAJE Y PULSE  RETURN, O  T PARA TERMINAR.");
                String strin = myinput.readLine();
                
                if (strin.toUpperCase().equals("T")) {
                    break;
                } else {
                    out.println(strin);
                }          
                String strout = in.readLine();      
                if (strin.length() == strout.length()) {  
                    System.out.println("DATO OK");
                    System.out.println("RECIBIO: " + strout);
                } else {
                    System.out.println("DATO ERRONEO" + strout);
                }
            }
            socket.close();
            System.out.println("CLIENTE TRERMINADO " );
        } catch (IOException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    public static void main(String[] args) {
        ClienteTCP cli = new ClienteTCP();
        cli.iniciar();
    }
}
