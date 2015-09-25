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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <%@include file="/includes/scripts.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/includes/normalHeader.jsp" %>
        <title>Event</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/modern-business.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    </head>

    <body>

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
            </div>
            <!-- Blog Sidebar Widgets Column -->
            <div class="col-md-4">



                <!-- Blog Categories Well -->
                <div class="well">

                    <div class="row">

                        <%
                            if (eventImage != "") {
                        %>
                        <img src="<%=eventImage%>" width="200" height="250" />
                        <%
                            }
                        %>


                        <%
                            if (ud != null && !attending) {
                        %>

                        <form method="POST"  action="Event">
                            <input type="hidden" name="eventID" value="<%=ev.getEventID()%>">
                            <input type="submit" value="Event" class="button" id="signUpButton">
                        </form>

                        <% }%>
                        <h4>Event Type: <%=ev.getEventPointType()%> Points: <%=ev.getEventValue()%></h4>
                        <h4>Start Time: <%=ev.getEventStartTime()%></h4>
                    </div>
                    <!-- /.row -->
                </div>



            </div>

        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <%@include file="/includes/normalFooter.jsp" %>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
