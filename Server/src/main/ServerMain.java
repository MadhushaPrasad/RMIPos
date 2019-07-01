/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import serverIMPL.ServerImpl;

/**
 *
 * @author madhusha
 */
public class ServerMain {
    public static void main(String[] args) throws RemoteException {
        Registry createRegistry = LocateRegistry.createRegistry(5050);
        createRegistry.rebind("POS1", new ServerImpl());
        System.out.println("Server Start");
    }
}
