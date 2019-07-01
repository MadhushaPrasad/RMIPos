/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author madhusha
 */
public interface Subject extends Remote{
    public void addObserver(Observer ob)throws RemoteException;
    public void removeObserver(Observer ob)throws RemoteException;
    public void notifyALLObservers(Observer ob)throws RemoteException;
}
