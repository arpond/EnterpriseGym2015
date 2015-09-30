package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.Store.UserStore;
import uk.ac.dundee.team7.eg_website.model.AdminModel;

@WebServlet(name = "manageUsers", urlPatterns = {"/Admin/manageUsers"})
public class ManageUser extends HttpServlet {

        
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                
                if (action.equals("ap"))
                {
                    int points = jsonResult.getInt("points");
                    int type = jsonResult.getInt("type");
                    addPoints(userIDs, points, type, request, response);
                }
                else if (action.equals("rp"))
                {
                    int points = jsonResult.getInt("points");
                    int type = jsonResult.getInt("type");
                    removePoints(userIDs, points, type, request, response);
                }
                else if (action.equals("chgrp"))
                {
                    int group = jsonResult.getInt("groupID");
                    changeGroup(userIDs, group, request, response);
                }
                

            }
            catch (Exception e)
            {
                String ex = e.toString();
                System.out.println(ex);
            }
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ArrayList<UserStore> uss = new ArrayList<UserStore>();
            AdminModel am = new AdminModel();
            HashMap types = new HashMap();
            HashMap groups = new HashMap();
            
            try
            {
                uss = am.fetchUsers();
                types = am.fetchPointTypes();
                groups = am.fetchGroups();
            }
            catch (Exception e)
            {
                Message.message("Database error" + e.toString(), request, response);
            }
            HttpSession session = request.getSession();
            UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
            if (ud == null || ud.getGroupID() != 3)
            {
                Message.message("You do not have access to the admin page.", request, response);
            }
            else
            {
                request.setAttribute("groups", groups);
                request.setAttribute("users", uss);
                request.setAttribute("pointTypes", types);
                RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/manageUsers.jsp");
                view.include(request, response);
            }
            
	}

    private void addPoints(List<String> userIDs, int points, int type, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        AdminModel am = new AdminModel();
        try
        {
            am.modifyPoints(userIDs, points, type);
        }
        catch (Exception e)
        {
            Message.message("Database error" + e.toString(), request, response); 
        }
    }

    private void removePoints(List<String> userIDs, int points, int type,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        AdminModel am = new AdminModel();
        try
        {
            am.modifyPoints(userIDs, (-points), type);
        }
        catch (Exception e)
        {
            Message.message("Database error" + e.toString(), request, response); 
        }
    }

    private void changeGroup(List<String> userIDs, int groupID,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        AdminModel am = new AdminModel();
        try
        {
            am.updateGroup(userIDs, groupID);
        }
        catch (Exception e)
        {
            Message.message("Database error" + e.toString(), request, response); 
        }
    }

}