package uk.ac.dundee.team7.eg_website.Store;

import java.util.HashMap;

public class UserDetails {

	private int userID;
	private String username;
	private String email;
	private int authID;
	private HashMap points;
	private int groupID;

    public UserDetails(int userID, String username, String email, int authID, HashMap points, int groupID) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.authID = authID;
        this.points = points;
        this.groupID = groupID;
    }

    public UserDetails() {
        userID = 0;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAuthID() {
        return authID;
    }

    public void setAuthID(int authID) {
        this.authID = authID;
    }

    public HashMap getPoints() {
        return points;
    }

    public void setPoints(HashMap points) {
        this.points = points;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

        
    
}