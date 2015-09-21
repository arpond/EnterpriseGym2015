package uk.ac.dundee.team7.eg_website.model;

import java.util.ArrayList;
import org.joda.time.DateTime;
import uk.ac.dundee.team7.eg_website.Store.*;

public class News {

	/**
	 * 
	 * @param newsPath
	 */
	public NewsStore fetchNews(String newsPath) {
		// TODO - implement News.fetchNews
		throw new UnsupportedOperationException();
	}

	public ArrayList<NewsStore> fetchNews() {
		// TODO - implement News.fetchNews
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newsPath
	 * @param newsTitle
	 * @param news
	 * @param displayTime
	 * @param imageURL
	 * @param category
	 */
	public Boolean addNews(String newsPath, String newsTitle, String news, DateTime displayTime, String imageURL, String category) {
		// TODO - implement News.addNews
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param news
	 */
	public Boolean updateContent(NewsStore news) {
		// TODO - implement News.updateContent
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newsID
	 */
	public Boolean deleteNews(int newsID) {
		// TODO - implement News.deleteNews
		throw new UnsupportedOperationException();
	}

}