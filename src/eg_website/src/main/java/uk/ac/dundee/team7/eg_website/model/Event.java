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
	public Bool addEvent(String eventPath, String eventTitle, String event, DateTime startTime, String imageURL, String eventPointType, int eventValue) {
		// TODO - implement Event.addEvent
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public Bool updateEvent(EventStore event) {
		// TODO - implement Event.updateEvent
		throw new UnsupportedOperationException();
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