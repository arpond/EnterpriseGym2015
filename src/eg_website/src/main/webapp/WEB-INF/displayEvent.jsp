<%-- 
    Document   : events
    Created on : 21-Sep-2015, 14:39:47
    Author     : Katerina
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.ContentStore"%>
<%@page import="org.joda.time.DateTime"%>
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
            <!-- /.row -->

            <!-- Content Row -->
            <div class="row">

                <!-- Blog Post Content Column -->
                <div class="col-lg-8">


                    <!-- Post Content -->

                    <%
                        out.print(ev.getContent().getContent());
                    %>


                </div>
                <div class="col-md-4">
                    <%
                        if (eventImage != "") {
                    %>
                    <img class="img-responsive" src="<%=eventImage%>" width="200" height="250" />
                    <%
                        }
                    %>


                    <%
                        if (ud != null && !attending) {
                    %>

                    <form method="POST"  action="SignUpForEvent">
                        <input type="hidden" name="eventID" value="<%=ev.getEventID()%>">
                        <input type="submit" value="Sign up" class="button" id="signUpButton">
                    </form>

                    <% }%>
                    <h4>Event Type: <%=ev.getEventPointType()%> Points: <%=ev.getEventValue()%></h4>
                    <h4>Start Time: <%=ev.getEventStartTime()%></h4>
                </div>
            </div>

        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
        </footer>

    </div>
    <!-- /.container -->
</body>
</html>
