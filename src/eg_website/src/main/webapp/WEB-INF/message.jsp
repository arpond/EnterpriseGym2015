<%-- 
    Document   : Message
    Created on : 21-Sep-2015, 11:30:07
    Author     : Andrew
--%>

<!--Imports not correct-->
<%@page import="uk.ac.dundee.team7.eg_website.Store.UserDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Needs Changing-->    <meta http-equiv="refresh" content="5; url=http://silva.computing.dundee.ac.uk/2015-indteam7/" />
        <title>Message</title>
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
        <br><br><br>
        <div class= container style="text-align:center;">
            <article>
                <br/>
                <h3>
                    <%
                        String message = (String) request.getAttribute("message");
                        out.print(message);
                    %>
                </h3>
                <br>
                <h3>You will be redirected to the index in 5 seconds... or return to <a href="/2015-indteam7/">Homepage</a></h3>
            </article>
        </div>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>
</html>
