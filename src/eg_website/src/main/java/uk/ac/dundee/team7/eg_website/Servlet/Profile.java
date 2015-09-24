package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.dundee.team7.eg_website.Store.CountryStore;
import uk.ac.dundee.team7.eg_website.Store.InstitutionStore;
import uk.ac.dundee.team7.eg_website.Store.StatusStore;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.Store.UserProfile;
import uk.ac.dundee.team7.eg_website.lib.Utils;
import uk.ac.dundee.team7.eg_website.model.DemographicModel;
import uk.ac.dundee.team7.eg_website.model.UserModel;

@WebServlet(urlPatterns = {
    "/Profile/*"
})
public class Profile extends HttpServlet{

    private HashMap CommandsMap = new HashMap();
    
    public Profile() {
        super();
        CommandsMap.put("View", 1);
        CommandsMap.put("Edit", 2);
    }
    
	public void doPost() {
		// TODO - implement Profile.doPost
		throw new UnsupportedOperationException();
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String args[] = Utils.SplitRequestPath(request);
        int command = 0;
        try {
            command = (Integer) CommandsMap.get(args[2]);
        } catch (Exception e) {
            Message.message("There was an error proccessing your request. ", request, response);
            return;
        }

        try {
            switch (command) {
                case 1:
                    // Maybe allow viewing of others profiles?
                    viewProfile(request, response);
                    break;
                case 2:
                    updateProfile(request, response);
                    break;
                default:
                    Message.message("There was an error proccessing your request. ", request, response);
            }
        } catch (ArrayIndexOutOfBoundsException oobex) {
            Message.message("There was an error proccessing your request. ", request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String mobile = request.getParameter("mobile");
        String contactNumber = request.getParameter("contactNumber");
        String yearOfStudy = request.getParameter("yearOfStudy");
        String matricNumber = request.getParameter("matricNumber");
        //TODO fill in other values
        Boolean youngES_FLAG = false;//Boolean.parseBoolean(request.getParameter("youngES_FLAG"));
        String country = "unknown";//request.getParameter("country");
        String institution = "unknown";//request.getParameter("institution");
        String status = "unknown";//request.getParameter("status");
        String college = "unknown";//request.getParameter("college");
        String degree = "unknown";//request.getParameter("degree");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        int userID = ud.getUserID();
        
        ud.setUsername(username);
        ud.setEmail(email);

        UserProfile up = new UserProfile();
        up.setFirstName(firstname);
        up.setLastName(lastname);
        up.setMobile(mobile);
        up.setContactNumber(contactNumber);
        up.setYearOfStudy(yearOfStudy);
        up.setMatricNumber(matricNumber);
        up.setYoungES_FLAG(youngES_FLAG);
        up.setCountry(country);
        up.setInstitution(institution);
        up.setStatus(status);
        up.setCollege(college);
        up.setDegree(degree);
        
        UserModel user = new UserModel();
        try
        {
            user.updateProfile(up, ud);
        }
        catch (Exception e)
        {
            Message.message("There was an error proccessing your request. "+ e.toString(), request, response);
            return;
        }      
        
        request.setAttribute("profile", up);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/displayProfile.jsp");
        view.include(request, response);
    }
    
   
    private void viewProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        
        UserModel user = new UserModel();
        UserProfile up;
        try
        {
            up = user.fetchUserProfile(ud.getUserID());
        }
        catch (Exception e)
        {
            Message.message("There was an error proccessing your request. "+ e.toString(), request, response);
            return;
        }
        
        request.setAttribute("profile", up);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/displayProfile.jsp");
        view.include(request, response);
    }
    
    private void updateProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        
        UserModel user = new UserModel();
        DemographicModel dm = new DemographicModel();
        UserProfile up;
        ArrayList<InstitutionStore> is = new ArrayList<InstitutionStore>();
        ArrayList<CountryStore> cs = new ArrayList<CountryStore>();
        ArrayList<StatusStore> sts = new ArrayList<StatusStore>();
        try
        {
            up = user.fetchUserProfile(ud.getUserID());
            //up.setFirstName("bob");
            //user.updateProfile(up, ud);
           // is = dm.fetchInstitutions();
           // cs = dm.fetchCountries();
           // sts = dm.fetchStatuses();
        }
        catch (Exception e)
        {
            Message.message("There was an error proccessing your request. "+ e.toString(), request, response);
            return;
        }
        
        request.setAttribute("profile", up);
        request.setAttribute("details", ud);
        request.setAttribute("countries", cs);
        request.setAttribute("statuses", sts);
        request.setAttribute("institutions", is);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/editProfile.jsp");
        view.include(request, response);
    }

}