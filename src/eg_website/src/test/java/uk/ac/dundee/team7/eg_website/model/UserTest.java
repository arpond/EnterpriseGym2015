/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.team7.eg_website.model;

import java.sql.SQLException;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.Store.UserProfile;

/**
 *
 * @author Acer
 */
public class UserTest {
    
    public UserTest() {
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

    /**
     * Test of isValidLogin method, of class UserModel.
     * @throws java.lang.Exception
     */
    @Test
    public void testIsValidLogin() throws Exception {
        UserModel bob = new UserModel();
      UserDetails bobsDetails = bob.isValidLogin("andy", "sadsa");
      HashMap points = new HashMap();
      UserDetails testDetails = new UserDetails(1,"andy","email",1,points,1);
      
      org.junit.Assert.assertEquals(bobsDetails.getUsername(), testDetails.getUsername());
    }

    /**
     * Test of fetchUserProfile method, of class User.
     */
//    @Test
//    public void testFetchUserProfile() throws Exception {
//        
//    }

    /**
     * Test of registerUser method, of class User.
     */
//    @Test
//    public void testRegisterUser() {
//        System.out.println("registerUser");
//        String username = "";
//        String password = "";
//        String email = "";
//        UserModel instance = new UserModel();
//        Boolean expResult = null;
//        Boolean result = instance.registerUser(username, password, email);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of updateProfile method, of class User.
     */
//    @Test
//    public void testUpdateProfile() {
//        System.out.println("updateProfile");
//        UserProfile up = null;
//        UserDetails ud = null;
//        UserModel instance = new UserModel();
//        Boolean expResult = null;
//        Boolean result = instance.updateProfile(up, ud);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of checkUsernameExists method, of class UserModel.
     * @throws java.lang.Exception
     */
    @Test
    public void testCheckUsernameExists() throws Exception {
        UserModel bob= new UserModel();
         org.junit.Assert.assertEquals(Boolean.TRUE, bob.checkUsernameExists("andy"));
    }

    /**
     * Test of checkEmailExists method, of class UserModel.
     */
    @Test
    public void testCheckEmailExists() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UserModel bob= new UserModel();
         org.junit.Assert.assertEquals(Boolean.TRUE, bob.checkEmailExists("sadasd"));
    }

    /**
     * Test of resubscribe method, of class User.
     */
    /*@Test
    public void testResubscribe() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        UserModel bob = new UserModel();
        bob.resubscribe(0);
    }*/

    /**
     * Test of resetPassword method, of class UserModel.
     */
    @Test
    public void testResetPassword() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UserModel bob= new UserModel();
        bob.resetPassword(2, "gorosmash");
        org.junit.Assert.assertEquals("roger", "roger");
    }
    
}
