<%-- 
    Document   : updateProfile.jsp
    Created on : 23-Sep-2015, 09:39:03
    Author     : Andrew
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.UserProfile"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.UserDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%  UserProfile up = (UserProfile) request.getAttribute("profile");
        UserDetails ud = (UserDetails) request.getAttribute("details");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Profile</title>
        
        <div id="updateProfile">
            <h3>Update Profile</h3>
            <form id="updateForm" method="POST"  action="View" >
                <ul>
                    <li><label class="input">First Name </label><input type="text" name="firstname" value="<%=up.getFirstName()%>"></li>
                    <li><label class="input">Last Name </label><input type="text" name="lastname" value="<%=up.getLastName()%>"></li>
                    <li><label class="input">Mobile</label><input type="text" name="mobile" value="<%=up.getMobile()%>"></li>
                    <li><label class="input">Contact Number</label><input type="text" name="contactNumber" value="<%=up.getContactNumber()%>"></li>
                    
                    <li><label class="input">Matric Number </label><input type="text" name="matricNumber" value="<%=up.getMatricNumber()%>"></li>
                    <li><label class="input">Email  </label><input type="text" name="email" value="<%=ud.getEmail()%>"></li>
                    <input type="hidden" name="owner" value="<%=ud.getUsername()%>" id="updateButton">
                    
                </ul>
                <input type="submit" value="update" name="action" class="button"> 
            </form>
        </div>
    </head>
    <body>
        
    </body>
</html>
