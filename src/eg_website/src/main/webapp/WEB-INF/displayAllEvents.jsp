<%--
 Document   : eventsList
    Created on : 23-Sep-2015, 14:19:09
    Author     : Katerina
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.ContentStore"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="org.joda.time.format.*"%>
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
        <script src="/eg_website/js/dxhtmlxscheduler/dhtmlxscheduler.js" type="text/javascript"></script>
        <script src="/eg_website/js/dxhtmlxscheduler/dhtmlxschedule_minical.js" type="text/javascript"></script>
        <script src="/eg_website/js/dxhtmlxscheduler/dhtmlxscheduler_container_autoresize.js" type="text/javascript"></script>
        <link rel="stylesheet" href="/eg_website/css/dhtmlxscheduler.css" type="text/css">

    </head>

    <body onload="init();">
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
            <div class="container">
             <div id="scheduler_here" class="dhx_cal_container" 
                         style='width:1100px; height:400px; padding:5px;'>
                        <div class="dhx_cal_navline">
                            <div class="dhx_cal_prev_button">&nbsp;</div>
                            <div class="dhx_cal_next_button">&nbsp;</div>
                            <div class="dhx_cal_today_button"></div>
                            <div class="dhx_cal_date"></div>
                            
                            <div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>
                        </div>
                        <div class="dhx_cal_header"></div>
                        <div class="dhx_cal_data"></div>
             </div>
            </div>
            <div class="row">  
                  
                       
                <%
                    ArrayList<EventStore> alEvents = new ArrayList();
                    alEvents = (ArrayList<EventStore>) request.getAttribute("events");
                    Iterator i1 = alEvents.iterator();
                    DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MMMM dd, yyyy");
                    while (i1.hasNext()) {

                        EventStore es = (EventStore) i1.next();

                %>
                
                <div class="container">
                     <hr>

                    <div class="col-md-4">

                        <div>
                            <img class="img-responsive img-hover" src="<%=es.getEventImage()%>" width="300" height="200" > </img>

                        </div>
                    </div>
                        
                        
                    <div class="col-md-8">  
                        <p>
                        <h4><a href="/eg_website<%=es.getContent().getContentPath()%>"><%=es.getContent().getContentTitle()%></a></h4>
                        <h5><%=dtfOut.print(es.getEventStartTime())%></h5>
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
    <script type="text/javascript" charset="utf-8">
                            function init() {
                                scheduler.config.readonly = true;
                                //scheduler.config.xml_date = "%Y-%m-%d %H:%i";
                                scheduler.config.container_autoresize = false;
                                var now = Date.now;
                                scheduler.init('scheduler_here', new Date(), "month");
                                scheduler.config.max_month_events = 2;
                                
                                parseTest();

                            }
                            // scheduler.load("connector/Connector.php");
                        </script>
                        <script type="text/javascript" charset="utf-8">
                            function parseTest() {
                            <%
                                    int j = 0;
                                    DateTimeFormatter dtfOutCal = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm");
                                    while (alEvents.size() > j) {
                                        EventStore currentEvent = alEvents.get(j);
                                        ContentStore currentContent = currentEvent.getContent();

                                        String contentTitle = currentContent.getContentTitle();
                                        String startTime = dtfOutCal.print(currentEvent.getEventStartTime());
                                        String endTime = dtfOutCal.print(currentEvent.getEventEndTime());

                            %>
                                scheduler.parse([
                                    {text: "<%=contentTitle%>",
                                        start_date: "<%=startTime%>",
                                        end_date: "<%=endTime%>"},
                                ], "json");
                            <%j++;
                                    }%>
                            }
                        </script>
    <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
</body>

</html>