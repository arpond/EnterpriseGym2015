
<%-- 
    Document   : ad


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
            <div class="left">
                <ul>
                    <label class="input">News Title</label> <input type="text" name="newsTitle">
                    <p></p>
                    <label class="input">News Path</label> <input type="text" name="newsPath">
                    <p></p>
                    <label class="input">News Image link</label> <input type="text" name="newsLink">
                    <p></p>
                    <label>News Summary</label> 
                    <p></p>
                    <textarea cols="80" placeholder="Content Summary" class="input" rows="5" id="newsSummary" name="newsSummary" >   
                    </textarea>
                    <p></p>
                    <label>News Content</label> 
                    <textarea cols="80" placeholder="Content" class="input" rows="10" id="newsContent" name="newsContent" >   
                    </textarea>
                    <script type="text/javascript">
                        CKEDITOR.replace('newsContent');
                    </script>
                    <input type="text" name="daterange" class="input" value="01/01/2015" />

                    <script type="text/javascript">
                        $(function () {
                            $('input[name="daterange"]').daterangepicker({
                                singleDatePicker: true,
                                showDropdowns: true
                            }

                            )
                        });
                    </script>
                    <input type="text" class="timepicker" class="input" name="time">
                    <script type="text/javascript">
                        $(document).ready(function () {
                            $('input.timepicker').timepicker({});
                        });
                    </script>
                   
                </ul>
            </div>
            <button type="submit" class="btn btn-primary" id="addNews" >Add News</button>
           
        </form>
        </div>
        </div>
    </body>
</html>
