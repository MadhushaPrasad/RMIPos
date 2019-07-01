/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import serverIMPL.ServerImpl;

/**
 *
 * @author madhusha
 */
public class ServerMain {

    public static void main(String[] args) throws RemoteException {
        try {
            Registry createRegistry = LocateRegistry.createRegistry(5050);
            createRegistry.rebind("POS", new ServerImpl());
        } catch (Exception ex) {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Server Start");
    }
}
