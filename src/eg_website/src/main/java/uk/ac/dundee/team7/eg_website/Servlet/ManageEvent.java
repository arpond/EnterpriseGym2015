package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;
import uk.ac.dundee.team7.eg_website.Store.NewsStore;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.Store.UserProfile;
import uk.ac.dundee.team7.eg_website.model.AdminModel;
import uk.ac.dundee.team7.eg_website.model.NewsModel;

@WebServlet(name = "ManageEvent", urlPatterns = {"/Admin/markUsersAsAttended"})
public class ManageEvent extends HttpServlet{

	


    
   /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String json = "";
            if(br != null)
            {
                json = br.readLine();
            }
            
            try
            {
                JSONObject jsonResult = new JSONObject(json);
                String selected = jsonResult.getString("selected");
                List<String> userIDs = Arrays.asList(selected.split("\\s*,\\s*"));
                String action = jsonResult.getString("action");
                
                 if (action.equals("markUsersAsAttended")){
                     AdminModel am = new AdminModel();
                     int eventID = jsonResult.getInt("eventID");
                     am.givePointsForEvent(userIDs, eventID);
                 }
                
                
                
            } catch (JSONException ex) {
            Logger.getLogger(ManageEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ManageEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ManageEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
    }

}