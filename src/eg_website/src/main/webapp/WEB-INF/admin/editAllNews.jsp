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

        <%@include file="/WEB-INF/includes/scripts.jsp" %>

    </head>
    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>

        <%
            ArrayList<NewsStore> nsL = new ArrayList();
            
            nsL = (ArrayList<NewsStore>) request.getAttribute("allNewsForEdit");
            Iterator i1 = nsL.iterator();
      
            
            
            
            while (i1.hasNext()) {
              
                NewsStore es = (NewsStore) i1.next();

        %>
        <form method="GET"  action="editNews" id="editNews">
            <div class="newsItem">
                <%            
                
                
                %>
                <h2><a href="/eg_website<%=es.getContent().getContentPath()%>"><%=es.getContent().getContentTitle()%></a></h2>

                <div class="Content">

                    <p><%=es.getContent().getContentSummary()%></p>
                   
                    <a href="/eg_website<%=es.getContent().getContentPath()%>">Read more...</a>
                   <input hidden name="path" value="<%=es.getContent().getContentPath()%>">
                    <input type="submit" value="Edit Content" class="button" id="editNews" name="${buttonID}">
                    </form>
                </div>
            </div>
            <%
           
           
                }
            
           
            %>

            <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>

</html>