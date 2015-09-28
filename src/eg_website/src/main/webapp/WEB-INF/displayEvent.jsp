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

            <div class="row">
                <div class="col-lg-8">
                    <%
                        out.print(ev.getContent().getContent());
                    %>
                </div>
            </div>

            <div class="col-md-4">
                <div class="well">
                    <div class="row">
                        <%
                            if (eventImage != "") {
                        %>

                        <img src="<%=eventImage%>" style="height:auto; width:auto; max-height:320px; max-width:320px; display:block; margin-left:auto; margin-right:auto; ">
                        <%
                            }
                        %>

<<<<<<< Updated upstream
                        <form method="POST"  action="SignUpForEvent">
                            <input type="hidden" name="eventID" value="<%=ev.getEventID()%>">
                            <input type="submit" value="Sign up" class="button" id="signUpButton">
                        </form>

                        <% }%>
                        <h4>Event Type: <%=ev.getEventPointType()%> Points: <%=ev.getEventValue()%></h4>
                        <h4>Start Time: <%=ev.getEventStartTime()%></h4>
=======
                        <div class="random" style="text-align: center;"> 
                            <%
                                if (ud != null && !attending) {
                            %>
                            <br>

                            <form method="POST"  action="Event">
                                <input type="hidden" name="eventID" value="<%=ev.getEventID()%>">
                                <input type="submit" value="Sign up" class="button" id="signUpButton">
                            </form>
                            <% }%>
                            <br>

                            <p>Event Type: <%=ev.getEventPointType()%> </p>
                            <p>Points: <%=ev.getEventValue()%></p>
                            <!-----<p>Start Time: <%=ev.getEventStartTime()%></p>!---------->
                        </div>
>>>>>>> Stashed changes
                    </div>
                </div>
            </div>
        </div>
    
    <!-- /.container -->
</body>   

<footer>
    <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
</footer>

</html>
