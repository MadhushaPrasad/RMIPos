/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;

/**
 *
 * @author madhusha
 */
public class DBConnection {
    private static DBConnection dBConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://localhost/3306/pos1", "root", "1234");
    }
    public static DBConnection getDBConnection() throws ClassNotFoundException, SQLException{
        if(dBConnection == null){
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    
}
