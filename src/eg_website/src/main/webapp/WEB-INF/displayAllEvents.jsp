<%--
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

        <%@include file="/WEB-INF/includes/scripts.jsp" %>

    </head>

    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
        <div class="container">


            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Events
                        <small>by <a href="#">Enterprise Gym</a>
                        </small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="active">Events</li>
                    </ol>
                </div>
            </div>

            <div class="row">  
                 
                       
                <%
                    ArrayList<EventStore> alEvents = new ArrayList();
                    alEvents = (ArrayList<EventStore>) request.getAttribute("events");
                    Iterator i1 = alEvents.iterator();

                    while (i1.hasNext()) {

                        EventStore es = (EventStore) i1.next();

                %>
                <div class="container">
                     <hr>
                    <div class="col-md-1">
                        <p><i class="fa fa-camera fa-4x"></i>
                        </p>
                        <p>June 17, 2014</p>
                    </div>

                    <div class="col-md-5">

                        <div>
                            <img src="<%=es.getEventImage()%>" width="300" height="200" > </img>

                        </div>
                    </div>
                        
                        
                    <div class="col-md-6">  
                        <p>
                        <h4 href="/eg_website<%=es.getContent().getContentPath()%>"><%=es.getContent().getContentTitle()%></h4>
                        </p>
                        
                        <p>Event Type: <%=es.getEventPointType()%></p>
                        <p>Points: <%=es.getEventValue()%></p>
                        <%=es.getContent().getContentSummary()%>
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
            
        </div>
        </div>
    
    <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
</body>

</html>