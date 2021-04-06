/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.udp;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinni
 */
public class Servidor {
    private final int  puerto = 4000;
    
    public void iniciar(){
        System.out.println("Inicio Servidor UDP .. ");
        byte[] buf = new byte[1000];
        DatagramPacket dp = null;
        
        try {
            DatagramSocket socketudp = new DatagramSocket(puerto);
            boolean inicio = true;
            while (inicio){
                System.out.println("Escuchando ");
                dp = new DatagramPacket(buf, buf.length);
                socketudp.receive(dp);
                String elmensaje = new String(dp.getData());
                File f = new File("c:\\acasertvidor\\","elarchivo.*" );
                System.out.println("El mensaje recibido es "+
                        elmensaje);
                
//                if (dp.getData()!= null){
//                    inicio = false;
//                    System.out.println(" Fin");
//                }
                
            }
            
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        Servidor s = new Servidor();
        s.iniciar();
    }
}
