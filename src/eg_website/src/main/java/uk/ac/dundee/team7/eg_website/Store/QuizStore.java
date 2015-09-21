package uk.ac.dundee.team7.eg_website.Store;

import java.util.ArrayList;

public class QuizStore {

	private int quizId;
	private String quizName;
	private int quizOrder;
	private int quizAttemptsAllowed;
	private int quizPassRate;
	private int quizPointValue;
	private int pointType;
	private ArrayList<QuestionStore> questionsArray;
	private int status;
	private int attemptNumber;

    public QuizStore(int quizId, String quizName, int quizOrder, int quizAttemptsAllowed, int quizPassRate, int quizPointValue, int pointType, ArrayList<QuestionStore> questionsArray, int status, int attemptNumber) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.quizOrder = quizOrder;
        this.quizAttemptsAllowed = quizAttemptsAllowed;
        this.quizPassRate = quizPassRate;
        this.quizPointValue = quizPointValue;
        this.pointType = pointType;
        this.questionsArray = questionsArray;
        this.status = status;
        this.attemptNumber = attemptNumber;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getQuizOrder() {
        return quizOrder;
    }

    public void setQuizOrder(int quizOrder) {
        this.quizOrder = quizOrder;
    }

    public int getQuizAttemptsAllowed() {
        return quizAttemptsAllowed;
    }

    public void setQuizAttemptsAllowed(int quizAttemptsAllowed) {
        this.quizAttemptsAllowed = quizAttemptsAllowed;
    }

    public int getQuizPassRate() {
        return quizPassRate;
    }

    public void setQuizPassRate(int quizPassRate) {
        this.quizPassRate = quizPassRate;
    }

    public int getQuizPointValue() {
        return quizPointValue;
    }

    public void setQuizPointValue(int quizPointValue) {
        this.quizPointValue = quizPointValue;
    }

    public int getPointType() {
        return pointType;
    }

    public void setPointType(int pointType) {
        this.pointType = pointType;
    }

    public ArrayList<QuestionStore> getQuestionsArray() {
        return questionsArray;
    }

    public void setQuestionsArray(ArrayList<QuestionStore> questionsArray) {
        this.questionsArray = questionsArray;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    
}