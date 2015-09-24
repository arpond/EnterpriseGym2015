package uk.ac.dundee.team7.eg_website.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import uk.ac.dundee.team7.eg_website.Store.*;

public class QuizModel {

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

        /**
         * Function which fetches a question from the database
         * @param questionID
         * @return 
         */
    public QuestionStore FetchQuestion(int questionID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Function which fetches an answer store for a specifc user, question, quiz and attempt.
     * @param quizID
     * @param userID
     * @param questionID
     * @param attemptNumber
     * @return 
     */
    public AnswerStore FetchAnswer(int quizID, int userID, int questionID, int attemptNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Inserts the attempt into the database
     * @param quizID
     * @param userID
     * @param attemptNumber 
     */
    public void startQuiz(int quizID, int userID, int attemptNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Fetches a question based on the quiz id and the question number
     * @param quizID
     * @param i 
     */
    public QuestionStore FetchQuestion(int quizID, int questionNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Function to answer a question and insert the details into the database
     * @param quizID
     * @param userID
     * @param questionID
     * @param attemptNumber
     * @param answerText 
     */
    public void answerQuestion(int quizID, int userID, int questionID, int attemptNumber, String answerText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}