<%-- 
    Document   : displayQuestion
    Created on : 23-Sep-2015, 14:18:26
    Author     : Andrew
--%>

<%@page import="java.util.ArrayList" %>
<%@page import="uk.ac.dundee.team7.eg_website.Store.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
          QuestionStore question = (QuestionStore) request.getAttribute("question");
          AnswerStore userAnswer = (AnswerStore) request.getAttribute("answer");
    %>
    <head>
        <%@include file="/includes/scripts.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/includes/normalHeader.jsp" %>
        <h1>Quiz Name</h1>
        <div>
            <p>Question <%=question.getQuestionNumber()%>></p>
            <p><%=question.getQuestionText()%></p>
            <%
                if (question.getQuestionType() == 0)
                {
            %>
            <p>Choose one:</p>
            <form method="POST" action="Quiz" id="question">
                <ul>
            <%
                    ArrayList<AnswerStore> ans = question.getAnswerArray();
                    for (int i=0; i<ans.size();i++)
                    {
                        if (userAnswer != null && userAnswer.getAnswerText().equals(ans.get(i).getAnswerText()))
                        {
                            %>
                            <li><input type="radio" name="answer" value="<%=ans.get(i).getAnswerText()%>" checked></li>
                            <%
                        }
                        else
                        {
                            %>
                            <li><input type="radio" name="answer" value="<%=ans.get(i).getAnswerText()%>"></li>
                            <%
                        }
                    }
            %>
                </ul>
                <input type="hidden" name="mode" value="1">
                <input type="submit" value="Login" class="button" id="questionButton">
            </form>
            <%
                }    
                else 
                {
            %>
            <form method="POST" action="Quiz" id="question">
                <label class="input">Answer</label> <input type="text" name="answer">
                <input type="hidden" name="mode" value="1">
                <input type="submit" value="Login" class="button" id="questionButton">
            </form> 
            <%
                }
                /* TODO
                    skip question
                    previous question if exists
                    next question if exists
                */
            %>
        </div>
        <%@include file="/includes/normalFooter.jsp" %>
    </body>
</html>
