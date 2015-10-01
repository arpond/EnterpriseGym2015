<%-- 
    Document   : add news
    Created on : Sep 24, 2015, 2:21:45 PM
    Author     : dragomir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
        <title>Add News</title>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/adminNav.jsp" %>
        <div id="wrapper">
            <div id="page-wrapper">

                <form method="POST"  action="addNews" id="addNews">
                    <div class="left" style="max-width:1000px;">
                        <ul><table>
                                <h2>Add news below</h2> <br>
                                <p><h4>News Title <input type="text" name="newsTitle"> 
                                    News Path</label> /News/<input type="text" name="newsPath"> 
                                    Image link</label> <input type="text" name="newsLink">
                                </h4></p>

                                <textarea cols="60" placeholder="Content" class="input" rows="6" id="newsContent" name="newsContent" >   
                                </textarea>
                                <script type="text/javascript">
                                    CKEDITOR.replace('newsContent');
                                </script>
                                <p><h4>
                                    Select a date <input type="text" name="daterange" class="input" value="01/01/2015" />

                                    <script type="text/javascript">
                                        $(function () {
                                            $('input[name="daterange"]').daterangepicker({
                                                singleDatePicker: true,
                                                showDropdowns: true
                                            }

                                            )
                                        });
                                    </script>
                                    &nbsp; &nbsp; &nbsp; Select a time <input type="text" class="timepicker" class="input" name="timepicker">
                                    <script type="text/javascript">
                                        $(document).ready(function () {
                                            $('input.timepicker').timepicker({});
                                        });
                                    </script>

                                </h4></p>
                                <br>
                                <h4>News Summary</h4> 
                                <textarea cols="80" placeholder="Content Summary" class="input" rows="5" id="newsSummary" name="newsSummary"style="min-width:960px;" >   
                                </textarea>

                            </table>
                        </ul>
                        <button type="submit" class="btn btn-default" style="display:block;margin: 0 auto;" id="addNews" >Add News</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
