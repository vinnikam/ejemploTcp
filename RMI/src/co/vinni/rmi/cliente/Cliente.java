/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.rmi.cliente;

import co.vinni.rmi.Intefaz;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinni
 */
public class Cliente {
    private String ip = "192.168.1.22";
    private int puerto = 54321;
    
    public void iniciar(){
        try {
            Registry registroCl = LocateRegistry.getRegistry(ip, puerto);
            Intefaz intefaz = (Intefaz) registroCl.lookup("Calculadora");
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingresa numero 1");
            int numero1 = sc.nextInt();
            System.out.println("Ingresa numero 2");
            int numero2 = sc.nextInt();
            
            int rta =  intefaz.sumar(numero1, numero2);
            System.out.println("Recibio respuesta "+rta);
            
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.iniciar();
    }
    
}
