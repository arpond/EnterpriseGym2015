package uk.ac.dundee.team7.eg_website.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import uk.ac.dundee.team7.eg_website.Store.*;

public class Admin {

    /**
     *
     * @param username
     * @param emai
     */
    public Boolean addUser(String username, String email) {
        // TODO - implement Admin.addUser
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param userId
     * @param pointType
     * @param points
     */
    public Boolean updateUser(int userId, int pointType, int points) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();

        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call updateUser(?,?,?)}");
            cs.setInt(1, userId);
            cs.setInt(2, pointType);
            cs.setInt(3, points);
            cs.execute();
            conn.close();
            return true;
        } catch (SQLException se) {
            conn.close();
            return false;
        }

    }

    /**
     *
     * @param userId
     * @param groupId
     */
    public Boolean updateGroup(int userId, int groupId) {
        // TODO - implement Admin.updateGroup
        throw new UnsupportedOperationException();
    }

    public ArrayList<UserStore> fetchUsers() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        UserDetails usrDetails = new UserDetails();
        UserProfile usrProfile = new UserProfile();

        ArrayList<UserStore> usrStoreList = new ArrayList<UserStore>();
        ResultSet rs = null;

        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call getAllUsers()}");
            cs.execute();
            rs = cs.getResultSet();
            HashMap map = new HashMap();
            // put detailsin usrDetails]
            // put profile in usrProfile
            // create new usrStore wih usr details + user profile

            // Add the new store to the list of store
            if (rs != null && rs.next()) {

                usrDetails.setAuthID(rs.getInt("eg_auth_authID"));
                usrDetails.setEmail(rs.getString("email"));
                usrDetails.setGroupID(rs.getInt("eg_groups_groupID"));

                usrDetails.setUserID(rs.getInt("userID"));
                usrDetails.setUsername(rs.getString("username"));
                while (rs.getInt("userID") == usrDetails.getUserID()) {
                    map.put(rs.getString("typeName"), rs.getInt("numberOfPoints"));
                }
                usrDetails.setPoints(map);
                usrProfile.setCollege(rs.getString("collageName"));
                usrProfile.setContactNumber(rs.getString("contactNumber"));
                usrProfile.setCountry(rs.getString("countryName"));
                usrProfile.setDegree(rs.getString("degreeName"));
                usrProfile.setFirstName(rs.getString("firstname"));
                usrProfile.setLastName(rs.getString("lastname"));
                usrProfile.setInstitution(rs.getString("institutionName"));
                usrProfile.setMatricNumber(rs.getString("matricNumber"));
                usrProfile.setMobile(rs.getString("mobile"));
                usrProfile.setStatus(rs.getString("statusName"));
                usrProfile.setYearOfStudy(rs.getString("yearOfStudy"));
                usrProfile.setYoungES_FLAG(rs.getBoolean("youngES_FLAG"));

                UserStore us = new UserStore(usrProfile, usrDetails);
                usrStoreList.add(us);
            }

        } catch (SQLException se) {
            conn.close();
            return usrStoreList;
        }
        conn.close();
        return usrStoreList;
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param mobile
     * @param contactNumber
     * @param yearOfStudy
     * @param matricNumber
     * @param youngES_FLAG
     * @param country
     * @param institution
     * @param degree
     * @param college
     * @param status
     * @param email
     */
    public ArrayList<UserStore> searchUser(String firstName, String lastName, String mobile, String contactNumber, String yearOfStudy, String matricNumber, Boolean youngES_FLAG, String country, String institution, String degree, String college, String status, String email) {
        // TODO - implement Admin.searchUser
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param groupTitle
     */
    public Boolean addGroup(String groupTitle) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();

        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call addGroup(?)}");
            cs.setString(1, groupTitle);
            cs.execute();
            conn.close();
            return true;
        } catch (SQLException se) {
            conn.close();
            return false;
        }
    }

    /**
     *
     * @param categoryName
     */
    public Boolean addCategory(String categoryName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();

        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call addCategory(?)}");
            cs.setString(1, categoryName);
            cs.execute();
            conn.close();
            return true;
        } catch (SQLException se) {
            conn.close();
            return false;
        }
    }

}
