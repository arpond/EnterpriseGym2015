<%-- 
    Document   : EditContent
    Created on : Sep 24, 2015, 11:03:29 PM
    Author     : dragomir
--%>
<%@page import="uk.ac.dundee.team7.eg_website.lib.Utils"%>
<%@page import="org.joda.time.format.DateTimeFormatter"%>
<%@page import="org.joda.time.format.DateTimeFormat"%>
<%@page import="org.joda.time.format.DateTimeFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.joda.time.DateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/adminNav.jsp" %>
        <div id="wrapper">
            <div id="page-wrapper">
                <form method="POST"  action="changeNews" id="changeNews">
                    <div class="left">
                        <ul>


                            <%
                                
                                DateTime newDT =  (DateTime) request.getAttribute("editStartTime");
                                java.util.Date newDTone = newDT.toDate();
                                DateFormat df = new SimpleDateFormat("MM/dd/YYYY");
                                String sdt = df.format(newDTone.getTime());
                                
                                DateTimeFormatter tf = DateTimeFormat.forPattern("HH:mm");
                                String startTime = tf.print(newDT);
                               
                                System.out.println(sdt);
                                
                                String path = (String) request.getAttribute("editContentPath");
                                
                                String[] split = Utils.SplitPath(path);
                                
                                StringBuilder sb = new StringBuilder();    
                                for (int i = 1; i < split.length; i++)
                                {
                                    if (i == split.length-1)
                                    {
                                        sb.append(split[i]);
                                    }
                                    else
                                    {
                                        sb.append(split[i] + "/");
                                    }
                                }

                                String truncPath = sb.toString();
                            %>

                            <label class="input"></label> <input type="text" hidden="true" value="${contentID}" name="contentID">
                            <label class="input">News Title</label> <input type="text" name="editContentTitle" value="${editContentTitle}">
                            <p></p>
                            <label class="input">News Content Path</label> /News/<input type="text" name="editContentPath" value="<%=truncPath%>" >
                            <p></p>
                            <p></p>
                            <label class="input">News Image Path</label> <input type="text" name="editNewsImage" value="${editNewsImage}" >
                            <p></p>
                            <label>Content Summary</label> 
                            <p></p>
                            <textarea cols="80" placeholder="Content Summary" class="input" rows="5" id="editContentSummary" name="editContentSummary" >   
                                ${editContentSummary}
                            </textarea>
                            <p></p>
                            <label>News Content</label> 
                            <textarea cols="80" placeholder="Content" class="input" rows="10" id="editContent" name="editContent" >   
                                ${editContent}
                            </textarea>
                            <script type="text/javascript">
                                CKEDITOR.replace('editContent');
                            </script>
                            
                             <input type="text" name="daterange" class="input" value="<%=sdt%>" />

                    <script type="text/javascript">
                        $(function () {
                            $('input[name="daterange"]').daterangepicker({
                                singleDatePicker: true,
                                showDropdowns: true
                            }

                            )
                        });
                    </script>
                    <input type="text" class="timepicker" name="timepicker" value="<%=startTime%>">
                    <script type="text/javascript">
                        $(document).ready(function() {
                            $('input.timepicker').timepicker({});
                        });
                    </script>

                        </ul>
                    </div>
                    <div class="right"><input type="submit" value="Edit News Content" class="button" id="changeNews"></div>
                </form>
            </div>
        </div>
    </body>
</html>
