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
          QuizStore quiz = (QuizStore) request.getAttribute("quiz");
          int attemptID = (int) request.getAttribute("attemptID");
          int questionNumber = (int) request.getAttribute("questionNumber");
          QuestionStore question = (QuestionStore) request.getAttribute("question");
          AnswerStore userAnswer = (AnswerStore) request.getAttribute("answer");
    %>
    <head>
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question</title>
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
                        <li class="active"><%=question.getQuestionNumber()%></li>
                    </ol>
                </div>
            </div>
        </div>
        <div class="container" style="max-width:600px"> 
           <div class="panel panel-info">
                    <div class="panel-heading">
                        <center><h3 class="panel-title"><p><%=question.getQuestionText()%></p></h3></center>
                    </div>
                    <div class="panel-body">
        <table class=" table table-user-information">
            <%
                if (question.getQuestionType() == 0)
                {
            %>
            <p>Choose one:</p>
            <form method="POST" action="/2015-indteam7/Quiz/<%=question.getQuestionNumber()+1%>" id="question">
                <ul>
            <%
                    ArrayList<AnswerStore> ans = question.getAnswerArray();
                    for (int i=0; i<ans.size();i++)
                    {
                        if (userAnswer != null && userAnswer.getAnswerText().equals(ans.get(i).getAnswerText()))
                        {
                            %>
                            <p style="text-align:center"> <input type="radio" name="answer" value="<%=ans.get(i).getAnswerText()%>" checked><%=ans.get(i).getAnswerText()%></p>    
                                
                            <%
                        }
                        else
                        {
                            %>
                            <p><input type="radio" name="answer" value="<%=ans.get(i).getAnswerText()%>"><%=ans.get(i).getAnswerText()%></p>
                            <%
                        }
                    }
                   
            %>  
                </ul>
                <input type="hidden" name="mode" value="1">
                <input type="hidden" name="quizID" value="<%=quiz.getQuizId()%>">
                <input type="hidden" name="attemptID" value="<%=attemptID%>">
                <input type="hidden" name="questionID" value="<%=question.getQuestionID()%>">
                <input type="hidden" name="questionNumber" value="<%=question.getQuestionNumber()%>">
                <%
                    if (question.getQuestionNumber() == quiz.getQuestionsArray().size())
                    {
                    %>
                    <input type="hidden" name="last" value="1">
                    <%
                    }
                    else
                    {
                    %>
                    <input type="hidden" name="last" value="0">
                    <%
                    }
                %>
                <input type="submit" class="btn btn-default" style="display:block;margin: 0 auto;"  value="Submit" id="questionButton">
            </form>
            <%
                }    
                else 
                {
            %>
            <form method="POST" action="Quiz" id="question">
                <label class="input">Answer</label> <input type="text" name="answer">
                <input type="hidden" name="mode" value="1">
                <%
                    if (question.getQuestionNumber() == quiz.getQuestionsArray().size())
                    {
                    %>
                    <input type="hidden" name="last" value="1">
                    <%
                    }
                    else
                    {
                    %>
                    <input type="hidden" name="last" value="0">
                    <%
                    }
                %>
                <input type="submit" value="Submit" class="btn btn-default" style="display:block;margin: 0 auto;" id="questionButton">
            </form> 
            <%
                }
                /* TODO
                    skip question
                    previous question if exists
                    next question if exists
                */
            %>
            
             </table>
        </div>
    </div>
        </div>
        <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
    </body>
</html>
