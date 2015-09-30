/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
import org.json.JSONException;
import org.json.JSONObject;
import uk.ac.dundee.team7.eg_website.model.AdminModel;
import uk.ac.dundee.team7.eg_website.model.UserModel;

/**
 *
 * @author dragomir
 */
@WebServlet(name = "UserRegisterValidation", urlPatterns = {"/UserRegisterValidation"})
public class UserRegisterValidation extends HttpServlet {

 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        UserModel um = new UserModel();
        Boolean usernameExists = false;
        
        String username = request.getParameter("username");
        
        try {
            usernameExists = um.checkUsernameExists(username);
        } catch (SQLException ex) {
            Logger.getLogger(UserRegisterValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserRegisterValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(UserRegisterValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserRegisterValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        String message;
        if(usernameExists){
        message = String.format("Username is taken");
        
        }else{
        message = String.format("Username is fine");
            
        }
        out.print(message);
    }

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
                
                 if (action.equals("updateUsers")){
                     AdminModel am = new AdminModel();
                     
              //       am.givePointsForEvent(userIDs, eventID);
                 }
                
                
                
            } catch (JSONException ex) {
            Logger.getLogger(UserRegisterValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
