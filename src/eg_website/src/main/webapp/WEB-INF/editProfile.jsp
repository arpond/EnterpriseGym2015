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
        <%@include file="/WEB-INF/includes/scripts.jsp" %>

        <title>Update Profile</title>
    </head> 

    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %> 
        <div class="container">
            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Update Profile

                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="active">Update Profile</li>
                    </ol>
                </div>
            </div>   
        </div>


        <div class="container" style="border:20px transparent; max-width:600px">

            <form class="updateForm" method="POST"  action="View" >
                <div class="form-group">
                    <ul>
                        <label for="input">First Name </label>
                        <input type="text" class="form-control" name="firstname" value="<%=up.getFirstName()%>">

                        <label for="input">Last Name </label>
                        <input type="text" class="form-control" name="lastname" value="<%=up.getLastName()%>">

                        <label for="input">Mobile</label>
                        <input type="text" class="form-control" name="mobile" value="<%=up.getMobile()%>">

                        <label for="input">Contact Number</label>
                        <input type="text" class="form-control" name="contactNumber" value="<%=up.getContactNumber()%>">

                        <label for="input">Matric Number </label>
                        <input type="text" class="form-control" name="matricNumber" value="<%=up.getMatricNumber()%>">

                        <label for="input">Email  </label>
                        <input type="text" class="form-control" name="email" value="<%=ud.getEmail()%>">

                        <input type="hidden" class="form-control" name="owner" value="<%=ud.getUsername()%>" id="updateButton">

                    </ul>

                    <button type="submit" class="btn btn-default" style="display:block;margin: 0 auto;" value="update" name="action">Update</button> 
                </div>
            </form>
        </div>



    </body>

    <footer>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </footer>

</html>
