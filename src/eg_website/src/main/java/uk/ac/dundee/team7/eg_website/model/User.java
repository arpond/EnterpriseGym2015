package uk.ac.dundee.team7.eg_website.model;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import uk.ac.dundee.team7.eg_website.Store.*;


public class User {

    /**
     *
     * @param Username
     * @param password
     */
    public UserDetails isValidLogin(String Username, String UsrPassword) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        UserDetails details = new UserDetails();
        HashMap map = new HashMap();
        
        ResultSet rs = null;
        
        cs = conn.prepareCall("select * from eg_users,"
                + "eg_users_has_eg_pointTypes,"
                + "eg_pointTypes where username =?"
                + "and password =? "
                + "and eg_users.userID = eg_users_has_eg_pointTypes.eg_users_userID"
                + " and eg_pointTypes.typeId = eg_users_has_eg_pointTypes.eg_pointTypes_typeId; ");
        cs.setString(1, Username);
        cs.setString(2, UsrPassword);
        cs.execute();
        rs = cs.getResultSet();
        
            
        if(rs != null){
            while (rs.next())
            {
                map.put(rs.getString("typeName"), rs.getInt("numberOfPoints"));
            }
            rs.first();
            details.setEmail(rs.getString("email"));
            details.setAuthID(rs.getInt("eg_auth_authID"));
            details.setGroupID(rs.getInt("eg_groups_groupID"));
            details.setUserID(rs.getInt("userID"));
            details.setUsername(rs.getString("username"));
            details.setPoints(map);
        }
        conn.close();
        return details;
    }
	/**
	 * 
	 * @param UserID
	 */
	public UserProfile fetchUserProfile(int UserID) {
		// TODO - implement User.fetchUserProfile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param email
	 */
	public Boolean registerUser(String username, String password, String email) {
		// TODO - implement User.registerUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param up
	 * @param ud
	 */
	public Boolean updateProfile(UserProfile up, UserDetails ud) {
		// TODO - implement User.updateProfile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 */
	public Boolean checkUsernameExists(String username) {
		// TODO - implement User.checkUsernameExists
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public Boolean checkEmailExists(String email) {
		// TODO - implement User.checkEmailExists
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 */
	public Boolean resubscribe(int userId) {
		// TODO - implement User.resubscribe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 * @param password
	 */
	public String resetPassword(int userId, String password) {
		// TODO - implement User.resetPassword
		throw new UnsupportedOperationException();
	}

}