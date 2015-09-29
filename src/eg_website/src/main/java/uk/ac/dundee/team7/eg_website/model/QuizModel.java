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
            while(rs.next())
            {   
                ArrayList<AnswerStore> answersArray = new ArrayList<AnswerStore>();
                QuestionStore questionToAdd = new QuestionStore(rs.getInt("questionID"),rs.getInt("questionNumber")
                        ,rs.getString("questionText"),rs.getInt("questionType"),rs.getInt("questionValue"),answersArray);
                questionsArray.add(questionToAdd);
            }
            rs.first();

            QuizStore qs = new QuizStore(rs.getInt("quizID"),rs.getString("quizName")
                    , rs.getInt("quizOrder"),rs.getInt("quizAttemptsAllowed"),rs.getInt("quizPassRate")
                    , rs.getInt("quizPointsValue"),rs.getInt("eg_pointTypes_typeId"), questionsArray);
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
        
        conn.close();
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
        conn.close();
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
        cs= conn.prepareCall("{call getAnswer(?,?,?,?)}");
        cs.setInt(1, quizID);
        cs.setInt(2, userID);
        cs.setInt(3, questionID);
        cs.setInt(4, attemptID);
        cs.execute();
        ResultSet rs = cs.getResultSet();
        rs.first();
        AnswerStore fetchedAnswer = new AnswerStore();
        fetchedAnswer.setAnswerId(rs.getInt("answerID"));
        fetchedAnswer.setAnswerText(rs.getString("answerText"));
        conn.close();
        return fetchedAnswer;
    }
    
    /**
     * Inserts the attempt into the database
     * @param quizID
     * @param userID
     * @param attemptID 
     */
    public int startQuiz(int quizID, int userID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DatabaseConnection dbc = new DatabaseConnection();
        java.sql.Connection conn = dbc.connectToDB();
        CallableStatement cs = null;
        ArrayList<AnswerStore> emptyAS = new ArrayList<AnswerStore>();
        cs= conn.prepareCall("insert into eg_users_has_eg_quiz (eg_quiz_quizID,eg_users_userID,status) Values(?,?,1)");
        cs.setInt(1,quizID);
        cs.setInt(2,userID);
        cs.execute();
        
        cs = conn.prepareCall("select last_insert_id() as last_id from eg_users_has_eg_quiz");
        ResultSet rs = cs.executeQuery();
        rs.first();
        int lastid = Integer.parseInt(rs.getString("last_id"));
        
        conn.close();
        return lastid;
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
        ArrayList<AnswerStore> answersArray = new ArrayList<AnswerStore>();
        cs=conn.prepareCall("select * from eg_question,eg_quiz,eg_answers " +
                            "where eg_quiz.quizID=? " +
                            "and eg_quiz.quizID=eg_question.eg_quiz_quizID " +
                            "and eg_question.questionNumber=? " +
                            "and eg_answers.eg_question_questionID = eg_question.questionID");
        cs.setInt(1, quizID);
        cs.setInt(2,questionNumber);
        cs.execute();
        ResultSet rs = cs.getResultSet();
        while(rs.next())
        {   
           AnswerStore as = new AnswerStore();
           as.setAnswerId(rs.getInt("answerID"));
           as.setAnswerText(rs.getString("answerText"));
           as.setCorrect(rs.getBoolean("correct"));
           answersArray.add(as);
        }
        rs.first();
        QuestionStore fetchedQuestion =new QuestionStore(rs.getInt("questionID"),rs.getInt("questionNumber")
                        ,rs.getString("questionText"),rs.getInt("questionType"),rs.getInt("questionValue"),answersArray);
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
        cs= conn.prepareCall("insert into eg_users_has_eg_quiz_has_eg_question ("
                + "eg_users_has_eg_quiz_eg_users_userID,eg_users_has_eg_quiz_eg_quiz_quizID, "
                + "eg_users_has_eg_quiz_attemptID ,eg_question_questionID,answer) values(?,?,?,?,?)");
        
        cs.setInt(1,userID);
        cs.setInt(2,quizID);
        cs.setInt(3,attemptID);
        cs.setInt(4,questionID);
        cs.setString(5,answerText);
        
        cs.execute();
        conn.close();
    }

}