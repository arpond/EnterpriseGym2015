<%-- 
    Document   : login.jsp
    Created on : Sep 28, 2014, 12:04:14 PM
    Author     : Kat & Will
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.UserDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="/WEB-INF/includes/scripts.jsp" %>

        <title>Log In</title>
    </head> 

    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
        <div class="container">
            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Log In

                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="active">Log In</li>
                    </ol>
                </div>
            </div>   
        </div>

        <div class="container" style="border:20px transparent; max-width:600px">

            <form class="updateForm" method="POST"  action="/eg_website/Login" id="Login"> 
                <div class="form-group">
                    <ul>
                        <label for="input">User Name </label>
                        <input type="text" class="form-control" name="username" data-validate="required"><br>

                        <label for="input">Password </label>
                        <input type="password" class="form-control" name="password" data-validate="required"><br>


                    </ul>
                    <button type="submit" id="loginButton" class="btn btn-default" style="display:block;margin: 0 auto;" value="Login" name="action">Log In</button> 
                </div>
            </form>
        </div> 

    </body>

    <footer>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </footer>
</html>