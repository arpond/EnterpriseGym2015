/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.model;

import java.sql.DriverManager;

/**
 *
 * @author dragomir
 */
public class DatabaseConnection {
    
    
    public java.sql.Connection connectToDB() {
    java.sql.Connection con = null;
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://46.101.32.81:3306/eg_database";
    String user = "root";
    String password = "teameight";
    try {
        Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(url, user, password);
        if (con == null) {
            System.out.println("Connection cannot be established");
        }
        return con;
    } catch (Exception e) {
        System.out.println(e);
    }
    return null;
}
    
    
}
