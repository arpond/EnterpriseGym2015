package uk.ac.dundee.team7.eg_website.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.net.aso.i;
import org.joda.time.DateTime;
import uk.ac.dundee.team7.eg_website.Store.*;

public class Event {

	/**
	 * 
	 * @param eventPath
	 */
	public EventStore fetchEvent(String eventPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        EventStore evStore = new EventStore();
        ContentStore conStore = new ContentStore();
        

        ResultSet rs = null;
        try{
        cs = conn.prepareCall("{call getEventOne(?)}");
	cs.setString(1, eventPath);
        cs.execute();
        rs = cs.getResultSet();
       
        conStore.setContent(rs.getString("content"));
        conStore.setContentPath(rs.getString("contentPath"));
        conStore.setContentTitle(rs.getString("contentTitle"));
        evStore.setContent(conStore);
        evStore.setEventImage(rs.getString("eventImage"));
        evStore.setEventPointType(rs.getString("typeName"));
        evStore.setEventStartTime(new DateTime(rs.getTimestamp("eventStartTime").getTime()));
        evStore.setEventValue(rs.getInt("eventPoints"));
        evStore.setPostedTime(new DateTime(rs.getTimestamp("posted").getTime()));
        evStore.setEventID(rs.getInt("eventID"));
        
        } catch (SQLException se) {
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
        EventStore evStore = new EventStore();
        ArrayList<EventStore> evStoreList = new ArrayList<EventStore>();
        ContentStore conStore = new ContentStore();

        ResultSet rs = null;
        try{
        cs = conn.prepareCall("{call getEvents()}");
        cs.execute();
        rs = cs.getResultSet();
        
        if(rs != null && rs.next()){
        conStore.setContent(rs.getString("content"));
        conStore.setContentPath(rs.getString("contentPath"));
        conStore.setContentTitle(rs.getString("contentTitle"));
        evStore.setContent(conStore);
        evStore.setEventImage(rs.getString("eventImage"));
        evStore.setEventPointType(rs.getString("typeName"));
        evStore.setEventStartTime(new DateTime(rs.getTimestamp("eventStartTime").getTime()));
        evStore.setEventValue(rs.getInt("eventPoints"));
        evStore.setPostedTime(new DateTime(rs.getTimestamp("posted").getTime()));
        evStore.setEventID(rs.getInt("eventID"));
        
        evStoreList.add(evStore);
        }
        } catch (SQLException se) {
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
      
        
        
       
        try{
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
        }catch(SQLException se){
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
         
        int tempEventID = event.getEventID();
        int tempContentID = contStore.getContentID();
        DateTime tempStartTime = event.getEventStartTime();
        String tempImageURL = event.getEventImage();
        String tempContent = contStore.getContent();
        int tempPoints = event.getEventValue();
        String tempContentPath = contStore.getContentPath();
        try{
        ResultSet rs = null;
        cs1 = conn.prepareCall("{call getPointTypeID(?)}");
        int tempEventPointTypeID;
        cs1.setString(1, event.getEventPointType());
        cs1.execute();
        rs = cs1.getResultSet();
        tempEventPointTypeID = rs.getInt("typeID");
        String tempContentTitle = contStore.getContentTitle();
       //new Timestamp(dateTime1.getMillis()
        
        //contStore.getContentID()
        cs = conn.prepareCall("{call updateEvent(?,?,?,?,?,?,?,?,?)}");
        cs.setInt(1,tempEventID);
        cs.setInt(2, tempContentID);
        cs.setTimestamp(3, new Timestamp(tempStartTime.getMillis()));
        cs.setString(4, tempImageURL);
        cs.setString(5, tempContent);
        cs.setInt(6, tempPoints);
        cs.setString(7, tempContentPath);
        cs.setInt(8, tempEventPointTypeID);
        cs.setString(9, tempContentTitle);
        cs.execute();
        conn.close();
        return true;
        }catch(SQLException se){
            conn.close();
            return false;
        }
        
	}

	/**
	 * 
	 * @param eventID
	 */
	public Bool deleteEvent(int eventID) {
		// TODO - implement Event.deleteEvent
		throw new UnsupportedOperationException();
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
        try{
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

}