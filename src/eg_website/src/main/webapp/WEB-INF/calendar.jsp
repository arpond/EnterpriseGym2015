
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.CalendarStore"%>
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
        ArrayList<CalendarStore> alEventsJson = new ArrayList();
        Iterator i1 = alEvents.iterator();
        String toParse="";
        //String toParse = "[{id=\"1\",text:\"You and Your Team\",eventStartTime:\"04/11/2015 14:00\",eventEndTime:\"04/11/2015 14:00\"}]";
        while (i1.hasNext()) {
            
            EventStore es = (EventStore) i1.next();
            int eventID = es.getEventID();
            ContentStore content = es.getContent();
            
            String date = "04/11/2015 14:00";
            CalendarStore toStore = new CalendarStore(date,content.getContentTitle(),date);
            alEventsJson.add(toStore);
        }
        Gson gson = new Gson();
        toParse = gson.toJson(toParse);
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

                <script type="application/javascript" charset="utf-8">
    

function getUrlVars(url) {
    var hash;
    var myJson = {};
    var hashes = url.slice(url.indexOf('?') + 1).split('&');
    for (var i = 0; i < hashes.length; i++) {
        hash = hashes[i].split('=');
        myJson[hash[0]] = hash[1];
    }
    return myJson;
}
                </script>

                <script type="text/javascript" charset="utf-8">
                    function init() {
                        var params = getUrlVars('text=You and Your Team&eventStartTime=11/11/2015 14:00&eventEndTime=12/11/2015 18:00');
                        console.log(params);
                        //scheduler.config.xml_date = "%Y-%m-%d %H:%i";
                        scheduler.init('scheduler_here', new Date(2015, 0, 10), "week");
                        scheduler.parse([
    {text:"Fun Enterprise Event",    start_date:"09/11/2015 14:00", end_date:"09/11/2015 17:00"},
    {text:"Virtual Revision Class", start_date:"09/15/2015 12:00", end_date:"09/18/2015 19:00"},
    {text:"Project Deadline",  start_date:"09/24/2015 09:00", end_date:"09/24/2015 10:00"},
    {text:"Fun Enterprise Event",    start_date:"09/12/2015 14:00", end_date:"09/12/2015 17:00"},
    {text:"Virtual Revision Class", start_date:"09/13/2015 12:00", end_date:"09/13/2015 19:00"},
    {text:"Project Deadline",  start_date:"09/27/2015 09:00", end_date:"09/27/2015 10:00"},
    {text:"Fun Enterprise Event",    start_date:"09/20/2015 14:00", end_date:"09/21/2015 17:00"},
    {text:"Virtual Revision Class", start_date:"09/16/2015 12:00", end_date:"09/19/2015 19:00"},
    {text:"Project Deadline",  start_date:"09/24/2015 09:00", end_date:"09/25/2015 10:00"},
],"json");
                    }
                    // scheduler.load("connector/Connector.php");
                </script>
            </div>
        </article> 
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>

    </body>
</html>