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
        QuizStore qs = new QuizStore(rs.getInt("quizID"),rs.getString("quizName"), rs.getInt("quizOrder"),rs.getInt("attemptID "),rs.getInt("quizPassRate"), rs.getInt("quizPointsValue"),rs.getInt("typeID"),questionsArray,rs.getInt("status"),rs.getInt("attemptID"));
        conn.close();
        return qs;
	}

        
        public ArrayList<QuizStore> fetchQuizzesForGroup(int userID, int groupID) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DatabaseConnection dbc = new DatabaseConnection();
            java.sql.Connection conn = dbc.connectToDB();
            CallableStatement cs = conn.prepareCall("{call getQuizesForUser(?)}");
            cs.setInt(1,groupID);
            cs.execute();
            ResultSet rs = cs.getResultSet();
            ArrayList <QuizStore> quizzes = new ArrayList<QuizStore>();

            while(rs.next())
            {
               ArrayList<QuestionStore> blankQS = new ArrayList<QuestionStore>(); 
               QuizStore tempQuiz = new QuizStore(rs.getInt("quizID"),rs.getString("quizName"),rs.getInt("quizOrder"),rs.getInt("quizAttemptsAllowed"),rs.getInt("quizPassRate"),rs.getInt("quizPointsValue"),1,blankQS); 
               quizzes.add(tempQuiz);
            }
            
            cs = conn.prepareCall("{call getQuizzes(?,?)}");
            cs.setInt(1, userID);
            cs.setInt(2,groupID);
            cs.execute();
            rs = cs.getResultSet();

            while (rs.next())
            {
                int id = rs.getInt("quizID");
                for (int i = 0; i < quizzes.size(); i++)
                {
                    if (id == quizzes.get(i).getQuizId())
                    {
                        quizzes.get(i).setStatus(rs.getInt("status"));
                        break;
                    }
                }
            }
            conn.close();
            return quizzes;
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

        while(rs.next())
        {
           ArrayList<QuestionStore> blankQS = new ArrayList<QuestionStore>(); 
           QuizStore tempQuiz = new QuizStore(rs.getInt("quizID"),rs.getString("quizName"),rs.getInt("quizOrder"),rs.getInt("quizAttemptsAllowed"),rs.getInt("quizPassRate"),rs.getInt("quizPointsValue"),1,blankQS,rs.getInt("status"),rs.getInt("attemptID")); 
           quizzes.add(tempQuiz);
        }
        
        
        return quizzes;
	}

