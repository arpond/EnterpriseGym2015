package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.team7.eg_website.Store.ContentStore;
import uk.ac.dundee.team7.eg_website.Store.UserStore;
import uk.ac.dundee.team7.eg_website.model.AdminModel;
import uk.ac.dundee.team7.eg_website.model.ContentModel;

@WebServlet(name = "manageUsers", urlPatterns = {"/Admin/manageUsers"})
public class ManageUser extends HttpServlet {

        
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
                
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ArrayList<UserStore> uss = new ArrayList<UserStore>();
            AdminModel am = new AdminModel();
            
            try
            {
                uss = am.fetchUsers();
            }
            catch (Exception e)
            {
                Message.message("Database error" + e.toString(), request, response);
            }
            
            request.setAttribute("users", uss);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/manageUsers.jsp");
            view.include(request, response);
	}

}