<%-- 
    Document   : displayProfile
    Created on : 21-Sep-2015, 15:55:36
    Author     : Katerina
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.UserProfile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%  UserProfile userp = (UserProfile) request.getAttribute("profile");
        String firstName = userp.getFirstName();
        String lastName = userp.getLastName();
        String mobile = userp.getMobile();
        String contactNumber = userp.getContactNumber();
        String studyYear = userp.getYearOfStudy();
        String matricNo = userp.getMatricNumber();
        String country = userp.getCountry();
        String institution = userp.getInstitution();
        String status = userp.getStatus();
        String college = userp.getCollege();
        String degree = userp.getDegree();

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <title>Profile</title>

    </head>
    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
        <% HashMap points = ud.getPoints();

        %>

        <div class="details">
            <h1>Your Profile - <%=ud.getUsername()%> </h1>
            <p><%out.println("First name: " + firstName);%></p>
            <p><%out.println("Last name: " + lastName);%></p>
            <p><% out.println("Mobile: " + mobile);%></p>
            <p><% out.println("Contact Number: " + contactNumber);%></p>
            <p><% out.println("Study Year: " + studyYear);%></p>
            <p><% out.println("Matriculation Number: " + matricNo);%></p>
            <p><% out.println("Country: " + country);%></p>
            <p><% out.println("Institution: " + institution);%></p>
            <p><% out.println("Status: " + status);%></p>
            <p><% out.println("College: " + college);%></p>
            <p><% out.println("Degree: " + degree);%></p>
            <style>
                table,tr,th,td{
                    border: 2px solid black;
                    padding: 20px;
                    table-layout: auto;
                }
            </style>
            <h2>Your Points</h2>
            <div class="pointsTable" >
                <table>
                    <tr>
                    <u><th><b><h3>Category</h3></b></th></u>
                    <u><th><h3>Points</h3></th></u>
                    </tr>
                    <tr>
                        <%
                            Set set = points.entrySet();
                            Iterator i = set.iterator();
                            while (i.hasNext()) {
                                Map.Entry me = (Map.Entry) i.next();

                        %>                 
                        <th><b><h5><%out.println(me.getKey());%>   </h5></b></th>
                        <th><h5> <%out.println(me.getValue());%></h5></th>
                    </tr>
                    <%
                        }
                    %>



                </table>
            </div>
        </div>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>
</html>
