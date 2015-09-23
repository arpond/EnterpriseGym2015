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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quizzes</title>
    </head>
    <body>
        <h1>Quiz Page</h1>
        <%
          QuizStore qs = (QuizStore) request.getAttribute("quiz");
           int quizID = qs.getQuizId();
           String quizName = qs.getQuizName();
           int quizOrder = qs.getQuizOrder();
           int quizAttemptsAllowed = qs.getQuizAttemptsAllowed();
           int quizPassRate = qs.getQuizPassRate();
           int quizPointValue = qs.getQuizPointValue();
           int pointType = qs.getPointType();
           
           ArrayList<QuestionStore> questions = qs.getQuestionsArray();
           
           int status = qs.getStatus();
           int attemptNumber = qs.getAttemptNumber();
        %>
        
        <!-- DISPLAY NEWS ID, ETC HERE -->
    </body>
</html>
