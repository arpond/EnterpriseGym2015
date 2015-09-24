<%-- 
    Document   : displayAllNews
    Created on : 22-Sep-2015, 10:43:14
    Author     : williamneal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/scripts.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>All News</title>
    </head>
    <body>
        <%@include file="/includes/normalHeader.jsp" %>
        <%
            //Get arraylist here
            
            ArrayList<NewsStore> alNews = new ArrayList();
            alNews = (ArrayList<NewsStore>) request.getAttribute("news");
            Iterator i1 =  alNews.iterator();
            
            while (i1.hasNext())
            {
                NewsStore ns = (NewsStore) i1.next();
                %>
    <div class="newsItem">
        <h2><a href="/eg_website/<%=ns.getContent().getContentPath()%>"><%=ns.getContent().getContentTitle()%></a></h2>
        <div class="newsContent">
            <img src=<%=ns.getNewsImage()%> ></img>
            <p><%=ns.getContent().getContentSummary()%></p>
            <%-- <p class="posted"><%=ns.getPostedTime().toString()%></p>
            <p class="category"><%=ns.getCategoryName()%></p> --%>
            <a href="/eg_website/<%=ns.getContent().getContentPath()%>">Read More..</a>
        </div>
    </div>
                <%                            
            }
        %>
        <%@include file="/includes/normalFooter.jsp" %>
    </body>
</html>
