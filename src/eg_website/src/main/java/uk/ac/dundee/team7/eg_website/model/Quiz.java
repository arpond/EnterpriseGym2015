package uk.ac.dundee.team7.eg_website.model;

import java.util.ArrayList;
import uk.ac.dundee.team7.eg_website.Store.*;

public class Quiz {

	/**
	 * 
	 * @param quizID
	 */
	public QuizStore fetchQuiz(int quizID) {
		// TODO - implement Quiz.fetchQuiz
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userID
	 * @param groupID
	 */
	public ArrayList<QuizStore> fetchQuizes(int userID, int groupID) {
		// TODO - implement Quiz.fetchQuizes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param quiz
	 * @param attempt
	 */
	public Boolean addQuizAttempt(QuizStore quiz, QuizStore attempt) {
		// TODO - implement Quiz.addQuizAttempt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param quiz
	 * @param attempt
	 */
	public Boolean updateQuizAttempt(QuizStore quiz, QuizStore attempt) {
		// TODO - implement Quiz.updateQuizAttempt
		throw new UnsupportedOperationException();
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