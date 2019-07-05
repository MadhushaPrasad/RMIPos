/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.CustomerDAO;
import entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author madhusha
 */
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean add(Customer c) throws ClassNotFoundException, SQLException, Exception {
        return CrudUtill.executeUpate("INSERT INTO customer WHERE CustomerID=?,CustomerName=?,Age=?,Address=?", c.getCustomerID(),c.getCustomerName(),c.getAge(),c.getAddress());
    }

    @Override
    public boolean update(Customer c) throws ClassNotFoundException, SQLException, Exception {
       return CrudUtill.executeUpate("UPDATE customer SET CustomerID=?,CustomerName=?,Age=?,Address=?", c.getCustomerID(),c.getCustomerName(),c.getAge(),c.getAddress());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException, Exception {
        return CrudUtill.executeUpate("DELETE form customer where CustomerID=?", id);
    }

    @Override
    public Customer search(String id) throws ClassNotFoundException, SQLException, Exception {
        ResultSet rst = CrudUtill.executeQuary("SELECT * FROM customer WHERE CustomerID=?", id);
         Customer customer  = null;
        while(rst.next()){
            customer = new Customer();
            customer.setCustomerID(rst.getString(1));
            customer.setCustomerName(rst.getString(2));
            customer.setAddress(rst.getString(4));
            customer.setAge(rst.getInt(3));
        }
        return customer;
    }

    @Override
    public ArrayList<Customer> getAll() throws ClassNotFoundException, SQLException, Exception {
        ResultSet rst = CrudUtill.executeQuary("SELECT * FROM customer");
        ArrayList<Customer> allCustomer = new ArrayList<>();
        while (rst.next()) {            
            Customer cust = new Customer(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4));
            allCustomer.add(cust);
        }
        return allCustomer;
    }
    
}
