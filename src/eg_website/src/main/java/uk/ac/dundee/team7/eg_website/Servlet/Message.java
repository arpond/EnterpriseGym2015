/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
public class Message {
    
    /**
     * Method for forwarding to the error page with an error
     * 
     * @param message The message to pass to the message page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public static void error(String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", message);
        RequestDispatcher view = request.getRequestDispatcher("/message.jsp");
        view.forward(request, response);
    }
}
