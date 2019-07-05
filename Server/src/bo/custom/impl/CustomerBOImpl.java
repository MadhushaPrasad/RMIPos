/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author madhusha
 */
public class CustomerBOImpl implements CustomerBO{

    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAOType(DAOFactory.getType.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO c) throws ClassNotFoundException, SQLException, Exception {
        return dao.add(new Customer(c.getCustomerID(),c.getCustomerName(),c.getAge(),c.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO c) throws ClassNotFoundException, SQLException, Exception {
          return dao.update(new Customer(c.getCustomerID(),c.getCustomerName(),c.getAge(),c.getAddress()));
    }

    @Override
    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
       return dao.delete(id);
    }
    
    @Override
    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
       Customer searCustomer = dao.search(id);
        return new CustomerDTO(searCustomer.getCustomerID(), searCustomer.getCustomerName(), searCustomer.getAge(), searCustomer.getAddress());
    }

    @Override
    public ArrayList<CustomerDTO> getALLCustomer() throws ClassNotFoundException, SQLException, Exception {
         ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = dao.getAll();
        for (Customer a : all) {
            allCustomers.add(new CustomerDTO(a.getCustomerID(), a.getCustomerName(), a.getAge(), a.getAddress()));
        }
        return allCustomers;
    }
    
}
