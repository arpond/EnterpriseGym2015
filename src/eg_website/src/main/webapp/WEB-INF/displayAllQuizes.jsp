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
    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
        <h1>Quiz Page</h1>
        <%
        if (taken.size() > 0)
        {
        %>
        <h2>Quizzes you have taken</h2>
        <%
            for (int i = 0; i<taken.size(); i++)
            {
                QuizStore current = taken.get(i);
                %>
        <div class="quizItem">
            <p><a href="/eg_website/Quiz/<%=current.getQuizId()%>"><%=current.getQuizName()%></a> Status: <%=StatusMap.get(current.getStatus())%></p>            
        </div>
                <%
            }
        %>
        <%
        }
        if (untaken.size() > 0)
        {
        %>
        <h2>All Quizzes</h2>
        <%
            for(int i=0; i<untaken.size(); i++)
           {
               QuizStore current = untaken.get(i);
               
        %>       
        <div class="quizItem">
            <p><a href="/eg_website/Quiz/<%=current.getQuizId()%>"><%=current.getQuizName()%></a></p>
        </div>
        <%   
           }
        }
        %>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>
</html>
