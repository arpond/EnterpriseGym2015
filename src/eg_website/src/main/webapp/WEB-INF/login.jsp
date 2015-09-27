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

    </head>
    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
        <article>
            <h3>Login</h3>
            <form method="POST"  action="/eg_website/Login" id="Login">
                <div class="left">
                    <ul>
                        <li><label class="input">User Name</label> <input type="text" name="username" data-validate="required"></li>
                        <li><label class="input">Password</label> <input type="password" name="password" data-validate="required"></li>
                    </ul>
                </div>
                <div class="right"><input type="submit" value="Login" class="button" id="loginButton"></div>
            </form>
        </article> 
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>
</html>