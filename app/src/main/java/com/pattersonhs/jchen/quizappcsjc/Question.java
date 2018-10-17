package com.pattersonhs.jchen.quizappcsjc;

public class Question {
    String question;
    boolean correctAnswer;

    public Question(String newQuestion, boolean newCorrectAnswer){
        question = newQuestion;
        correctAnswer = newCorrectAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
