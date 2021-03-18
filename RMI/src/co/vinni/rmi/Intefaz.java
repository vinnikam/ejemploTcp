/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Vinni
 */
public interface Intefaz extends Remote{
    public int sumar(int numero1, int numero2) throws RemoteException;
    public int restar(int numero1, int numero2) throws RemoteException;
    
}
