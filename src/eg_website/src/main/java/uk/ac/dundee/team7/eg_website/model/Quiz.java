package uk.ac.dundee.team7.eg_website.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import uk.ac.dundee.team7.eg_website.Store.*;

public class Quiz {

	/**
	 * 
	 * @param quizID
	 */
	public QuizStore fetchQuiz(int quizID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        cs = conn.prepareCall("{call getQuiz(?)}");
        cs.setInt(1, quizID);
        cs.execute();
        ResultSet rs = cs.getResultSet();
        ArrayList<QuestionStore> questionsArray = new ArrayList<QuestionStore>();
        rs.first();
        while(rs.next())
        {            
            ArrayList<AnswerStore> answersArray = new ArrayList<AnswerStore>();
            CallableStatement answers = conn.prepareCall("select * from eg_question,eg_answers where eg_question.questionID=eg_answers.eg_question_questionID eg_question.questionID = ?");
            answers.setInt(1, rs.getInt("questionID"));
            answers.execute();
            ResultSet rs1 = answers.getResultSet();
            while(rs1.next())
            {
                Boolean correct = rs1.getBoolean("correct");
                AnswerStore answerToAdd = new AnswerStore(rs1.getInt("answerID"),rs1.getString("answerText"),correct);
                answersArray.add(answerToAdd);
            }
            QuestionStore questionToAdd = new QuestionStore(rs.getInt("questionID"),rs.getInt("questionNumber"),rs.getString("questionText"),rs.getInt("questionType"),rs.getInt("questionValue"),answersArray);
            questionsArray.add(questionToAdd);
        }
        QuizStore qs = new QuizStore(rs.getInt("quizID"),rs.getString("quizName"), rs.getInt("quizOrder"),rs.getInt("attemptNumber"),rs.getInt("quizPassRate"), rs.getInt("quizPointsValue"),rs.getInt("typeID"),questionsArray,rs.getInt("status"),rs.getInt("attemptNumber"));
        conn.close();
        return qs;
	}

	/**
	 * 
	 * @param userID
	 * @param groupID
	 */
	public ArrayList<QuizStore> fetchQuizes(int userID, int groupID) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
		 
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = conn.prepareCall("{call getQuizzes(?,?)}");
        cs.setInt(1, userID);
        cs.setInt(2,groupID);
        cs.execute();
        ResultSet rs = cs.getResultSet();
        ArrayList <QuizStore> quizzes = new ArrayList<QuizStore>();
        rs.first();
        while(rs.next())
        {
           ArrayList<QuestionStore> blankQS = new ArrayList<QuestionStore>(); 
           QuizStore tempQuiz = new QuizStore(rs.getInt("quizID"),rs.getString("quizName"),rs.getInt("quizOrder"),rs.getInt("quizAttemptsAllowed"),rs.getInt("quizPassRate"),rs.getInt("quizPointValue"),1,blankQS,rs.getInt("status"),rs.getInt("attemptNumber")); 
           quizzes.add(tempQuiz);
        }        
        return quizzes;
	}

	/**
	 * 
	 * @param quiz
	 * @param attempt
	 */
	public Boolean addQuizAttempt(QuizStore quiz, QuizStore attempt) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
	
         //TODO need to think about this and implement.
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        cs = conn.prepareCall("");
        return true;
	}

	/**
	 * 
	 * @param quiz
	 * @param attempt
	 */
	public Boolean updateQuizAttempt(QuizStore quiz, QuizStore attempt) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //TODO need to think about this and implement
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        return true;
	}

}