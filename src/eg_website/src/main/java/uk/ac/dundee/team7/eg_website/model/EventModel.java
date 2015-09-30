package uk.ac.dundee.team7.eg_website.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.net.aso.i;
import org.joda.time.DateTime;
import uk.ac.dundee.team7.eg_website.Store.*;

public class EventModel {
    public ArrayList<String> fetchPointTypes() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        CallableStatement cs = null;
        ArrayList<String> pointTypeArray = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        ResultSet rs = null;
             cs = conn.prepareCall("{call getPointTypes()}");
            cs.execute();
            rs = cs.getResultSet();
            int i = 0;
            while(rs.next()){
                pointTypeArray.add(rs.getString("typeName"));
                i++;
            }
            conn.close();
            return pointTypeArray;
        
    }
    /**
     *
     * @param eventPath
     */
    public EventStore fetchEvent(String eventPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        System.out.println("hiting the db");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        CallableStatement cs1 = null;
        EventStore evStore = new EventStore();
        ContentStore conStore = new ContentStore();
        String[] pointTypeArray = new String[20];
        
        System.out.println("123");
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
            System.out.println("321");
            cs = conn.prepareCall("{call getEventsOne(?)}");
            cs.setString(1, eventPath);
            cs.execute();
            rs = cs.getResultSet();
            
            rs.first();
            conStore.setContent(rs.getString("content"));
            conStore.setContentID(rs.getInt("contentID"));
            conStore.setContentPath(rs.getString("contentPath"));
            conStore.setContentTitle(rs.getString("contentTitle"));
            conStore.setContentSummary(rs.getString("contentSummary"));
            evStore.setContent(conStore);
            evStore.setEventImage(rs.getString("eventImage"));
            evStore.setEventPointType(rs.getString("typeName"));
            
            
            Timestamp eventStartTime = rs.getTimestamp("eventStartTime");
            Timestamp eventPosted = rs.getTimestamp("posted");
            
            
            Date date = new Date(eventStartTime.getTime());
           DateTime eventStartTimeDateTime = new DateTime(date);
            
            Date date1 = new Date(eventPosted.getTime());
            DateTime eventPostedDateTime = new DateTime(date1);
       
            
            evStore.setEventStartTime(eventStartTimeDateTime);
            evStore.setPostedTime(eventPostedDateTime);
            
          
            evStore.setEventValue(rs.getInt("eventPoints"));
            evStore.setEventID(rs.getInt("eventID"));

        } catch (SQLException se) {
            System.out.println(se);
            conn.close();
            return evStore;
        }
         
        conn.close();
        return evStore;

    }

    public ArrayList<EventStore> fetchEvents() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
       
        ArrayList<EventStore> evStoreList = new ArrayList<EventStore>();
        

        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{call getEvents()}");
            cs.execute();
            rs = cs.getResultSet();


            while (rs.next()) {
                
                 EventStore evStore = new EventStore();
                 ContentStore conStore = new ContentStore();
                 
                System.out.println("once----twice----trice ?");
                
                
                conStore.setContent(rs.getString("content"));
                conStore.setContentID(rs.getInt("contentID"));
                conStore.setContentPath(rs.getString("contentPath"));
                conStore.setContentTitle(rs.getString("contentTitle"));
                conStore.setContentSummary(rs.getString("contentSummary"));
                //String tempTitle = rs.getString("contentTitle");
                //conStore.setContentTitle(tempTitle);
                evStore.setContent(conStore);
                evStore.setEventImage(rs.getString("eventImage"));
                evStore.setEventPointType(rs.getString("typeName"));
                
                Timestamp eventPosted = rs.getTimestamp("posted");    
                Timestamp eventStartTime = rs.getTimestamp("eventStartTime");
                Date date = new Date(eventStartTime.getTime());
                DateTime eventStartTimeDateTime = new DateTime(date);
                Date date1 = new Date(eventPosted.getTime());
                DateTime eventPostedDateTime = new DateTime(date1);
                evStore.setEventStartTime(eventStartTimeDateTime);
                evStore.setPostedTime(eventPostedDateTime);
                evStore.setEventValue(rs.getInt("eventPoints"));
                evStore.setEventID(rs.getInt("eventID"));
                evStore.setEventValue(rs.getInt("eventPoints"));
                evStore.setEventID(rs.getInt("eventID"));
                evStoreList.add(evStore);
                System.out.println(evStoreList);
             
            }
            
        } catch (SQLException se) {
            System.out.println(se);
            conn.close();
            return evStoreList;
        }
        
        conn.close();
        return evStoreList;
    }

    /**
     *
     * @param eventPath
     * @param eventTitle
     * @param event
     * @param startTime
     * @param imageURL
     * @param eventPointType
     * @param eventValue
     */
    public boolean addEvent(String eventPath, String eventTitle, String event, DateTime startTime, String imageURL, int eventPointTypeID, int eventValue, int UserID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        DateTime dateTime1 = new DateTime(startTime);

        try {
            cs = conn.prepareCall("{call addEvent(?,?,?,?,?,?,?,?)}");
            cs.setTimestamp(1, new Timestamp(dateTime1.getMillis()));
            cs.setString(2, imageURL);
            cs.setString(3, event);
            cs.setInt(4, eventValue);
            cs.setString(5, eventPath);
            cs.setInt(6, UserID);
            cs.setInt(7, eventPointTypeID);
            cs.setString(8, eventTitle);
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
     * @param event
     */
    public boolean updateEvent(EventStore event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        CallableStatement cs1 = null;
        ContentStore contStore = event.getContent();
int tempEventPointTypeID = 1;
        int tempEventID = event.getEventID();
        int tempContentID = contStore.getContentID();
        DateTime tempStartTime = event.getEventStartTime();
        DateTime tempEndTime = event.getEventEndTime();
        String tempImageURL = event.getEventImage();
        String tempContent = contStore.getContent();
        int tempPoints = event.getEventValue();
        String tempContentPath = contStore.getContentPath();
        try {
            ResultSet rs = null;
            cs1 = conn.prepareCall("{call getPointTypeID(?)}");
            
            cs1.setString(1, event.getEventPointType());
            cs1.execute();
            rs = cs1.getResultSet();
            rs.first();
            tempEventPointTypeID = rs.getInt("typeId");
            
            String tempContentTitle = contStore.getContentTitle();
       //new Timestamp(dateTime1.getMillis()

            //contStore.getContentID()
            cs = conn.prepareCall("{call updateEvent(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, tempEventID);
            cs.setInt(2, tempContentID);
            cs.setTimestamp(3, new Timestamp(tempStartTime.getMillis()));
            cs.setString(4, tempImageURL);
            cs.setString(5, tempContent);
            cs.setInt(6, tempPoints);
            cs.setString(7, tempContentPath);
            cs.setInt(8, tempEventPointTypeID);
            cs.setString(9, tempContentTitle);
            cs.setTimestamp(10,  new Timestamp(tempEndTime.getMillis()));
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
     * @param eventID
     */
    public boolean deleteEvent(int eventID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;

        try {
            cs = conn.prepareCall("{call deleteEvent(?)}");
            cs.setInt(1, eventID);
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
     * @param eventId
     */
    public boolean signUp(int userId, int eventId) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call userSignUpToEvent(?,?)}");
            cs.setInt(1, userId);
            cs.setInt(2, eventId);
            cs.execute();
            conn.close();
            return true;
        } catch (SQLException se) {
            conn.close();
            return false;
        }

    }
    
    public ArrayList<UserStore> fetchUsersForEvent(int eventID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
       
        ArrayList<UserStore> usrStoreList = new ArrayList<UserStore>();
        
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{call GetSignedUpUsersForEvent(?)}");
            cs.setInt(1, eventID);
            cs.execute();
            rs = cs.getResultSet();


            while (rs.next()) {
                 UserProfile up = new UserProfile();
                 UserDetails ud = new UserDetails();
                 UserStore evStore = new UserStore(up,ud);
                 
                 ud.setUserID(rs.getInt("userID"));
                 ud.setUsername(rs.getString("username"));
                 ud.setEmail(rs.getString("email"));
                 up.setFirstName(rs.getString("firstname"));
                 up.setLastName(rs.getString("lastname"));
                 up.setMatricNumber(rs.getString("matricNumber"));
                 up.setYearOfStudy(rs.getString("yearOfStudy"));
                 
                evStore.setUd(ud);
                evStore.setUp(up);
                
                usrStoreList.add(evStore);
                
                
            }
        
    }catch (SQLException se) {
            conn.close();
            return usrStoreList;
        }
            conn.close();
            return usrStoreList;
    }
}
