<%-- 
    Document   : allEditableContent
    Created on : Sep 27, 2015, 10:23:22 AM
    Author     : dragomir
--%>

<%@page import="uk.ac.dundee.team7.eg_website.Store.ContentStore"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.EventStore"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>All Content Edit</title>

        <%@include file="/WEB-INF/includes/adminScripts.jsp" %>
        <script src="/2015-indteam7/js/tables.js"></script>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/adminNav.jsp" %>
        <div id="wrapper">
            <div id="page-wrapper">
                <div id="filterArea">
                    <label for="filter">Filter</label>
                    <input type="text" name="filter" value="" id="filter" />
                </div>
                <table cellpadding="1" cellspacing="1" id="resultTable" class="table table-bordered table-hover table-striped">
                    <thead>
                        <tr>
                            <th class="grp">Content Title</th>
                            <th class="un">Content Path</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
        <%
            ArrayList<ContentStore> csL = new ArrayList();
            csL = (ArrayList<ContentStore>) request.getAttribute("allContentForEdit");
            Iterator i1 = csL.iterator();

            while (i1.hasNext()) {

                ContentStore es = (ContentStore) i1.next();

        %>
     
  
                    <td><%=es.getContentTitle()%></td>
                     <td>/eg_website<%=es.getContentPath()%>"</td>
                     <td>
                     <form method="GET"  action="editContent" id="editContent">
                    <input hidden name="path" value="<%=es.getContentPath()%>">
                    <input type="submit" value="Edit Content" class="button" id="editContent">
                    </form>
                        </td>
                        </tr>
            <%
                }
            %>

          
               </tbody>
                </table>
            </div>
        </div>
    </body>

</html>