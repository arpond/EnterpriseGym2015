/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Servlet;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import uk.ac.dundee.team7.eg_website.model.ContentModel;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "Async_PathCheck", urlPatterns = {"/Async_PathCheck"})
public class Async_PathCheck extends HttpServlet {


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
        ContentModel cm = new ContentModel();
        Boolean unique = false;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null)
        {
            json = br.readLine();
        }

        try
        {
            JSONObject jsonResult = new JSONObject(json);
            String path = jsonResult.getString("path");
            unique = cm.isUniquePath(path);
        }
        catch (Exception e)
        {
            unique = false;
        }
        json = new Gson().toJson(unique);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
