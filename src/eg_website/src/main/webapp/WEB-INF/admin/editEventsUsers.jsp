<%-- 
    Document   : allEditableContent
    Created on : Sep 27, 2015, 10:23:22 AM
    Author     : dragomir
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.UserStore"%>
<%@page import="javax.swing.text.View"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.NewsStore"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.ContentStore"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.EventStore"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Event Attendees</title>

        <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
         <script src="/eg_website/js/users.js"></script>
        <script src="/eg_website/js/tables.js"></script>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/adminNav.jsp" %>
        
        <%
            String eventID = (String) request.getAttribute("eventID");
                           
            %>
        <div id="wrapper">
            <div id="page-wrapper">
                <div id="filterArea">
                    
                    <label for="filter">Filter</label>
                    <input type="text" name="filter" value="" id="filter" />
                </div>
                    <form method= "POST"  action = "markUsersAsAttended" id ="markUsersAsAttended"> 
                          <input hidden name="eventID" id="eventID" value="<%=eventID%>">
                <input type="submit" value="Edit Attendence for selected users" class="action" id="markUsersAsAttended">
                  
                
                <table cellpadding="1" cellspacing="1" id="resultTable" class="table table-bordered table-hover table-striped">
                    <thead>
                        <tr>
                            <th class="grp">Username</th>
                            <th class="un">First name</th>
                            <th class="grp">Last Name</th>
                            <th class="un">Email</th>
                            <th class="un">Year Of Study</th>
                            <th class="un">Attended</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<UserStore> nsL = new ArrayList();
                           
                            nsL = (ArrayList<UserStore>) request.getAttribute("getUsersForEvent");
                            Iterator i1 = nsL.iterator();
                        
                            while (i1.hasNext()) {
                                UserStore es = (UserStore) i1.next();
                        %>
                        <tr>
                            <td><%=es.getUd().getUsername()%></td>
                            <td><%=es.getUp().getFirstName()%> </td>
                            <td><%=es.getUp().getLastName()%> </td>
                            <td><%=es.getUd().getEmail()%></td> 
                            <td><%=es.getUp().getYearOfStudy()%> </td> 
                            <td>
                               
                            <input type="checkbox" value="<%=es.getUd().getUserID()%>">
                                    
                              
                            </td>
                        </tr>

                        <%
                            }
                        %>
                       
                    </tbody>
                </table>
                        </form>
            </div>
        </div>
    </body>

</html>