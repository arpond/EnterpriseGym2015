<%-- 
    Document   : allEditableContent
    Created on : Sep 27, 2015, 10:23:22 AM
    Author     : dragomir
--%>

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

   <title>All Events</title>
   
    <%@include file="/WEB-INF/includes/scripts.jsp" %>
    
</head>
<body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
  
        <%
          
            
            ArrayList<ContentStore> csL =  new ArrayList();
             csL = (ArrayList<ContentStore>) request.getAttribute("allContentForEdit");
            Iterator i1 =  csL.iterator();
            
            while (i1.hasNext())
            {
                
                ContentStore es = (ContentStore) i1.next();
                
        %>
           <form method="GET"  action="editContent" id="editContent">
    <div class="newsItem">
        <%
                request.getSession().setAttribute("SUBFAMILY", es.getContentPath());
                
                %>
        <h2><a href="/eg_website<%=es.getContentPath()%>"><%=es.getContentTitle()%></a></h2>
         
        <div class="Content">
            
            <p><%=es.getContentSummary()%></p>
            <%--<p class="posted"><%=es.getPostedTime().toString()%></p>
            <p class="Type"><%=es.getEventPointType()%></p>
            <p class="Points Type"><%=es.getEventValue()%></p>
            <p class="Event Start Time"><%=es.getEventStartTime().toString()%></p>--%>
            <a href="/eg_website<%=es.getContentPath()%>">Read more...</a>
            
            <input type="submit" value="Edit Content" class="button" id="editContent">
             </form>
        </div>
    </div>
                <%                            
            }
        %>
      
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>

</html>