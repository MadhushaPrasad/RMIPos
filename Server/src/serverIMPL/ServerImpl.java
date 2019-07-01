/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverIMPL;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observer;
import service.ServiceInterFace;

/**
 *
 * @author madhusha
 */
public class ServerImpl extends UnicastRemoteObject implements ServiceInterFace {

    private static ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public String check(String message) throws RemoteException {
        System.out.println(message);
        notifyALLObservers(message);
        return message;

    }

    @Override
    public void addObserver(Observer ob) throws RemoteException {
        observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) throws RemoteException {
        observers.remove(ob);
    }

    @Override
    public void notifyALLObservers(String message) throws RemoteException {
        for (Observer observer : observers) {
            new Thread(
                    new Runnable() {
                @Override
                public void run() {
                    try {
                        observer.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ServerImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            ).start();
        }
    }

}
