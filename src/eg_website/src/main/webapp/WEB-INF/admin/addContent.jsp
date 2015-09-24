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
   <title>All Events</title>
</head>
<body>
    <%@include file="/WEB-INF/includes/adminNav.jsp" %>
    <div id="wrapper">
        <div id="page-wrapper">
        <form method="POST"  action="addContent" id="addContent">
                  <div class="left">
                      <ul>
                          <label class="input">Content Title</label> <input type="text" name="contentTitle">
                          <p></p>
                          <label class="input">Content Path</label> <input type="text" name="contentPath">
                          <p></p>
                          <label>Content Summary</label> 
                          <textarea cols="80" placeholder="Content Summary" class="input" rows="5" id="contentSummary" name="contentSummary" >   
                          </textarea>
                          <script type="text/javascript">
                          CKEDITOR.replace( 'contentSummary' );
                          </script>
                          <label>Content</label> 
                          <textarea cols="80" placeholder="Content" class="input" rows="10" id="content" name="content" >   
                          </textarea>
                          <script type="text/javascript">
                          CKEDITOR.replace( 'content' );
                          </script>


                      </ul>
                  </div>
                  <div class="right"><input type="submit" value="Add Content" class="button" id="addContent"></div>
              </form>
            </div>
        </div>
    </body>
</html>
