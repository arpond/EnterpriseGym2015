<%-- 
    Document   : displayProfile
    Created on : 21-Sep-2015, 15:55:36
    Author     : Katerina
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.UserProfile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%  UserProfile userp = (UserProfile) request.getAttribute("profile");
        String  firstName = userp.getFirstName();
        String  lastName = userp.getLastName();
        String  mobile = userp.getMobile();
        String  contactNumber = userp.getContactNumber();
        String  studyYear = userp.getYearOfStudy();
        String  matricNo = userp.getMatricNumber();
        String  country = userp.getCountry();
        String  institution = userp.getInstitution();
        String  status = userp.getStatus();
        String  college = userp.getCollege();
        String  degree = userp.getDegree();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
       
    </head>
    <body>
        <h1>Your Profile</h1>
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
       
    </body>
</html>
