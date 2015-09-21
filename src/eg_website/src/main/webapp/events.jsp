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
        int eventID = ev.getEventID();
        DateTime timePosted = ev.getPostedTime();
        int eventValue = ev.getEventValue();
        String eventImage= ev.getEventImage();
        ContentStore content = ev.getContent();
        DateTime startTime = ev. getEventStartTime();
        
    %>
    
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events</title>
    </head>
     <body>
        <%
          out.println("Event ID:" + eventID);
          out.println(timePosted);
          out.println(eventValue);
          out.println(eventImage);
          out.println(content);
          out.println(startTime);
        %>
    </body>
</html>
