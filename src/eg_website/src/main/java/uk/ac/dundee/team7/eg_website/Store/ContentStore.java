package uk.ac.dundee.team7.eg_website.Store;

public class ContentStore {

	private int contentID;
	private String content;
	private String contentPath;
	private String contentTitle;

    public ContentStore(int contentID, String content, String contentPath, String contentTitle) {
        this.contentID = contentID;
        this.content = content;
        this.contentPath = contentPath;
        this.contentTitle = contentTitle;
    }
    public ContentStore(){
        
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

        
        
}
