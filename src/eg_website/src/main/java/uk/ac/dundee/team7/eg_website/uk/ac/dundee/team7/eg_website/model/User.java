package uk.ac.dundee.team7.eg_website.model;

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
	public UserProfile fetchUserProfile(Int UserID) {
		// TODO - implement User.fetchUserProfile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param email
	 */
	public Bool registerUser(String username, String password, Stringl email) {
		// TODO - implement User.registerUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param up
	 * @param ud
	 */
	public Bool updateProfile(UserProfile up, UserDetails ud) {
		// TODO - implement User.updateProfile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 */
	public Bool checkUsernameExists(String username) {
		// TODO - implement User.checkUsernameExists
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public Bool checkEmailExists(String email) {
		// TODO - implement User.checkEmailExists
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 */
	public Bool resubscribe(Int userId) {
		// TODO - implement User.resubscribe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 * @param password
	 */
	public String resetPassword(Int userId, String password) {
		// TODO - implement User.resetPassword
		throw new UnsupportedOperationException();
	}

}