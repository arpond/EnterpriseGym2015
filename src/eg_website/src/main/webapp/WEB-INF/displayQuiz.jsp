<%-- 
    Document   : news
    Created on : 21-Sep-2015, 13:56:22
    Author     : williamneal
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="java.util.ArrayList" %>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*" %>

<!DOCTYPE html>
<html>
    <%
          QuizStore quiz = (QuizStore) request.getAttribute("quiz");
     %>
    <head>
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quizzes</title>
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
                    <h2 class="page-header">Quiz </h2>
                    <ol class="breadcrumb">
                        <li><a href="/eg_website">Home</a>
                        <li><a href="/2015-indteam7/Quiz">Quiz</a>
                        </li>
                        <li class="active"><%=quiz.getQuizName()%></li>
                    </ol>
                </div>
            </div>
        </div>
      <div class="container" style="max-width:600px"> 
            <div class="panel panel-info">
                    <div class="panel-heading">
                        <center><h3 class="panel-title"><%=quiz.getQuizName()%></h3></center>
                    </div>
                    <div class="panel-body">
        <table class=" table table-user-information">
                            <tr>
                                <td>Points:</td>
                                <td><%=quiz.getQuizPointValue()%></td>
                            </tr>
                            <tr>
                                <td>Questions:</td>
                                <td><%=quiz.getQuestionsArray().size()%></td>
                            </tr>
                            <tr>
                                <td>Attempts allowed:</td>
                                <td><%=quiz.getQuizAttemptsAllowed()%></td>
                            </tr>
                            <tr>
                                <td>Pass rate:</td>
                                <td><%=quiz.getQuizPassRate()%></td>
                            </tr>
                        </table>
        </div>
    </div>
        <form method="POST"  action="" id="quiz">
            <input type="hidden" name="mode" value="0">
            <input type="hidden" name="quizID" value="<%=quiz.getQuizId()%>">
            <input type="submit" class="btn btn-default" style="display:block;margin: 0 auto;" value="Start Quiz" id="quizButton">
        </form>
    </div>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>
</html>
