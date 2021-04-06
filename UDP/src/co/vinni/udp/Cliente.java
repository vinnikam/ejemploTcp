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
public class Cliente {
    private final int  puerto = 4000;
    public void iniciar(){
        System.out.println("Inicio de cliente ");
        
        String ip = "127.0.0.1";
        String mensaje = "El servidor no funciona";
        DatagramPacket mensajeDG = MiDatagrama.crearDataG(ip, puerto, mensaje);
        File f = new File("c:\\aca\\","elarchivo.*" );
        try {
            DatagramSocket canal = new DatagramSocket();
            canal.send(mensajeDG);
            System.out.println("Mensaje enviado");
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }
    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.iniciar();
        
    }
    
}
