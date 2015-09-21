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
        
        cs = conn.prepareCall("{call isValidLogin(?,?)}");
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
	public UserProfile fetchUserProfile(int UserID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
	
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        UserProfile usrProfile = new UserProfile();
        CallableStatement cs = null;
         HashMap map = new HashMap();
        
        ResultSet rs = null;
        
        cs = conn.prepareCall("{call userProfile(?)}");
        cs.setInt(1, UserID);
       
        cs.execute();
        rs = cs.getResultSet();
        
            
        if(rs != null){
            while (rs.next())
            {
                map.put(rs.getString("typeName"), rs.getInt("numberOfPoints"));
            }
            rs.first();
            usrProfile.setFirstName(rs.getString("firstname"));
            usrProfile.setLastName(rs.getString("lastname"));
            usrProfile.setMobile(rs.getString("mobile"));
            usrProfile.setContactNumber(rs.getString("contactNumber"));
            if(rs.getString("youngES_FLAG") == "1"){
            usrProfile.setYoungES_FLAG(Boolean.TRUE);
            }else{
            usrProfile.setYoungES_FLAG(Boolean.FALSE);

            }
            usrProfile.setYearOfStudy(rs.getString("yearOfStudy"));
            usrProfile.setMatricNumber(rs.getString("matricNumber"));
            usrProfile.setCollege(rs.getString("collegeName"));
            usrProfile.setCountry(rs.getString("countryName"));
            usrProfile.setInstitution(rs.getString("institutionName"));
            usrProfile.setStatus(rs.getString("statusName"));
            usrProfile.setDegree(rs.getString("degreeName"));
        }
        conn.close();
        
        
        return usrProfile;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param email
	 */
	public Boolean registerUser(String username, String password, String email) {
        return null;
		
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
	public Boolean checkUsernameExists(String Username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = conn.prepareCall("select * from eg_users where username = ?;");        
        ResultSet rs = null;
        
        
        cs.setString(1, Username);
        cs.execute();
        rs = cs.getResultSet();
        rs.first();
        if(rs.getString("username")==null)
            return false;
        
        return true;
	}

	/**
	 * 
	 * @param email
	 */
	public Boolean checkEmailExists(String email) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = conn.prepareCall("select * from eg_users where email = ?;");        
        ResultSet rs = null;
        
        
        cs.setString(1, email);
        cs.execute();
        rs = cs.getResultSet();
        rs.first();
        if(rs.getString("email")==null)
            return false;
        
        return true;
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