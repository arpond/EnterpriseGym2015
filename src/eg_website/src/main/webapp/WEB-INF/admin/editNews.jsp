<%-- 
    Document   : EditContent
    Created on : Sep 24, 2015, 11:03:29 PM
    Author     : dragomir
--%>

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
                                request.getAttribute("editContentTitle");
                                request.getAttribute("editContentPath");
                                request.getAttribute("editContentSummary");
                                request.getAttribute("editContent");
                                request.getAttribute("contentID");
                                request.getAttribute("editNewsImage");
                                
                                DateTime newDT =  (DateTime) request.getAttribute("editStartTime");
                                System.out.println(newDT);
                                String tempnewDT = newDT.toString();
                                System.out.println(tempnewDT);
                                String useThisDateTime = tempnewDT.substring(0,tempnewDT.length()-19);
                                System.out.println(useThisDateTime);
                                
                                
                                   String partOne = useThisDateTime.substring(9, 10);
                                   String partTwo = useThisDateTime.substring(6, 7);
                                   String partThree = useThisDateTime.substring(0, 4);
                                   String voltron = partOne + "/" + partTwo + "/" + partThree;
                                    System.out.println(voltron);
                            %>

                            <label class="input"></label> <input type="text" hidden="true" value="${contentID}" name="contentID">
                            <label class="input">News Content Title</label> <input type="text" name="editContentTitle" value="${editContentTitle}">
                            <p></p>
                            <label class="input">News Content Path</label> <input type="text" name="editContentPath" value="${editContentPath}" >
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
                            
                             <input type="text" name="daterange" class="input" value="<%=voltron%>" />

                    <script type="text/javascript">
                        $(function () {
                            $('input[name="daterange"]').daterangepicker({
                                singleDatePicker: true,
                                showDropdowns: true
                            }

                            )
                        });
                    </script>
                    <input type="text" class="timepicker" class="input" name="timepicker">
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
