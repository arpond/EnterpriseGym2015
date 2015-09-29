
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.joda.time.format.*"%>
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
        <script src="/eg_website/js/notify.min.js"></script>
        <script src="/eg_website/js/verify.notify.js"></script>
    </head>
    <%
        HashMap types = (HashMap) request.getAttribute("pointTypes");
        Object[] typeIDs = types.keySet().toArray();
        ArrayList<EventStore> events = (ArrayList) request.getAttribute("events");

        HashMap categoryTypes = (HashMap) request.getAttribute("categoryTypes");
        Object[] categoryTypeIDs = categoryTypes.keySet().toArray();%>


    <div id="wrapper">

        <div id="page-wrapper">
            <body onload="init();">
                <%@include file="/WEB-INF/includes/adminNav.jsp" %>

                <article>
                    <h3>Event Calendar</h3>
                    <div id="scheduler_here" class="dhx_cal_container" 
                         style='width:1100px; height:400px; padding:10px;'>
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
                    <form method="POST"  action="addEvent" id="addEvent">
                        <div class="left">
                            <h3>Add an Event</h3>
                            <ul>
                                <form>
                                <p></p>
                                <label class="input">Event Title</label> <input type="text" name="eventTitle" data-validate="required">
                                <p></p>
                                <label class="input">Event Path:  /Event/</label> <input type="text" name="eventPath" data-validate="required">
                                <p></p>
                                <label class="input">Event Image link</label> <input type="text" name="eventLink" data-validate="required">
                                <p></p>
                                <label>Event Start Date</label> 
                                <input type="text" name="daterange" class="input" value="01/01/2015" />
                                <p></p>
                                <label>Event Start Time (HH:MM)</label> 
                                <script type="text/javascript">
                                    $(function() {
                                        $('input[name="daterange"]').daterangepicker({
                                            singleDatePicker: true,
                                            showDropdowns: true
                                        }

                                        )
                                    });
                                </script>

                                <input type="text" class="timepicker" class="input" name="time" data-validate="required">
                                <script type="text/javascript">
                                    $(document).ready(function() {
                                        $('input.timepicker').timepicker({});
                                    });
                                </script>

                                <label>Event End Time (HH:MM)</label> 
                                <script type="text/javascript">
                                    $(function() {
                                        $('input[name="daterange"]').daterangepicker({
                                            singleDatePicker: true,
                                            showDropdowns: true
                                        }

                                        )
                                    });
                                </script>
                                <input type="text" class="timepicker" class="input" name="endtime" data-validate="required">
                                <script type="text/javascript">
                                    $(document).ready(function() {
                                        $('input.timepicker').timepicker({});
                                    });
                                </script>
                                <p></p>
                                <label>Event Summary</label> 
                                <p></p>
                                <textarea cols="80" placeholder="Event Summary" class="input" rows="5" id="eventSummary" name="eventSummary" data-validate="required" >   
                                </textarea>
                                <p></p>
                                <label>Event Content</label> 
                                <p></p>
                                <textarea cols="80" placeholder="Content" class="input" rows="10" id="eventContent" name="eventContent" data-validate="required" >   
                                </textarea>
                                <script type="text/javascript">
                                    CKEDITOR.replace('eventContent');
                                </script>
                                <p></p>
                                <p>Type of Points:</p>
                                <select name=ptTypes>
                                    <%
                                        for (int j = 0; j < typeIDs.length; j++) {
                                    %>
                                    <option value="<%=typeIDs[j]%>"><%=types.get(typeIDs[j])%></option>
                                    <%
                                        }
                                    %>
                                </select>
                                <p></p>
                                <label class="input">Point Value:</label> <input type="text" name="points" data-validate="required,number">
                                <p></p>                        
                                <p>Category:</p>
                                <select name=ctTypes>
                                    <%
                                        for (int j = 1; j < categoryTypeIDs.length; j++) {
                                    %>
                                    <option value="<%=categoryTypeIDs[j]%>"><%=categoryTypes.get(categoryTypeIDs[j])%></option>
                                    <%
                                        }
                                    %>
                                </select>
                                </form>
                            </ul>
                            <button type="submit" class="btn btn-primary" id="addEvent" >Add Event</button>
                        </div>
                        </div>
                        </div>


                        <script type="text/javascript" charset="utf-8">
                            function init() {

                                scheduler.config.container_autoresize = false;
                                scheduler.xy.bar_height = 50;
                                scheduler.xy.bar_width = 50;
                                //scheduler.config.xml_date = "%Y-%m-%d %H:%i";
                                var now = Date.now;
                                scheduler.init('scheduler_here', new Date(2015, 10, 10), "month");

                                parseTest();

                            }
                            // scheduler.load("connector/Connector.php");
                        </script>
                        <script type="text/javascript" charset="utf-8">
                            function parseTest() {
                            <%
                                int j = 0;
                                DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm");
                                while (events.size() > j) {
                                    EventStore currentEvent = events.get(j);
                                    ContentStore currentContent = currentEvent.getContent();

                                    String contentTitle = currentContent.getContentTitle();
                                    String startTime = dtfOut.print(currentEvent.getEventStartTime());
                                    String endTime = dtfOut.print(currentEvent.getEventEndTime());

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
                        </div>
                </article> 

            </body>
            </html>