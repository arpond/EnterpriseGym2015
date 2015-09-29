<%-- 
    Document   : manageGroups
    Created on : 26-Sep-2015, 10:24:44
    Author     : Andrew
--%>

<%@page import="java.util.HashMap"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.UserStore"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

 <%
        ArrayList<UserStore> users = (ArrayList<UserStore>) request.getAttribute("userList");
        HashMap groups = (HashMap) request.getAttribute("groupList");
        Object[] groupIDs = groups.keySet().toArray();
    %>
    
<html>
    <head>
        <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/adminNav.jsp" %>
        <div id="wrapper">

            <div id="page-wrapper">
                
                                
            </div>
        </div>
    </body>
</html>
