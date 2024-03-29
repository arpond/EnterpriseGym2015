<%-- 
    Document   : displayAllNews
    Created on : 22-Sep-2015, 10:43:14
    Author     : williamneal
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="org.joda.time.format.*"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>All News</title>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
       <div class="container">
        
         
            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">News
                        <small>by <a href="#">Enterprise Gym</a>
                        </small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="active">News></li>
                    </ol>
                </div>
            </div>
                    
       <div class="row">      
           
        <%
            //Get arraylist here
            
            ArrayList<NewsStore> alNews = new ArrayList();
            alNews = (ArrayList<NewsStore>) request.getAttribute("news");
            Iterator i1 =  alNews.iterator();
            
            DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MMMM dd, yyyy");
            
            while (i1.hasNext())
            {
                NewsStore ns = (NewsStore) i1.next();
                %>
    <div class="container">
        <hr>
       
        <div class="newsContent">
         <div class="col-md-4">
            <img class="img-responsive img-hover" src="<%=ns.getNewsImage()%>"/>
            
         </div>
            
            <div class="col-md-8">
            <p>
                 <h4><a href="/eg_website/<%=ns.getContent().getContentPath()%>"><%=ns.getContent().getContentTitle()%></a></h4>
                 <h5><%=dtfOut.print(ns.getPostedTime())%></h5>
            </p>
            <p><%=ns.getContent().getContentSummary()%></p>
            <%-- <p class="posted"><%=ns.getPostedTime().toString()%></p>
            <p class="category"><%=ns.getCategoryName()%></p> --%>
            <a href="/eg_website/<%=ns.getContent().getContentPath()%>">Read More..</a>
            </div>
            
        </div>
    </div>
                <%                            
            }
        %>
        </div>
        
        
        
    </div>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>
</html>
