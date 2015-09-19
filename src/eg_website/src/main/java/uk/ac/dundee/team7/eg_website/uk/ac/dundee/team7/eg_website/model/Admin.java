package uk.ac.dundee.team7.eg_website.model;

import uk.ac.dundee.team7.eg_website.Store.*;

public class Admin {

	/**
	 * 
	 * @param username
	 * @param emai
	 */
	public Bool addUser(String username, Stringl emai) {
		// TODO - implement Admin.addUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 * @param pointType
	 * @param points
	 */
	public Bool updateUser(Int userId, Int pointType, Int points) {
		// TODO - implement Admin.updateUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 * @param groupId
	 */
	public Bool updateGroup(Int userId, Int groupId) {
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
	public ArrayList<UserStore> searchUser(String firstName, String lastName, String mobile, String contactNumber, String yearOfStudy, String matricNumber, Bool youngES_FLAG, String country, String institution, String degree, String college, String status, String email) {
		// TODO - implement Admin.searchUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param groupTitle
	 */
	public Bool addGroup(String groupTitle) {
		// TODO - implement Admin.addGroup
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param categoryName
	 */
	public Bool addCategory(String categoryName) {
		// TODO - implement Admin.addCategory
		throw new UnsupportedOperationException();
	}

}