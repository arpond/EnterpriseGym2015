package uk.ac.dundee.team7.eg_website.model;

import uk.ac.dundee.team7.eg_website.Store.*;

public class Event {

	/**
	 * 
	 * @param eventPath
	 */
	public EventStore fetchEvent(String eventPath) {
		// TODO - implement Event.fetchEvent
		throw new UnsupportedOperationException();
	}

	public ArrayList<EventStore> fetchEvents() {
		// TODO - implement Event.fetchEvents
		throw new UnsupportedOperationException();
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
	public Bool addEvent(String eventPath, String eventTitle, String event, DateTime startTime, String imageURL, String eventPointType, Int eventValue) {
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
	public Bool deleteEvent(Int eventID) {
		// TODO - implement Event.deleteEvent
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 * @param eventId
	 */
	public Bool signUp(Int userId, Int eventId) {
		// TODO - implement Event.signUp
		throw new UnsupportedOperationException();
	}

}