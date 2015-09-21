package uk.ac.dundee.team7.eg_website.model;

import java.util.ArrayList;
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
	public Boolean updateUser(int userId, int pointType, int points) {
		// TODO - implement Admin.updateUser
		throw new UnsupportedOperationException();
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

	public ArrayList<UserStore> fetchUsers() {
		// TODO - implement Admin.fetchUsers
		throw new UnsupportedOperationException();
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
	public Boolean addGroup(String groupTitle) {
		// TODO - implement Admin.addGroup
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param categoryName
	 */
	public Boolean addCategory(String categoryName) {
		// TODO - implement Admin.addCategory
		throw new UnsupportedOperationException();
	}

}