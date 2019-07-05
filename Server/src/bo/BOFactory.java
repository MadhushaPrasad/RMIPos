/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import bo.custom.impl.CustomerBOImpl;

/**
 *
 * @author madhusha
 */
public class BOFactory {

    private static BOFactory bOFactory;

    private BOFactory() {
    }

    private static BOFactory getInstance() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public enum BOType {
        CUSTOMER
    }

    public SuperBO getBOType(BOType types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl();
            default:
                return null;
        }
    }

}
