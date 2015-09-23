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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quizzes</title>
    </head>
    <body>
        <h3><%=quiz.getQuizName()%></h3>
        <p>Points: <%=quiz.getQuizPointValue()%></p>
        <p>Question: <%=quiz.getQuestionsArray().size()%></p>
        <p>Attempts allowed: <%=quiz.getQuizAttemptsAllowed()%> </p>
        <p>Pass Rate: <%=quiz.getQuizPassRate()%>%</p>
        <form method="POST"  action="Quiz" id="quiz">
            <input type="hidden" name="mode" value="0">
            <div class="right"><input type="submit" value="Start Quiz" class="button" id="quizButton"></div>
        </form>
    </body>
</html>
