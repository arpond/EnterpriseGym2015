package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.dundee.team7.eg_website.Store.AnswerStore;
import uk.ac.dundee.team7.eg_website.Store.QuestionStore;
import uk.ac.dundee.team7.eg_website.Store.QuizStore;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.lib.Utils;
import uk.ac.dundee.team7.eg_website.model.QuizModel;

@WebServlet(urlPatterns = {
    "/Quiz",
    "/Quiz/*",
})
public class ViewQuiz extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String[] args = Utils.SplitRequestPath(request);
        // Args less than 2 means display all news
        if (args.length <= 2)
        {
            DisplayAllQuizes(request, response);
        }
        else if (args.length == 3)
        {
            DisplayQuiz(args, request, response);
        }
        else
        {
            DisplayQuestion(args, request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
           //userID, quizID, attemptNumber
        int mode;
        try
        {
            mode = Integer.parseInt(request.getParameter("mode"));
        }
        catch (Exception e)
        {
           Message.message("Mode error.", request, response);
           return;
        }
        
        switch (mode)
        {
            case 0:
                startNewQuiz(request, response);
                break;
            case 1:
                answerQuestion(request, response);
                break;
        }
        
    }

    private void DisplayQuiz(String[] args, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quizID;
        if (args.length > 3 )
        {
            Message.message("Quiz could not be found.", request, response);
            return;
        }
        try
        {
            quizID = Integer.parseInt(args[2]);
        }
        catch (Exception e)
        {
           Message.message("Quiz could not be found.", request, response);
           return; 
        }
        
        QuizModel qm = new QuizModel();
        QuizStore quiz;
        try
        {
             quiz = qm.fetchQuiz(quizID);
             if (quiz.getQuizId() == 0)
             {
                Message.message("Quiz could not be found.", request, response);
                return;
             }
        }
        catch (Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        request.setAttribute("quiz", quiz);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/displayQuiz.jsp");
        view.include(request, response);
    }

    private void DisplayQuestion(String[] args, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quizID, questionID, attemptNumber;
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        if (args.length != 5 )
        {
            Message.message("Question could not be found.", request, response);
            return;
        }
        try
        {
            quizID = Integer.parseInt(args[2]);
            attemptNumber = Integer.parseInt(args[3]);
            questionID = Integer.parseInt(args[4]);
            
        }
        catch (Exception e)
        {
           Message.message("Question could not be found.", request, response);
           return;
        }
        
        QuizModel qm = new QuizModel();
        QuestionStore qs;
        AnswerStore as;
        try
        {
            qs = qm.FetchQuestion(questionID);
            as = qm.FetchAnswer(quizID, ud.getUserID(), questionID, attemptNumber);
            
            if (qs.getQuestionID() == 0)
            {
               Message.message("Question could not be found.", request, response);
               return;
            }
        }
        catch (Exception e)
        {
           Message.message("Question could not be found.", request, response);
           return;
        }
        request.setAttribute("question", qs);
        request.setAttribute("answer", as);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/displayQuestion.jsp");
        view.include(request, response);
    }

    private void startNewQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        int quizID, attemptNumber;
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        
        try
        {
            quizID = Integer.parseInt(request.getParameter("quizID"));
            attemptNumber = Integer.parseInt(request.getParameter("attemptNumber"));            
        }
        catch (Exception e)
        {
           Message.message("Question could not be found.", request, response);
           return;
        }
        
        QuizModel qm = new QuizModel();
        QuestionStore qs;
        try
        {
            qm.startQuiz(quizID, ud.getUserID(), attemptNumber);
            qs = qm.FetchQuestion(quizID, 1);
        }
        catch(Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        
        request.setAttribute("question", qs);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/displayQuestion.jsp");
        view.include(request, response);
    }

    private void DisplayAllQuizes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        
        QuizModel qm = new QuizModel();
        
        ArrayList<QuizStore> quizes = new ArrayList<QuizStore>();
        try
        {
            quizes = qm.fetchQuizzesForGroup(ud.getUserID(), ud.getGroupID());
        }
        catch (Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        
        ArrayList<QuizStore> taken = new ArrayList<QuizStore>();
        ArrayList<QuizStore> untaken = new ArrayList<QuizStore>();
        
        for(int i=0; i < quizes.size(); i++)
        {
            if(quizes.get(i).getStatus() == 0)
            {
                untaken.add(quizes.get(i));
            }
            else
            {
                taken.add(quizes.get(i));
            }
        }
        request.setAttribute("untaken", untaken);
        request.setAttribute("taken", taken);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/displayAllQuizes.jsp");
        view.include(request, response);
    }

    private void answerQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        int questionID, quizID, attemptNumber, questionNumber;
        String answerText;
        
        //UserID, questionID, quizID, attemptNumber, answerText
        
        try
        {
            quizID = Integer.parseInt(request.getParameter("quizID"));
            attemptNumber = Integer.parseInt(request.getParameter("attemptNumber"));
            questionID = Integer.parseInt(request.getParameter("questionID"));
            questionNumber = Integer.parseInt(request.getParameter("questionNumber"));
            answerText = request.getParameter("userAnswer");
        }
        catch (Exception e)
        {
           Message.message("Quuestion could not be found.", request, response);
           return;
        }
        
        QuizModel qm = new QuizModel();
        QuestionStore qs;
        AnswerStore as;
        try
        {
            qm.answerQuestion(quizID, ud.getUserID(), questionID, attemptNumber, answerText);
            qs = qm.FetchQuestion(quizID, questionNumber + 1);
            as = qm.FetchAnswer(quizID, ud.getUserID(), qs.getQuestionID(), attemptNumber);
        }
        catch(Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        
        request.setAttribute("question", qs);
        request.setAttribute("answer", as); //This is the answer provided by the user previously.. if it exists.
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/displayQuestion.jsp");
        view.include(request, response);
    }

}