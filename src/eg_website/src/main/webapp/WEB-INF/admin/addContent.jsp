<%-- 
    Document   : addContent
    Created on : Sep 24, 2015, 12:25:55 PM
    Author     : dragomir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
        <title>Add content</title>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/adminNav.jsp" %>

        <div id="wrapper">  
            <div id="page-wrapper">

                <form method="POST"  action="addContent" id="addContent">
                    <div class="left" style="max-width:1000px">
                        <ul>
                            <table>
                                <h2>Add new content below</h2><br>
                                <p><h4>Content Title <input type="text" name="contentTitle"> &nbsp; &nbsp; &nbsp; &nbsp;
                                    Content Path <input type="text" name="contentPath"></h4></p>
                                <textarea cols="60" placeholder="Content" class="input" rows="6" id="content" name="content" >   
                                </textarea>
                                <script type="text/javascript">
                                    CKEDITOR.replace('content');
                                </script>
                                <br>
                                <p><h4>Content Summary</h4></p>
                                <textarea cols="60" placeholder="Content Summary" class="input" rows="6" id="contentSummary" name="contentSummary" style="min-width:960px;" >   
                                </textarea>
                            </table>
                        </ul>
                        <input type="submit" class="btn btn-default" style="display:block;margin: 0 auto;"  value="Add Content" class="button" id="addContent">
                    </div>

                </form>
            </div>
        </div>
    </body>
</html>
