/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author madhusha
 */
public interface CrudDAO<C , ID> extends SuperDAO{
    public boolean add(C c)throws ClassNotFoundException,SQLException,Exception;
    public boolean update(C c)throws ClassNotFoundException,SQLException,Exception;
    public boolean delete(ID id)throws ClassNotFoundException,SQLException,Exception;
    public C search(ID id)throws ClassNotFoundException,SQLException,Exception;
    public ArrayList<C> getAll()throws ClassNotFoundException,SQLException,Exception;
}
