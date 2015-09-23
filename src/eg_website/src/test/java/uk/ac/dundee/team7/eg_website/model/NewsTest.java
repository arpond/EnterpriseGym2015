/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.team7.eg_website.model;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uk.ac.dundee.team7.eg_website.Store.ContentStore;
import uk.ac.dundee.team7.eg_website.Store.NewsStore;

/**
 *
 * @author Acer
 */
public class NewsTest {
    
    public NewsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of fetchNews method, of class News.
     */
    @Test
    public void testFetchNews_String() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        News news = new News();
        NewsStore bob = news.fetchNews("dsadas");
    }

    /**
     * Test of fetchNews method, of class News.
     */
    @Test
    public void testFetchNews_0args() {
        
    }

    /**
     * Test of addNews method, of class News.
     */
  //  @Test
   // public void testAddNews() throws Exception {
     //   DateTime now = new DateTime();
      //  //UserID must exist in the database to work.
       // ContentStore test = new ContentStore();
       // NewsStore testNews = new NewsStore(21,now,now,"","",test);
      //  News news = new News();
      //  news.addNews(2,"","","",now,"",2);
  //  }

    /**
     * Test of updateContent method, of class News.
     */
    @Test
    public void testUpdateContent() {
        News news = new News();
    }

    /**
     * Test of deleteNews method, of class News.
     */
    @Test
    public void testDeleteNews() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        News news = new News();
        news.deleteNews(10);
    }
    
}
