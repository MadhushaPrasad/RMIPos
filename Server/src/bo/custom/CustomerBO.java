/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author madhusha
 */
public interface CustomerBO extends SuperBO {

    public boolean addCustomer(CustomerDTO c) throws ClassNotFoundException, SQLException, Exception;

    public boolean updateCustomer(CustomerDTO c) throws ClassNotFoundException, SQLException, Exception;

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception;

    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<CustomerDTO> getALLCustomer() throws ClassNotFoundException, SQLException, Exception;
}
