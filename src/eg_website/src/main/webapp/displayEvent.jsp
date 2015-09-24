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
<html>
    
    <%  EventStore ev = (EventStore) request.getAttribute("event");
        Boolean attending = (Boolean) request.getAttribute("attending");
        
        int eventID = ev.getEventID();
        DateTime timePosted = ev.getPostedTime();
        int eventValue = ev.getEventValue();
        String eventImage= ev.getEventImage();
        String showContent = ev.getContent().getContent();
        DateTime startTime = ev.getEventStartTime();
        
    %>
    
    <head>
        <%@include file="/includes/scripts.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events</title>
    </head>
     <body>
        <%@include file="/includes/normalHeader.jsp" %>
        <h1><%=ev.getContent().getContentTitle()%></h1>
        <div>
            <p>Event Type: <%=ev.getEventPointType()%> Points: <%=ev.getEventValue()%></p>
            <p>Start Time: <%=ev.getEventStartTime()%></p>
        </div>
        <%
            if (eventImage != "")
            {
        %>
        <img src="<%=eventImage%>"/>
        <%  
            }
        %>
        <div>
        <%
          out.println(ev.getContent().getContent());
        %>
        </div>
        <%
          if (ud != null && !attending) 
          {
        %>
        <div>
            <form method="POST"  action="Event">
                <input type="hidden" name="eventID" value="<%=ev.getEventID()%>">
                <input type="submit" value="Event" class="button" id="signUpButton">
            </form>
        </div>
        <% } %>
        <%@include file="/includes/normalFooter.jsp" %>
    </body>
</html>
