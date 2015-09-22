/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.dundee.team7.eg_website.Store.ContentStore;

/**
 *
 * @author Andrew
 */
public class ContentTest {
    
    public ContentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String contentPath = "/test/test";
        String content = "<div><p>test html</p></div>";
        String contentTitle = "Test HTML";
        Content instance = new Content();
        Boolean expResult = true;
        try
        {
            Boolean result = instance.addContent(contentPath, content, contentTitle);
            assertEquals(expResult, result);
        }
        catch (Exception e)
        {
            fail("Failed with exception\n" + e.toString());
        }
    }
    
    @After
    public void tearDown() {
        Content instance = new Content();
        ContentStore cs;
        try
        {
            cs = instance.fetchContent("/test/test");
            int id = cs.getContentID();
            instance.deleteContent(id);
            //assertEquals(true, instance.deleteContent(cs.getContentID()));
        }
        catch (Exception e)
        {
            fail("Failed with exception\n" + e.toString());
        }
    }

    /**
     * Test of fetchContent method, of class Content.
     */
    @Test
    public void testFetchContent() throws Exception {
        System.out.println("fetchContent");
        String contentPath = "/test/test";
        Content instance = new Content();
        
        ContentStore result = instance.fetchContent(contentPath);
        assertEquals("<div><p>test html</p></div>", result.getContent());
        assertEquals("/test/test", result.getContentPath());
        assertEquals("Test HTML", result.getContentTitle());
    }

    /**
     * Test of addContent method, of class Content.
     */
    @Test
    public void testAddContent() {
        System.out.println("addContent");
        String contentPath = "/test/test2";
        String content = "<div><p>test html</p></div>";
        String contentTitle = "Test HTML";
        Content instance = new Content();
        Boolean expResult = true;
        
        try
        {
            Boolean result = instance.addContent(contentPath, content, contentTitle);
            assertEquals(expResult, result);
            ContentStore cs;
            cs = instance.fetchContent(contentPath);
            assertEquals(content, cs.getContent());
            assertEquals(contentPath, cs.getContentPath());
            assertEquals(contentTitle, cs.getContentTitle());
            assertEquals(true, instance.deleteContent(cs.getContentID()));
        }
        catch (Exception e)
        {
            fail("Failed with exception\n" + e.toString());
        }
        
    }

    /**
     * Test of updateContent method, of class Content.
     */
    @Test
    public void testUpdateContent() {
        System.out.println("updateContent");
        Content instance = new Content();
        try
        {
            ContentStore fetched = instance.fetchContent("/test/test");
            ContentStore content = new ContentStore(fetched.getContentID(), "updated", "/test/updated", "Updated Test HTML");
            Boolean expResult = true;
            Boolean result = instance.updateContent(content);
            ContentStore updated = instance.fetchContent("/test/updated");
            assertEquals(expResult, result);
            assertEquals(fetched.getContentID(), updated.getContentID());
            assertEquals("updated", updated.getContent());
            assertEquals("/test/updated", updated.getContentPath());
            assertEquals("Updated Test HTML", updated.getContentTitle());
            instance.updateContent(fetched);
        }
        catch (Exception e)
        {
            fail("Failed with exception\n" + e.toString());
        }
    }

    /**
     * Test of deleteContent method, of class Content.
     */
    @Test
    public void testDeleteContent() {
        System.out.println("deleteContent");
        ContentStore cs;
        Content instance = new Content();
        try
        {
            cs = instance.fetchContent("/test/test");
            int contentID = cs.getContentID();
            instance.deleteContent(contentID);
            Boolean expResult = true;
            Boolean result = instance.deleteContent(contentID);
            assertEquals(expResult, result);
            instance.addContent(cs.getContentPath(), cs.getContent(), cs.getContentTitle());
        }
        catch (Exception e)
        {
            fail("Failed with exception\n" + e.toString());
        }
        
    }
    
}
