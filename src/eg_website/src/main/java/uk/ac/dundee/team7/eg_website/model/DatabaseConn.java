/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.model;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dragomir
 */
public class DatabaseConn {
public java.sql.Connection con = null;
    public DatabaseConn() {

    }

    public java.sql.Connection connectToDB() {

        
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

