<%-- 
    Document   : manageUsers
    Created on : 26-Sep-2015, 10:20:53
    Author     : Andrew
--%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        ArrayList<UserStore> users = (ArrayList<UserStore>) request.getAttribute("users");

    %>
    <head>
        <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/adminNav.jsp" %>
        <div id="wrapper">

            <div id="page-wrapper">
                <table cellpadding="1" cellspacing="1" id="resultTable">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Mobile</th>
                            <th>Contact Number</th>
                            <th>Country</th>
                            <th>Status</th>
                            <th>Institution</th>
                            <th>College</th>
                            <th>Degree</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%                        
                    for (int i = 0; i < users.size(); i++) {
                                UserDetails ud = users.get(i).getUd();
                                UserProfile up = users.get(i).getUp();
                        %>
                        <tr>
                            <td><%=ud.getUsername()%></td>
                            <td><%=up.getFirstName()%></td>
                            <td><%=up.getLastName()%></td>
                            <td><%=ud.getEmail()%></td>
                            <td><%=up.getMobile()%></td>
                            <td><%=up.getContactNumber()%></td>
                            <td><%=up.getCountry()%></td>
                            <td><%=up.getStatus()%></td>
                            <td><%=up.getInstitution()%></td>
                            <td><%=up.getCollege()%></td>
                            <td><%=up.getDegree()%></td>
                        </tr>
                        <%
                    }
                        %>
                    </tbody>
                </table>

            </div>
        </div>
    </body>
</html>
