package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.model.UserModel;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

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
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String confirm = request.getParameter("verification");
        String email=request.getParameter("email");
        
        if (username.equals(""))
        {
            Message.message("You must enter a username", request, response);
            return;
        }
        else if (password.equals(""))
        {
            Message.message("You must enter a passweord", request, response);
            return;
        }
        else if (!password.equals(confirm))
        {
            Message.message("Your passwords do not match", request, response);
            return;
        }
        else if (email.equals(""))
        {
            Message.message("You must enter an email address", request, response);
            return;
        }
        
        UserModel user = new UserModel();
        Boolean result = false;
        
        try
        {
            result = user.registerUser(username, password, email);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        
        if (result)
        {
            request.setAttribute("message", "Registration Successful");
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/message.jsp");
            view.forward(request, response);
        }
        else
        {
            request.setAttribute("message", "There was a problem with your registation");
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/message.jsp");
            view.forward(request, response);
        }
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/registration.jsp");
        rd.forward(request,response); 
    }
}