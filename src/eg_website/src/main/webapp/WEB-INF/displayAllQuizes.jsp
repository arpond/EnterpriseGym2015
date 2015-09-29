<%-- 
    Document   : displayAllQuizzes
    Created on : 23-Sep-2015, 13:28:39
    Author     : Andrew
--%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="java.util.ArrayList" %>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*" %>
<%@page import="java.util.HashMap" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        ArrayList<QuizStore> untaken = (ArrayList<QuizStore>) request.getAttribute("untaken");
        ArrayList<QuizStore> taken = (ArrayList<QuizStore>) request.getAttribute("taken");
        HashMap StatusMap = new HashMap();
        StatusMap.put(0, "Start");
        StatusMap.put(1, "In Progress");
        StatusMap.put(2, "Completed");
    %>
    <head>
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Page</title>
    </head>

    <style>
        .table-user-information > tbody > tr {
            border-top: 1px solid rgb(221, 221, 221);
        }

        .table-user-information > tbody > tr:first-child {
            border-top: 0;
        }
        .table-user-information > tbody > tr > td {
            border-top: 0;
        }
    </style>

    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>

        <div class="container">
            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Quizzes

                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="/eg_website">Home</a>
                        </li>
                        <li class="active">Quizzes</li>
                    </ol>
                </div>
            </div>
            <div class="container" style="max-width:600px">

                <%
                    if (taken != null && taken.size() > 0) {
                %>

                <div class="panel panel-info">
                    <div class="panel-heading">
                        <center><h3>Quizzes you have taken</h3></center>
                    </div>

                    <div class="panel-body">



                        <%for (int i = 0; i < taken.size(); i++) {
                QuizStore current = taken.get(i);%>

                        <div class="quizItem">
                            <table class=" table table-user-information"> 
                                <tr>
                                    <td><h4><a href="/eg_website/Quiz/<%=current.getQuizId()%>"><%=current.getQuizName()%></a></h4></td>
                                    <td><h4>Status: <%=StatusMap.get(current.getStatus())%></h4></td> 
                                <tr></table>
                        </div>
                        <%}%>

                        <%}
                            if (untaken.size() > 0) {
                        %>

                    </div>
                </div>

                <div class="panel panel-info">
                    <div class="panel-heading">
                        <center><h3>All Quizzes</h3></center>
                    </div>
                    <div class="panel-body">
                        <%
                            for (int i = 0; i < untaken.size(); i++) {
                                QuizStore current = untaken.get(i);

                        %>       
                        <div class="quizItem">
                            <h4> <a href="/eg_website/Quiz/<%=current.getQuizId()%>"><%=current.getQuizName()%></a><h4>
                                    </div>
                                    <%
                                            }
                                        }
                                    %>

                   </div>
                 </div>                                 
            </div>
         </div>
 </body>

 <footer>
     <%@include file="/WEB-INF/includes/normalFooter.jsp" %> 
 </footer>
</html>
