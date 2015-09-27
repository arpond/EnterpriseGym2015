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
        <form method="POST"  action="changeContent" id="changeContent">
                <div class="left">
                    <ul>
                        
                        
                        <%
                            request.getAttribute("editContentTitle");
                             request.getAttribute("editContentPath");
                              request.getAttribute("editContentSummary");
                               request.getAttribute("editContent");
                               request.getAttribute("contentID");
                            
                           %>
                           
                           <label class="input"></label> <input type="text" hidden="true" value="${contentID}" name="contentID">
                        <label class="input">Content Title</label> <input type="text" name="editContentTitle" value="${editContentTitle}">
                        <p></p>
                        <label class="input">Content Path</label> <input type="text" name="editContentPath" value="${editContentPath}" >
                        <p></p>
                        <label>Content Summary</label> 
                        <textarea cols="80" placeholder="Content Summary" class="input" rows="5" id="editContentSummary" name="editContentSummary" >   
${editContentSummary}
                        </textarea>
                       
                        <label>Content</label> 
                        <textarea cols="80" placeholder="Content" class="input" rows="10" id="editContent" name="editContent" >   
                        ${editContent}
                        </textarea>
                        <script type="text/javascript">
                        CKEDITOR.replace( 'editContent' );
                        </script>
                        
                            
                    </ul>
                </div>
                <div class="right"><input type="submit" value="Edit Content" class="button" id="changeContent"></div>
            </form>
        </div>
        </div>
    </body>
</html>
