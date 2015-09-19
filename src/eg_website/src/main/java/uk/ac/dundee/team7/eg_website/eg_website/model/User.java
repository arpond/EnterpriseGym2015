package uk.ac.dundee.team7.eg_website.eg_website.model;

import uk.ac.dundee.team7.eg_website.Store.*;

public class User {

	/**
	 * 
	 * @param Username
	 * @param password
	 */
	public UserDetails isValidLogin(String Username, String password) {
		// TODO - implement User.isValidLogin
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param UserID
	 */
	public UserProfile fetchUserProfile(int UserID) {
		// TODO - implement User.fetchUserProfile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param email
	 */
	public Boolean registerUser(String username, String password, String email) {
		// TODO - implement User.registerUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param up
	 * @param ud
	 */
	public Boolean updateProfile(UserProfile up, UserDetails ud) {
		// TODO - implement User.updateProfile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 */
	public Boolean checkUsernameExists(String username) {
		// TODO - implement User.checkUsernameExists
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public Boolean checkEmailExists(String email) {
		// TODO - implement User.checkEmailExists
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 */
	public Boolean resubscribe(int userId) {
		// TODO - implement User.resubscribe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 * @param password
	 */
	public String resetPassword(int userId, String password) {
		// TODO - implement User.resetPassword
		throw new UnsupportedOperationException();
	}

}