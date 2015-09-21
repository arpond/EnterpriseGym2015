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
        String contentInfo = cs.getContent();%>
 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
          out.println(contentInfo);
        %>
    </body>
</html>
