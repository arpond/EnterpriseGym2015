
<%--
   /* global CKEDITOR */

/* global CKEDITOR */

 Document   : eventsList
    Created on : 23-Sep-2015, 14:19:09
    Author     : Katerina
--%>
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

   <title>All Events</title>
   
    <%@include file="/includes/scripts.jsp" %>
    
</head>
<body>
        <%@include file="/includes/normalHeader.jsp" %>
        
        
    <div>
      <textarea cols="80" rows="10" id="content" name="content"> 
        
      </textarea>
      <script type="text/javascript">
        
    
    CKEDITOR.replace( 'content' );
      </script>
      <input type="submit" value="Submit"/>
    </div>
  
        
        
        <%
          
            
            ArrayList<EventStore> alEvents =  new ArrayList();
             alEvents = (ArrayList<EventStore>) request.getAttribute("events");
            Iterator i1 =  alEvents.iterator();
            
            while (i1.hasNext())
            {
                
                EventStore es = (EventStore) i1.next();
                
        %>
    <div class="newsItem">
        <h2><a href="/eg_website<%=es.getContent().getContentPath()%>"><%=es.getContent().getContentTitle()%></a></h2>
        <div>
            <p>Event Type: <%=es.getEventPointType()%> Points: <%=es.getEventValue()%></p>
        </div>
        <div class="eventContent">
            <img src="<%=es.getEventImage()%>"/>
            <p><%=es.getContent().getContentSummary()%></p>
            <%--<p class="posted"><%=es.getPostedTime().toString()%></p>
            <p class="Type"><%=es.getEventPointType()%></p>
            <p class="Points Type"><%=es.getEventValue()%></p>
            <p class="Event Start Time"><%=es.getEventStartTime().toString()%></p>--%>
            <a href="/eg_website<%=es.getContent().getContentPath()%>">Read more...</a>
        </div>
    </div>
                <%                            
            }
        %>
      
        <%@include file="/includes/normalFooter.jsp" %>
    </body>

</html>