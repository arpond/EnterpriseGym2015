package uk.ac.dundee.team7.eg_website.Store;

import org.joda.time.DateTime;

public class NewsStore {

	private int newsID;
	private DateTime postedTime;
	private DateTime displayTime;
	private String newsImage;
	private String categoryName;
	private ContentStore content;

    public NewsStore(int newsID, DateTime postedTime, DateTime displayTime, String newsImage, String categoryName, ContentStore content) {
        this.newsID = newsID;
        this.postedTime = postedTime;
        this.displayTime = displayTime;
        this.newsImage = newsImage;
        this.categoryName = categoryName;
        this.content = content;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public DateTime getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(DateTime postedTime) {
        this.postedTime = postedTime;
    }

    public DateTime getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(DateTime displayTime) {
        this.displayTime = displayTime;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ContentStore getContent() {
        return content;
    }

    public void setContent(ContentStore content) {
        this.content = content;
    }

    
}