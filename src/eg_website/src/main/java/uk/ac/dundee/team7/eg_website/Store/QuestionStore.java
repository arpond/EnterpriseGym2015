package uk.ac.dundee.team7.eg_website.Store;

import java.util.ArrayList;

public class QuestionStore {

	private int questionID;
	private int questionNumber;
	private String questionText;
	private int questionType;
	private int questionValue;
	private ArrayList<AnswerStore> answerArray;

    public QuestionStore(int questionID, int questionNumber, String questionText, int questionType, int questionValue, ArrayList<AnswerStore> answerArray) {
        this.questionID = questionID;
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.questionType = questionType;
        this.questionValue = questionValue;
        this.answerArray = answerArray;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public int getQuestionValue() {
        return questionValue;
    }

    public void setQuestionValue(int questionValue) {
        this.questionValue = questionValue;
    }

    public ArrayList<AnswerStore> getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(ArrayList<AnswerStore> answerArray) {
        this.answerArray = answerArray;
    }

    
}