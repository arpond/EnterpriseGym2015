package uk.ac.dundee.team7.eg_website.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.dundee.team7.eg_website.Store.QuizStore;
import uk.ac.dundee.team7.eg_website.Store.UserDetails;
import uk.ac.dundee.team7.eg_website.lib.Utils;
import uk.ac.dundee.team7.eg_website.model.Quiz;

@WebServlet(urlPatterns = {
    "/Quiz",
    "/Quiz/*",
})
public class ViewQuiz {

    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String[] args = Utils.SplitRequestPath(request);
        // Args less than 2 means display all news
        if (args.length <= 2)
        {
            DisplayAllQuizes(request, response);
        }
        else
        {
            DisplayQuiz(args, request, response);
        }
    }
    
    public void doPost() {
            // TODO - implement ViewQuiz.doPost
            throw new UnsupportedOperationException();
    }

    private void DisplayAllQuizes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDetails ud = (UserDetails) session.getAttribute("UserDetails");
        
        Quiz qm = new Quiz();
        
        ArrayList<QuizStore> quizes = new ArrayList<QuizStore>();
        try
        {
            quizes = qm.fetchQuizes(ud.getUserID(), ud.getGroupID());
        }
        catch (Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        request.setAttribute("quizes", quizes);
        RequestDispatcher view = request.getRequestDispatcher("/displayAllQuizes.jsp");
        view.include(request, response);
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
        
        Quiz qm = new Quiz();
        QuizStore quiz;
        try
        {
             quiz = qm.fetchQuiz(quizID);
        }
        catch (Exception e)
        {
            Message.message("Database error. " + e.toString(), request, response);
            return;
        }
        request.setAttribute("quiz", quiz);
        RequestDispatcher view = request.getRequestDispatcher("/displayQuiz.jsp");
        view.include(request, response);
    }

}