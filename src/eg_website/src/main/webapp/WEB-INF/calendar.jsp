
<%@page import="uk.ac.dundee.team7.eg_website.Store.ContentStore"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="java.util.Iterator"%>
<%@page import="uk.ac.dundee.team7.eg_website.model.EventModel"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.EventStore"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.UserDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calendar</title>
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <title>How to start</title>
        <script src="/eg_website/js/dxhtmlxscheduler/dhtmlxscheduler.js" type="text/javascript"></script>
        <link rel="stylesheet" href="/eg_website/css/dhtmlxscheduler.css" type="text/css">
    </head>

    <%
        ArrayList<EventStore> alEvents = new ArrayList();
        alEvents = (ArrayList<EventStore>) request.getAttribute("events");
        Iterator i1 = alEvents.iterator();
        String toParse = "";
        while (i1.hasNext()) {
            
            EventStore es = (EventStore) i1.next();
            int eventID = es.getEventID();
            ContentStore content = es.getContent();
            DateTime eventStartTime = new DateTime();//es.getEventStartTime();
            DateTime eventEndTime = new DateTime();//es.getEventEndTime();
            if (!i1.hasNext()) {
                    toParse = toParse + "{id:" + Integer.toString(eventID) + ",start_date:"
                            + eventStartTime.toString() + ",end_date:" + eventEndTime.toString()
                            + ",text:" + content.getContentSummary() + "}";
                } else {
                    toParse = toParse + "{id:" + Integer.toString(eventID) + ",start_date:"
                            + eventStartTime.toString() + ",end_date:" + eventEndTime.toString()
                            + ",text:" + content.getContentSummary() + "},";
                }
        }
    %>

    <body onload="init();">
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
        <article>
            <h3>Edit Calendar</h3>
            <div id="scheduler_here" class="dhx_cal_container" 
                 style='width:1250px; height:400px; padding:10px;'>
                <div class="dhx_cal_navline">
                    <div class="dhx_cal_prev_button">&nbsp;</div>
                    <div class="dhx_cal_next_button">&nbsp;</div>
                    <div class="dhx_cal_today_button"></div>
                    <div class="dhx_cal_date"></div>
                    <div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div>
                    <div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div>
                    <div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>
                </div>
                <div class="dhx_cal_header"></div>
                <div class="dhx_cal_data"></div>  

                <script type="text/javascript" charset="utf-8">
                    function init() {

                        scheduler.config.xml_date = "%Y-%m-%d %H:%i";
                        scheduler.init('scheduler_here', new Date(2015, 0, 10), "week");
                        string StringToJson = "<%=toParse%>"
                        scheduler.parse([StringToJson
                        ], "json");
                    }
                    // scheduler.load("connector/Connector.php");
                </script>
            </div>
        </article> 
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>

    </body>
</html>