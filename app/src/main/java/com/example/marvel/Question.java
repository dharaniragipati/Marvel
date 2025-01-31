package com.example.marvel;

public class Question {
    private final String text;
    private final String option1;
    private final String option2;
    private final String option3;
    private final String option4;
    private final int correctOption;

    public Question(String text, String option1, String option2, String option3, String option4, int correctOption) {
        this.text = text;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctOption = correctOption;
    }

    public String getText() { return text; }
    public String getOption1() { return option1; }
    public String getOption2() { return option2; }
    public String getOption3() { return option3; }
    public String getOption4() { return option4; }
    public int getCorrectOption() { return correctOption; }
}