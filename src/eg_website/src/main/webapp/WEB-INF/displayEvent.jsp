<%-- 
    Document   : events
    Created on : 21-Sep-2015, 14:39:47
    Author     : Katerina
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.ContentStore"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="org.joda.time.format.*"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.EventStore"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <%  EventStore ev = (EventStore) request.getAttribute("event");
        Boolean attending = (Boolean) request.getAttribute("attending");

        int eventID = ev.getEventID();
        DateTime timePosted = ev.getPostedTime();
        int eventValue = ev.getEventValue();
        String eventImage = ev.getEventImage();
        String showContent = ev.getContent().getContent();
        DateTime startTime = ev.getEventStartTime();
    %>

    <head>
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events</title>
    </head>

    <style>
        .table-user-information > tbody > tr {
            border-top: 1px solid rgb(221, 221, 221);
        }

        .table-user-information > tbody > tr:first-child {
            border-top: 0;
        }


        .table-user-information > tbody > tr > td {
            border-top: 0;
        }
    </style>

    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
        <div class="container">

            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><%=ev.getContent().getContentTitle()%>
                        <small>by <a href="#">Enterprise Gym</a>
                        </small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="active"><%=ev.getContent().getContentTitle()%></li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-8">
                    <%
                        out.print(ev.getContent().getContent());
                    %>
                </div>
                <div class="col-md-4">
                    <div class="container" style="max-width:360px; max-height:600px; text-align:center;"> 
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <center><h3 class="panel-title"><%=ev.getContent().getContentTitle()%></h3></center>
                            </div>
                            <div class="panel-body">
                                <table class=" table table-user-information">
                                    <%
                                        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MMMM dd, yyyy");
                                    %>

                                    <p><%=dtfOut.print(ev.getEventStartTime())%></p>               
                                    <%
                                        if (eventImage != "") {
                                    %>
                                    <img src="<%=eventImage%>" style="max-height:300px; max-width:300px;">
                                    <%
                                        }
                                    %>
                                    <%
                                        if (ud != null && !attending) {
                                    %>

                                    <p>
                                    <form method="POST"  action="Event">
                                        <input type="hidden" name="eventID" value="">
                                        <br> 
                                        <input type="submit" value="Sign up for the event" class="btn btn-default" style="display:block;margin: 0 auto;" id="signUpButton">
                                    </form>
                                    </p>
                                    <% }%>
                                    <p>Event Type: <%=ev.getEventPointType()%> </p>
                                    <p>Points: <%=ev.getEventValue()%></p>
                                </table>
                            </div>
                        </div>
                    </div> 
                </div>
            </div>


        </div>

    </body>   

    <footer>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </footer>
</html>
