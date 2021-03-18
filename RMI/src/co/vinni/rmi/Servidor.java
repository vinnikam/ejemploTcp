/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinni
 */
public class Servidor {

    private int puerto = 54321;

    public void iniciar() throws RemoteException, AlreadyBoundException  {

        Remote remote = UnicastRemoteObject.exportObject(new Intefaz() {
            @Override
            public int sumar(int numero1, int numero2) throws RemoteException {
                return numero1 + numero2;
            };

            @Override
            public int restar(int numero1, int numero2) throws RemoteException {
                return numero1 - numero2;
            }
          
        }, 0);

        Registry registro = LocateRegistry.createRegistry(puerto);
        System.out.println(" Servidor RMI en el puerto "+puerto);
        registro.bind("Calculadora", remote);
    }
    public static void main(String[] args) {
        Servidor srmi = new Servidor();
        try {
            srmi.iniciar();
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
