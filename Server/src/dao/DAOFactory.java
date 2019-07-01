/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.custom.impl.CustomerDAOImpl;

/**
 *
 * @author madhusha
 */
public class DAOFactory {
    private static DAOFactory dAOFactory;

    private DAOFactory() {
    }
    
    public static DAOFactory getInstance(){
        if(dAOFactory == null){
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }
    
    public enum getType{
        CUSTOMER
    }
    
    public SuperDAO getDAOType(getType types){
        switch(types){
            case CUSTOMER:
                new CustomerDAOImpl();
                default:
                    return null;
        }
    }
    
    
    
}
