<%-- 
    Document   : EditContent
    Created on : Sep 24, 2015, 11:03:29 PM
    Author     : dragomir
--%>

<%@page import="org.joda.time.DateTime"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
        <title>Edit Event</title>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/adminNav.jsp" %>
        <div id="wrapper">
            <div id="page-wrapper">
                <form method="POST"  action="changeEvent" id="changeEvent">
                    <div class="left">
                       

                            <%
                                request.getAttribute("editContentTitle");
                                request.getAttribute("editContentPath");
                                request.getAttribute("editContentSummary");
                                request.getAttribute("editContent");
                                request.getAttribute("contentID");
                                request.getAttribute("editEventImage");
                                //request.getAttribute("editPointType");
                                request.getAttribute("editEventID");
                                request.getAttribute("editEventValue");
                               
                                
                                DateTime newDT =  (DateTime) request.getAttribute("editStartTime");
                                System.out.println(newDT);
                                String tempnewDT = newDT.toString();
                                System.out.println(tempnewDT);
                                String useThisDateTime = tempnewDT.substring(0,tempnewDT.length()-19);
                                System.out.println(useThisDateTime);
                                
                                
                                   String partOne = useThisDateTime.substring(8, 10);
                                   String partTwo = useThisDateTime.substring(5, 7);
                                   String partThree = useThisDateTime.substring(0, 4);
                                   String voltron = partOne + "/" + partTwo + "/" + partThree;
                                    System.out.println(voltron);
                           
                                   
                            
                                 ArrayList<String> strArray = new ArrayList();
                                  strArray = (ArrayList<String>) request.getAttribute("editPointType");

                            %>

                            <label class="input"></label> <input type="text" hidden="true" value="${contentID}" name="contentID">
                            <label class="input"></label> <input type="text" hidden="true" value="${editEventID}" name="editEventID">
                            <label class="input">Event Content Title</label> <input type="text" name="editContentTitle" value="${editContentTitle}">
                            <p></p>

                            <select name="editPointType">     
                                    <%
                                    
                                    for(int i=0;i<strArray.size();i++){

                                        %>
                                    <option value=<%=strArray.get(i)%>><%=strArray.get(i)%></option>
                                     <%
                                                 
                                    }
                                    %>
                                
    
                            </select>

                            <p></p>
                            <label class="input">Event Value</label> <input type="text" name="editEventValue" value="${editEventValue}">
                            <p></p>
                            <label class="input">Event Content Path</label> <input type="text" name="editContentPath" value="${editContentPath}" >
                            <p></p>
                            <p></p>
                            <label class="input">Event Image Path</label> <input type="text" name="editEventImage" value="${editEventImage}" >
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
                   
                    </div>
                    <div class="right"><input type="submit" value="Edit Event Content" class="button" id="changeEvent"></div>
                </form>
            </div>
        </div>
    </body>
</html>
