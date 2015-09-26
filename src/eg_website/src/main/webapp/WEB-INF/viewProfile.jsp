<%-- 
    Document   : viewProfile
    Created on : 22-Sep-2015, 14:42:30
    Author     : Katerina
--%>
<!DOCTYPE html>

<%@page import="uk.ac.dundee.team7.eg_website.Store.*"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>View Profile</title>

    <%@include file="/WEB-INF/includes/scripts.jsp" %>
</head>

<body>
    <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
    <div class="container">

        <div class="row">
            <div class="col-md-3">
                <div class="list-group">
                    <a href="contact.html" class="list-group-item">Edit Profile</a>
                    <a href="about.html" class="list-group-item">Delete Profile</a>      
                </div>
            </div>
            
<div class="col-md-9">
<h2>Student Profile</h2>                
				
<%  UserProfile up = (UserProfile) request.getAttribute("profile");
    UserDetails ud = (UserDetails) request.getAttribute("content");
       String fname = up.getFirstName();
       String sname = up.getLastName();
       String mobile = up.getMobile();
       String number = up.getContactNumber();
       String year = up.getYearOfStudy();
       String matric = up.getMatricNumber();
       String country= up.getCountry();
       String institution = up.getInstitution();
       String college = up.getCollege();
       String degree = up.getDegree();
       String userName = ud.getUsername();
       String email = ud.getEmail();
%>
       
<p>Students Information
     <ul>
      <%
         out.println( "Name:" + fname + " " + sname);
         out.println( "Mobile no:" + mobile + " Phone no: " + number);
         out.println( "Year of Study:" + year + " Matric No: " + matric);
         out.println( "Country: " + country + " Institution: " + institution);
         out.println( "College: " + college + " Degree: " + degree);
         out.println( "Username: " + userName + " Email: " + email);
      %>
     </ul>
</p>
 </div>
        </div>
               </div>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
</body>

</html>