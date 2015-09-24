<%-- 
    Document   : displayAllQuizzes
    Created on : 23-Sep-2015, 13:28:39
    Author     : Andrew
--%>
<%@page import="org.joda.time.DateTime"%>
<%@page import="java.util.ArrayList" %>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
          ArrayList<QuizStore> quizes = (ArrayList<QuizStore>) request.getAttribute("quizes");
          //ArrayList<QuizStore> taken = (ArrayList<QuizStore>) request.getAttribute("quizes");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Page</title>
    </head>
    <body>
        <h1>Quiz Page</h1>
        <% for(int i=0; i<quizes.size(); i++)
           {
               QuizStore current = quizes.get(i);
        %>       
        <div class="quizItem">
            <h3><%=current.getQuizName()%></h3>
        </div>
        <%   
           }
        %>
    </body>
</html>
