<%-- 
    Document   : news
    Created on : 21-Sep-2015, 13:56:22
    Author     : williamneal
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News</title>
    </head>
    <body>
        <h1>News Page</h1>
        <%
           NewsStore ns = (NewsStore) request.getAttribute("news");
           int newsID = ns.getNewsID();
           DateTime postedTime = ns.getPostedTime();
           DateTime displayTime = ns.getDisplayTime();
           String newsImage = ns.getNewsImage();
           String newsCategory = ns.getCategoryName();
           ContentStore content = ns.getContent();
        %>
        
        <!-- DISPLAY NEWS ID, ETC HERE -->
    </body>
</html>
