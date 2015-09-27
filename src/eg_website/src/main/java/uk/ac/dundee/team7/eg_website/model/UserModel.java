package uk.ac.dundee.team7.eg_website.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import uk.ac.dundee.team7.eg_website.Store.*;


public class UserModel {

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

        if (rs != null) {
            while (rs.next()) {
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

        if (rs != null) {
            while (rs.next()) {
                map.put(rs.getString("typeName"), rs.getInt("numberOfPoints"));
            }
            rs.first();
            usrProfile.setFirstName(rs.getString("firstname"));
            usrProfile.setLastName(rs.getString("lastname"));
            usrProfile.setMobile(rs.getString("mobile"));
            usrProfile.setContactNumber(rs.getString("contactNumber"));
            if (rs.getString("youngES_FLAG") == "1") {
                usrProfile.setYoungES_FLAG(Boolean.TRUE);
            } else {
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
    public Boolean registerUser(String username, String password, String email) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        UserProfile usrProfile = new UserProfile();
        CallableStatement cs = null;
        HashMap map = new HashMap();

        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{call registerUser(?,?,?)}");
            cs.setString(1, username);
            cs.setString(2, password);
            cs.setString(3, email);

            cs.execute();
            rs = cs.getResultSet();

        } catch (SQLException se) {
            conn.close();
            return false;
        }
        conn.close();
        return true;
    }

    /**
     *
     * @param up
     * @param ud
     */
    public Boolean updateProfile(UserProfile up, UserDetails ud) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = conn.prepareCall("");
        ResultSet rs = null;

        int userID = ud.getUserID();
        String fn = up.getFirstName();
        String ln = up.getLastName();
        String mobile = up.getMobile();
        String contactNum = up.getContactNumber();
        String YearOfStudy = up.getYearOfStudy();
        String matricNum = up.getMatricNumber();
        Boolean youngES = up.getYoungES_FLAG();
        String username = ud.getUsername();
        String email = ud.getEmail();
        try {
            cs = conn.prepareCall("{call updateProfile(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, userID);
            cs.setString(2, fn);
            cs.setString(3, ln);
            cs.setString(4, mobile);
            cs.setString(5, contactNum);
            cs.setString(6, YearOfStudy);
            cs.setString(7, matricNum);
            cs.setBoolean(8, youngES);
            cs.setString(9, username);
            cs.setString(10, email);
            cs.execute();
        } catch (SQLException se) {
            System.out.println(se.toString());
            String err = se.toString();
            conn.close();
            return false;
        }
        conn.close();
        return true;
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
	public Boolean resubscribe(int userId) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = conn.prepareCall("{call Subscribe(?)}");       
        
        cs.setInt(1, userId);
        cs.execute();       
        return true;
	}

	/**
	 * 
	 * @param userId
	 * @param password
	 */
	public String resetPassword(int userId, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = conn.prepareCall("update eg_users set password=? where userID = ?;");    
        
        cs.setString(1, password);
        cs.setInt(2, userId);
        cs.execute();       
        return "";
	}

}