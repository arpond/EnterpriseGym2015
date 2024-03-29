package uk.ac.dundee.team7.eg_website.Store;

public class ContentStore {

	private int contentID;
	private String content;
	private String contentPath;
	private String contentTitle;
        private String contentSummary;

    public ContentStore(int contentID, String content, String contentPath, String contentTitle, String contentSummary) {
        this.contentID = contentID;
        this.content = content;
        this.contentPath = contentPath;
        this.contentTitle = contentTitle;
        this.contentSummary = contentSummary;
    }
  
    public ContentStore()
    {
        contentID = 0;
    }
    
    public int getContentID() {
        return contentID;
    }

    public void setContentID(int contentID) {
        this.contentID = contentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentSummary() {
        return contentSummary;
    }

    public void setContentSummary(String contentSummary) {
        this.contentSummary = contentSummary;
    }
       
}
