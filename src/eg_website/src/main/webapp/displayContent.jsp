<%-- 
    Document   : displayContent.jsp
    Created on : 21-Sep-2015, 12:37:34
    Author     : Katerina
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.ContentStore"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%  ContentStore cs = (ContentStore) request.getAttribute("content");
        String contentInfo = cs.getContent();
        String contentTitle = cs.getContentTitle();%>
 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/includes/scripts.jsp" %>
        <title></title>
    </head>
    <body>
        <%@include file="/includes/normalHeader.jsp" %>
        <h1><%=contentTitle%></h1>
        <%
          out.println(contentInfo);
        %>
        <%@include file="/includes/normalFooter.jsp" %>
    </body>
</html>