//	/**
//	 * 
//	 * @param quiz
//	 * @param attempt
//     * @param userID
//	 */
//	public Boolean addQuizAttempt(QuizStore attempt, int userID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//	//TODO unsure if answers should be stored?
//        Class.forName("com.mysql.jdbc.Driver").newInstance();
//        DatabaseConnection dbc = new DatabaseConnection();
//        java.sql.Connection conn = dbc.connectToDB();
//        CallableStatement cs = null;
//        cs = conn.prepareCall("{call addQuizAttempt(?,?)}");
//        cs.setInt(1,attempt.getQuizId());
//        cs.setInt(2,userID);
//        cs.execute();
//        ArrayList <QuestionStore> qs = attempt.getQuestionsArray();
//        int j = 0;
//	while (qs.size() > j)
//        {
//          QuestionStore tempQS = qs.get(j);
//          ArrayList <AnswerStore> tempAS = tempQS.getAnswerArray();
//          int p = 0;
//	while (tempAS.size() > p)
//        {
//          AnswerStore as = tempAS.get(p);
//          
//        }
//          
//         j++;
//        }
//        return true;
//	}

	/**
	 * 
	 * 
         * @param userID
	 * @param attempt
	 */
	public Boolean updateQuizAttempt(QuizStore attempt, int userID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //TODO unsure if answers are to be updated?
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        cs = conn.prepareCall("{call updateQuizAttempt(?,?,?)}");
        cs.setInt(1,attempt.getQuizId());
        cs.setInt(2,userID);
        cs.setInt(3,attempt.getAttemptID());
        cs.execute();
        return true;
	}

        /**
         * Function which fetches a question from the database
         * @param questionID
         * @return 
         */
    public QuestionStore FetchQuestion(int questionID) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        ArrayList<AnswerStore> emptyAS = new ArrayList<AnswerStore>();
        cs= conn.prepareCall("select * eg_question where questionID=?");
        cs.setInt(1, questionID);
        cs.execute();
        ResultSet rs = cs.getResultSet();
        QuestionStore fetchedQuestion = new QuestionStore(rs.getInt("questionID"),rs.getInt("questionNumber"),rs.getString("questionText"),rs.getInt("questionType"),rs.getInt("questionValue"),emptyAS);
        conn.close();
        return fetchedQuestion;
    }

    /**
     * Function which fetches an answer store for a specifc user, question, quiz and attempt.
     * @param quizID
     * @param userID
     * @param questionID
     * @param attemptID
     * @return 
     */
    public AnswerStore FetchAnswer(int quizID, int userID, int questionID, int attemptID) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        cs= conn.prepareCall("select * eg_users_has_eg_quiz_has_eg_question,eg_users_has_eg_quiz,eg_quiz,eg_question,eg_answers"
                + " where eg_quiz.quizID = ? and"
                + " eg_quiz.quizID = eg_users_has_eg_quiz.eg_quiz_quizID and"
                + " eg_users_has_eg_quiz.eg_users_userID = ? and"
                + " eg_users_has_eg_quiz_has_eg_question.eg_users_has_eg_quiz_eg_users_userID = eg_users_has_eg_quiz.eg_users_userID and"
                + " eg_users_has_eg_quiz_has_eg_question.eg_users_has_eg_quiz_eg_quiz_quizID = eg_quiz.quizID and"
                + " eg_question.questionID=? and"
                + " eg_users_has_eg_quiz.attemptID ? and"
                + " eg_users_has_eg_quiz_has_eg_question.eg_users_has_eg_quiz_attemptID  = eg_users_has_eg_quiz.attemptID  and"
                + " eg_users_has_eg_quiz_has_eg_question.eg_question_questionID =  eg_question.questionID and"
                + " eg_question.eg_quiz_quizID = eg_quiz.quizID and"
                + " eg_answers.eg_question_questionID = eg_question.questionID and"
                + " eg_answers.eg_question_eg_quiz_quizID = eg_quiz.quizID");
        cs.setInt(1, quizID);
        cs.setInt(2, userID);
        cs.setInt(3, questionID);
        cs.setInt(4, attemptID);
        cs.execute();
        ResultSet rs = cs.getResultSet();
        AnswerStore fetchedAnswer = new AnswerStore(rs.getInt("answerID"),rs.getString("answerText"),false);
        conn.close();
        return fetchedAnswer;
    }
    
    /**
     * Inserts the attempt into the database
     * @param quizID
     * @param userID
     * @param attemptID 
     */
    public void startQuiz(int quizID, int userID, int attemptID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        ArrayList<AnswerStore> emptyAS = new ArrayList<AnswerStore>();
        cs= conn.prepareCall("insert into eg_users_has_quiz (eg_quiz_quizID,eg_users_userID,attemptID) Values(?,?,?)");
        cs.setInt(1,quizID);
        cs.setInt(2,userID);
        cs.setInt(3,attemptID);
        cs.execute();
        conn.close();
    }

    /**
     * Fetches a question based on the quiz id and the question number
     * @param quizID
     * @param i 
     */
    public QuestionStore FetchQuestion(int quizID, int questionNumber) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        ArrayList<AnswerStore> emptyAS = new ArrayList<AnswerStore>();
        cs= conn.prepareCall("select * eg_question,eg_quiz where eg_quiz.quizID=? and eg_quiz.quizID=eg_question.quizID and eg_question.questionNumber=?");
        cs.setInt(1, quizID);
        cs.setInt(2,questionNumber);
        cs.execute();
        ResultSet rs = cs.getResultSet();
        QuestionStore fetchedQuestion = new QuestionStore(rs.getInt("questionID"),rs.getInt("questionNumber"),rs.getString("questionText"),rs.getInt("questionType"),rs.getInt("questionValue"),emptyAS);
        conn.close();
        return fetchedQuestion;
        
    }

    /**
     * Function to answer a question and insert the details into the database
     * @param quizID
     * @param userID
     * @param questionID
     * @param attemptID
     * @param answerText 
     */
    public void answerQuestion(int quizID, int userID, int questionID, int attemptID, String answerText) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        ArrayList<AnswerStore> emptyAS = new ArrayList<AnswerStore>();
        cs= conn.prepareCall("insert into eg_users_has_eg_quiz_has_eg_question (eg_users_has_eg_quiz_eg_users_userID,eg_users_has_eg_quiz_eg_quiz_quizID, eg_users_has_eg_quiz_attemptID ,eg_question_questionID,answerText) values(?,?,?,?,?)");
        cs.setString(1,answerText);
        cs.setInt(2,attemptID);
        cs.setInt(3,quizID);
        cs.setInt(4,userID);
        cs.setInt(5,questionID);
                
        cs.execute();
        conn.close();
    }

}