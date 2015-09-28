<%-- 
    Document   : allEditableContent
    Created on : Sep 27, 2015, 10:23:22 AM
    Author     : dragomir
--%>

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

        <title>All News Content</title>

        <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
        <script src="/eg_website/js/tables.js"></script>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/adminNav.jsp" %>
        <div id="wrapper">
            <div id="page-wrapper">
                <div id="filterArea">
                    <label for="filter">Filter</label>
                    <input type="text" name="filter" value="" id="filter" />
                </div>
                <table cellpadding="1" cellspacing="1" id="resultTable" class="table table-bordered table-hover table-striped">
                    <thead>
                        <tr>
                            <th class="grp">Event Title</th>
                            <th class="un">Event Path</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<EventStore> nsL = new ArrayList();

                            nsL = (ArrayList<EventStore>) request.getAttribute("allEvensForEdit");
                            Iterator i1 = nsL.iterator();

                            while (i1.hasNext()) {
                                EventStore es = (EventStore) i1.next();
                        %>
                        <tr>
                            <td><%=es.getContent().getContentTitle()%></td>
                            <td>/eg_website<%=es.getContent().getContentPath()%></td>
                            <td>
                                <form method="GET"  action="EditUsersInEvent" id="EditUsersInEvent">
                                    <input hidden name="eventID" value="<%=es.getEventID()%>">
                                    <input type="submit" value="View Attendees" class="button" id="EditUsersInEvent">
                                    </form>
                                    </td>
                                    
                                    <td>
                                    <form method="GET"  action="EditEvent" id="EditEvent">
                                    <input hidden name="eventPath" value="<%=es.getContent().getContentPath()%>">
                                    <input type="submit" value="Edit Event" class="button" id="EditEvent">
                                </form>
                            </td>
                        </tr>

                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>

</html>