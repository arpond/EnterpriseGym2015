package uk.ac.dundee.team7.eg_website.Store;

import org.joda.time.DateTime;

public class CalendarStore {

    private String eventStartTime;
    private String text;
    private String eventEndTime;

    public CalendarStore(String eventStartTime, String text, String eventEndTime) {
        this.text = text;
        this.eventStartTime = eventStartTime;

        this.eventEndTime = eventEndTime;
    }
    
}