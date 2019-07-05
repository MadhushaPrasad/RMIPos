/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import service.ServiceInterFace;



/**
 *
 * @author madhusha
 */
public class Connect {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        ServiceInterFace lookup = (ServiceInterFace) Naming.lookup("rmi://localhost:5050/POS");
        System.out.println("Hello Im Client");
    } 
}