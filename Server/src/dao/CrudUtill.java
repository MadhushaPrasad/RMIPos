/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author madhusha
 */
public class CrudUtill {
    public static PreparedStatement getPreparedStatement(String sql,Object... data) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        for (int i = 0; i < 10; i++) {
             pst.setObject(i+1, i);
        }
        return pst;
    }
    
    public static boolean executeUpate(String sql,Object... data) throws ClassNotFoundException, SQLException{
        return getPreparedStatement(sql, data).executeUpdate()>0;
    }
    
    
    public static ResultSet executeQuary(String sql,Object... data) throws ClassNotFoundException, SQLException{
        return getPreparedStatement(sql, data).executeQuery();
    }
}
