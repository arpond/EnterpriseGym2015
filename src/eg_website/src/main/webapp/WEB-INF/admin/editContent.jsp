<%-- 
    Document   : EditContent
    Created on : Sep 24, 2015, 11:03:29 PM
    Author     : dragomir
--%>

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
        <form method="GET"  action="getContentToEdit" id="getContentToEdit">
                <div class="left">
                    <ul>
                        <label class="input">Content Title</label> <input type="text" name="editContentTitle">
                        <p></p>
                        <label class="input">Content Path</label> <input type="text" name="editContentPath">
                        <p></p>
                        <label>Content Summary</label> 
                        <textarea cols="80" placeholder="Content Summary" class="input" rows="5" id="editContentSummary" name="contentSummary" >   
                        </textarea>
                       
                        <label>Content</label> 
                        <textarea cols="80" placeholder="Content" class="input" rows="10" id="editContent" name="content" >   
                        </textarea>
                        <script type="text/javascript">
                        CKEDITOR.replace( 'editContent' );
                        </script>
                        
                            
                    </ul>
                </div>
                <div class="right"><input type="submit" value="Add Content" class="button" id="editCont"></div>
            </form>
        </div>
        </div>
    </body>
</html>
