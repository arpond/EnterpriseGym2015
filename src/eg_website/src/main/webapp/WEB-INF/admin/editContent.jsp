<%-- 
    Document   : EditContent
    Created on : Sep 24, 2015, 11:03:29 PM
    Author     : dragomir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uk.ac.dundee.team7.eg_website.lib.Utils"%>
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
                            <label class="input">Content Title</label> <input type="text" name="editContentTitle" value="${editContentTitle}">
                            <p></p>
                            <label class="input">Content Path</label> /Content/<input type="text" name="editContentPath" value="<%=truncPath%>" >
                            <p></p>
                            <label>Content Summary</label> 
                            <textarea cols="890" placeholder="Content Summary" class="input" rows="5" id="editContentSummary" name="editContentSummary" >   
                                ${editContentSummary}
                            </textarea>

                            <label>Content</label> 
                            <textarea cols="80" placeholder="Content" class="input" rows="10" id="editContent" name="editContent" >   
                                ${editContent}
                            </textarea>
                            <script type="text/javascript">
                                CKEDITOR.replace('editContent');
                            </script>


                        </ul>
                    </div>
                    <div class="right"><input type="submit" value="Edit Content" class="button" id="changeContent"></div>
                </form>
            </div>
        </div>
    </body>
</html>
