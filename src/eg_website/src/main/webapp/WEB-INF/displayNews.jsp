<%-- 
    Document   : news
    Created on : 21-Sep-2015, 13:56:22
    Author     : Andrew Pond
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*" %>

<!DOCTYPE html>
<html>
    <%
           NewsStore ns = (NewsStore) request.getAttribute("news");
           DateTime postedTime = ns.getPostedTime();
           DateTime displayTime = ns.getDisplayTime();
           String newsImage = ns.getNewsImage();
           String newsCategory = ns.getCategoryName();
    %>
        
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <title>News</title>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
        <h1><%=ns.getContent().getContentTitle()%></h1>
        <%
            if (newsImage != "")
            {
        %>
        <img src="<%=newsImage%>"/>
        <%  
            }
        %>
        <%
          out.println(ns.getContent().getContent());
        %>
        <%-- <p>Category: <%=newsCategory%></p>
        <p>Posted at: <%=postedTime.toString()%></p>
        <p>Display at: <%=displayTime.toString()%> </p> --%>
        
        <!-- DISPLAY NEWS ID, ETC HERE -->
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>
</html>