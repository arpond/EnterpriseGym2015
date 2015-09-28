package uk.ac.dundee.team7.eg_website.Store;

import org.joda.time.DateTime;

public class EventStore {

	private int eventID;
	private DateTime postedTime;
	private int eventValue;
	private DateTime eventStartTime;
	private String eventImage;
	private String eventPointType;
	private ContentStore content;
        private DateTime eventEndTime;

    public EventStore(int eventID, DateTime postedTime, int eventValue, DateTime eventStartTime, String eventImage, String eventPointType, ContentStore content, DateTime eventEndTime) {
        this.eventID = eventID;
        this.postedTime = postedTime;
        this.eventValue = eventValue;
        this.eventStartTime = eventStartTime;
        this.eventImage = eventImage;
        this.eventPointType = eventPointType;
        this.content = content;
        this.eventEndTime = eventEndTime;
    }
    
    
    public EventStore(){
        eventID = 0;
    }
    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public DateTime getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(DateTime postedTime) {
        this.postedTime = postedTime;
    }

    public int getEventValue() {
        return eventValue;
    }

    public void setEventValue(int eventValue) {
        this.eventValue = eventValue;
    }

    public DateTime getEventStartTime() {
        return eventStartTime;
    }
    
    public DateTime getEventEndTime() {
        return eventEndTime;
    }

    public void setEventStartTime(DateTime eventStartTime) {
        this.eventStartTime = eventStartTime;
    }
    
     public void setEventEndTime(DateTime eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventPointType() {
        return eventPointType;
    }

    public void setEventPointType(String eventPointType) {
        this.eventPointType = eventPointType;
    }

    public ContentStore getContent() {
        return content;
    }

    public void setContent(ContentStore content) {
        this.content = content;
    }

        
}