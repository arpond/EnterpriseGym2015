
<%@page import="java.util.HashMap"%>
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
        <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
        <title>How to start</title>
        <script src="/eg_website/js/dxhtmlxscheduler/dhtmlxscheduler.js" type="text/javascript"></script>
        <script src="/eg_website/js/dxhtmlxscheduler/dhtmlxscheduler_container_autoresize.js" type="text/javascript"></script>
        <link rel="stylesheet" href="/eg_website/css/dhtmlxscheduler.css" type="text/css">
    </head>
    <%
        HashMap types = (HashMap) request.getAttribute("pointTypes");
        Object[] typeIDs = types.keySet().toArray();

        HashMap categoryTypes = (HashMap) request.getAttribute("categoryTypes");
        Object[] categoryTypeIDs = categoryTypes.keySet().toArray();%>


    <div id="wrapper">

        <div id="page-wrapper">
            <body onload="init();">
                <%@include file="/WEB-INF/includes/adminNav.jsp" %>

                <form method="POST"  action="addEvent" id="addEvent">
                    <div class="left" max-width:1000px>

                        <ul>
                            <table>
                                <h3>Add an Event</h3> <br>

                                <p><h4>Event Title <input type="text" name="eventTitle" style="margin: 10px;">
                                    Event Path <input type="text" name="eventPath" style="margin: 10px;">
                                    Image link <input type="text" name="eventLink" style="margin: 10px;">
                                </h4></p>

                                <p><h4> 
                                    Start Date <input type="text" name="daterange" class="input" value="01/01/2015" style="margin: 10px; width:110px" />
                                    End Date <input type="text" name="enddaterange" class="input" value="01/01/2015" style="margin: 10px;width:110px"/>

                                    Start Time (HH:MM) 
                                    <script type="text/javascript" >
                                        $(function () {
                                            $('input[name="daterange"]').daterangepicker({
                                                singleDatePicker: true,
                                                showDropdowns: true})
                                        });
                                    </script>

                                    <input type="text" class="timepicker" class="input" name="time" style="margin:10px;width:110px">
                                    <script type="text/javascript">
                                        $(document).ready(function () {
                                            $('input.timepicker').timepicker({});
                                        });
                                    </script>

                                    End Time (HH:MM)
                                    <script type="text/javascript">
                                        $(function () {
                                            $('input[name="enddaterange"]').daterangepicker({
                                                singleDatePicker: true,
                                                showDropdowns: true})
                                        });
                                    </script>

                                    <input type="text" class="timepicker" class="input" name="endtime" style="margin: 10px;width:110px">
                                    <script type="text/javascript">
                                        $(document).ready(function () {
                                            $('input.timepicker').timepicker({});
                                        });
                                    </script>
                                </h4></p>

                                <p><h4>   
                                    Point Type:
                                    <select name=ptTypes>
                                        <%for (int j = 0; j < typeIDs.length; j++) {%>
                                        <option value="<%=typeIDs[j]%>"><%=types.get(typeIDs[j])%></option>
                                        <% }%></select>

                                    &nbsp; Category:
                                    <select name=ctTypes>
                                        <% for (int j = 0; j < categoryTypeIDs.length; j++) {%>
                                        <option value="<%=categoryTypeIDs[j]%>"><%=categoryTypes.get(categoryTypeIDs[j])%></option>
                                        <%}%>
                                    </select>

                                    &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;
                                    Point Value: <input type="text" name="points" style="margin: 10px; width:110px;">
                                </h4></p>


                                <br><h4>Event Calendar</h4>
                                <article>
                                <div id="scheduler_here" class="dhx_cal_container" 
                                     style="width:900px; height:300px; border:10px solid black; display:block;margin: 0 auto; ">
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
                                </div>
                                <p><h4>Event Summary</h4></p> 
                                <textarea cols="80" placeholder="Event Summary" class="input" rows="5" id="eventSummary" name="eventSummary" style="min-width:960px;" >   
                                </textarea>  
                                <p><h4>Event Content</h4></p> 
                                <textarea cols="80" placeholder="Content" class="input" rows="10" id="eventContent" name="eventContent" style="min-width:960px;" >   
                                </textarea>
                            </table>
                        </ul>
                        <button type="submit" class="btn btn-default" style="display:block;margin: 0 auto;" id="addEvent" >Add Event</button>
                    </div>
        </div>
    </div>
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
            scheduler.config.container_autoresize = true;
            scheduler.xy.bar_height = 50;
            scheduler.xy.bar_width = 50;
            //scheduler.config.xml_date = "%Y-%m-%d %H:%i";
            var now = Date.now;
            scheduler.init('scheduler_here', new Date(2015, 10, 10), "month");
            scheduler.parse([
                {text: "Fun Enterprise Event", start_date: "09/11/2015 14:00", end_date: "09/11/2015 17:00"},
                {text: "Virtual Revision Class", start_date: "09/15/2015 12:00", end_date: "09/18/2015 19:00"},
                {text: "Project Deadline", start_date: "09/24/2015 09:00", end_date: "09/24/2015 10:00"},
                {text: "Fun Enterprise Event", start_date: "09/12/2015 14:00", end_date: "09/12/2015 17:00"},
                {text: "Virtual Revision Class", start_date: "09/13/2015 12:00", end_date: "09/13/2015 19:00"},
                {text: "Project Deadline", start_date: "09/27/2015 09:00", end_date: "09/27/2015 10:00"},
                {text: "Fun Enterprise Event", start_date: "09/20/2015 14:00", end_date: "09/21/2015 17:00"},
                {text: "Virtual Revision Class", start_date: "09/16/2015 12:00", end_date: "09/19/2015 19:00"},
                {text: "Project Deadline", start_date: "09/24/2015 09:00", end_date: "09/25/2015 10:00"},
            ], "json");
        }
        // scheduler.load("connector/Connector.php");
    </script>
</article> 

</body>
</html>