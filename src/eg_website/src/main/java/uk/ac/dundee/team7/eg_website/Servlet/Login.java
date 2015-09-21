package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.dundee.team7.eg_website.Servlet.Message;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.model.User;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet{

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
        
        if (username.equals(""))
        {
            Message.message("You must enter a username", request, response);
            return;
        }
        else if (password.equals(""))
        {
            Message.message("You must enter a password", request, response);
            return;
        }
        
        User user = new User();
        UserDetails userDetails;
        try
        {
            userDetails = user.isValidLogin(username, password);
        }
        catch (Exception e)
        {
            Message.message("There was a database error" + e.toString(), request, response);
            return;
        }
        HttpSession session=request.getSession();
        
        if (userDetails.getUserID() != 0)
        {
            session.setAttribute("UserDetails", userDetails);
            System.out.println("Session in servlet "+session);
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.forward(request,response); 
        }
        else
        {
            Message.message("Your username or passowrd is invalid", request, response);
        }
          
    }

    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Login servlet";
    }// </editor-fold>
    
    @Override
    public void destroy()
    {
        
    }
}