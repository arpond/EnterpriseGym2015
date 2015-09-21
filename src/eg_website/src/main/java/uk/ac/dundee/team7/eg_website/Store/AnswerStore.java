package uk.ac.dundee.team7.eg_website.Store;

public class AnswerStore {

	private int answerId;
	private String answerText;
	private Boolean correct;

    public AnswerStore(int answerId, String answerText, Boolean correct) {
        this.answerId = answerId;
        this.answerText = answerText;
        this.correct = correct;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    
}