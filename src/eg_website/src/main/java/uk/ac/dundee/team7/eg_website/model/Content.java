package uk.ac.dundee.team7.eg_website.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import uk.ac.dundee.team7.eg_website.Store.*;

public class Content {

	/**
	 * Fetches stored content from the database based on the path.
         * 
	 * @param contentPath unique path representing where the content is located on the site
         * @return ContentStore the content at this location
	 */
	public ContentStore fetchContent(String contentPath) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DatabaseConnection dbc = new DatabaseConnection();
            java.sql.Connection conn = dbc.connectToDB();
            
            CallableStatement cs = conn.prepareCall("select * from eg_content where contentPath = ?");
            ContentStore contents = new ContentStore();
            cs.setString(1, contentPath);
            cs.execute();

            ResultSet rs = cs.getResultSet();

            if(rs != null && rs.next()){
               
                contents.setContent(rs.getString("content"));
                contents.setContentID(rs.getInt("contentID"));
                contents.setContentTitle(rs.getString("contentTitle"));
                contents.setContentPath(rs.getString("contentPath"));
            }
            conn.close();
            return contents;
	}

	/**
	 * Adds content to the database 
         * 
	 * @param contentPath The path of the content to add
	 * @param content The content to be added
	 * @param contentTitle The title of the content
         * @return Boolean if the content was added successfully
	 */
	public Boolean addContent(String contentPath, String content, String contentTitle) throws SQLException {
            java.sql.Connection conn = null;
            try 
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                DatabaseConnection dbc = new DatabaseConnection();
                conn = dbc.connectToDB();

                CallableStatement cs = conn.prepareCall("insert into eg_content (content, contentPath, contentTitle) VALUES (?,?,?) ");
                ContentStore contents = new ContentStore();
                cs.setString(1, content);
                cs.setString(2, contentPath);
                cs.setString(3, contentTitle);
                cs.execute();
                conn.close();
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
                conn.close();
                return false;
            }
            return true;
	}

	/**
	 * Updates the content in the database with the content in the content store.
         * The content to be updated is based on the content ID
         * 
	 * @param content The contentStore representing the updated date
         * @return boolean representing if the update was successful
	 */
	public Boolean updateContent(ContentStore content) throws SQLException {

            java.sql.Connection conn = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                DatabaseConnection dbc = new DatabaseConnection();
                conn = dbc.connectToDB();
                String contentString = content.getContent();
                String contentPath = content.getContentPath();
                String contentTitle = content.getContentTitle();
                int contentID = content.getContentID();
                
                CallableStatement cs = conn.prepareCall("update eg_content set content=?, contentPath=?, contentTitle=? where contentID =? ");
                cs.setString(1, contentString);
                cs.setString(2, contentPath);
                cs.setString(3, contentTitle);
                cs.setInt(4, contentID);
                cs.execute();
                conn.close();
            }
            catch (Exception e)
            {
                conn.close();
                return false;
            }
            return true;
	}

	/**
	 * Delete content from the database
         * 
	 * @param contentID The ID of the content to delete
         * @return Boolean if the operation was successful.
	 */
	public Boolean deleteContent(int contentID) throws SQLException {
            java.sql.Connection conn = null;
 
            
            try 
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                DatabaseConnection dbc = new DatabaseConnection();
                conn = dbc.connectToDB();
            
                CallableStatement cs = conn.prepareCall("delete from eg_content where contentID =? ");
                cs.setInt(1, contentID);
                cs.execute();
                conn.close();
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
                conn.close();
                return false;
            }
            return true;
	}

}