/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.team7.test;

import java.sql.SQLException;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.model.User;

/**
 *
 * @author Acer
 */
public class LoginValidationTest {
    
    public LoginValidationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
     @Test
     public void LoginValidation() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException 
     {
      User bob = new User();
      UserDetails bobsDetails = bob.isValidLogin("andy", "sadsa");
      HashMap points = new HashMap();
      UserDetails testDetails = new UserDetails(1,"andy","email",1,points,1);
      
      org.junit.Assert.assertEquals(bobsDetails.getUsername(), testDetails.getUsername());
     }
}
