package uk.ac.dundee.team7.eg_website.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import uk.ac.dundee.team7.eg_website.Store.*;

public class AdminModel {

    /**
     *
     * @param username
     * @param emai
     */
    public Boolean addUser(String username, String email) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
       Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();

        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call addUserAdmin(?,?)}");
            cs.setString(1, username);
            cs.setString(2, email);
            
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
    public Boolean updateGroup(List<String> userIDs, int groupId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
       
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();

        CallableStatement cs = null;
        try {
            for (int i=0; i<userIDs.size(); i++)
            {
                int userId = Integer.parseInt(userIDs.get(i));
                
                cs = conn.prepareCall("{call updateUserGroup(?,?)}");
                cs.setInt(1, userId);
                cs.setInt(2, groupId);
                cs.execute();
            }
            conn.close();
            return true;
        } catch (SQLException se) {
            conn.close();
            return false;
        }

        
        
        
    }

    public ArrayList<UserStore> fetchUsers() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        

        ArrayList<UserStore> usrStoreList = new ArrayList<UserStore>();
        ResultSet rs = null;

        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call getAllUsers()}");
            cs.execute();
            rs = cs.getResultSet();
            
            // put detailsin usrDetails]
            // put profile in usrProfile
            // create new usrStore wih usr details + user profile

            // Add the new store to the list of store
            rs.first();
            do 
            {
                UserDetails usrDetails = new UserDetails();
                UserProfile usrProfile = new UserProfile();
                HashMap map = new HashMap();
                usrDetails.setAuthID(rs.getInt("eg_auth_authID"));
                usrDetails.setEmail(rs.getString("email"));
                usrDetails.setGroupID(rs.getInt("eg_groups_groupID"));

                usrDetails.setUserID(rs.getInt("userID"));
                usrDetails.setUsername(rs.getString("username"));
                
                usrProfile.setCollege(rs.getString("collegeName"));
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
                
                do
                {
                    if (rs.getInt("userID") != usrDetails.getUserID())
                    {
                        rs.previous();
                        break;
                    }
                    map.put(rs.getString("typeName"), rs.getInt("numberOfPoints"));
                } while (rs.next());
                usrDetails.setPoints(map);
                

                UserStore us = new UserStore(usrProfile, usrDetails);
                usrStoreList.add(us);
            } while (rs.next());

        } catch (SQLException se) {
            String error = se.toString();
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
        // TODO - implement AdminModel.searchUser
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

    public HashMap fetchPointTypes() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        HashMap types = new HashMap();

        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("SELECT *  FROM eg_pointTypes");
            cs.execute();
            ResultSet rs = cs.getResultSet();
            while(rs.next())
            {
                types.put(rs.getInt("typeId"),  rs.getString("typeName"));
            }
            conn.close();
            return types;
        } catch (SQLException se) {
            String e = se.toString();
            conn.close();
            return types;
        }
    }
    
    public HashMap fetchCategories() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        HashMap types = new HashMap();

        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("SELECT *  FROM eg_categories");
            cs.execute();
            ResultSet rs = cs.getResultSet();
            while(rs.next())
            {
                types.put(rs.getInt("categoryId"),  rs.getString("categoryName"));
            }
            conn.close();
            return types;
        } catch (SQLException se) {
            String e = se.toString();
            conn.close();
            return types;
        }
    }

    public HashMap fetchGroups()throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        HashMap groups = new HashMap();
        
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("SELECT *  FROM eg_groups");
            cs.execute();
            ResultSet rs = cs.getResultSet();
            while(rs.next())
            {
                groups.put(rs.getInt("groupID"), rs.getString("groupTitle"));
            }
            conn.close();
            return groups;
        } catch (SQLException se) {
            String e = se.toString();
            conn.close();
            return groups;
        }
    }

    public void modifyPoints(List<String> userIDs, int points, int type) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        HashMap types = new HashMap();

        CallableStatement cs = null;
        try {
            for (int i=0; i<userIDs.size(); i++)
            {
                int id = Integer.parseInt(userIDs.get(i));
                
                cs = conn.prepareCall("{call modifyPoints(?,?,?)}");
                cs.setInt(1, id);
                cs.setInt(2, type);
                cs.setInt(3, points);
                cs.execute();
            }
            conn.close();
        } catch (SQLException se) {
            String e = se.toString();
            conn.close();
        }
    }

}
