package com.hackbulgaria.getfit.test;


public class QuestionLibrary {

    private String mQuestions [] ={
            "How old are you?",
            "What is your physical activity?",
            "What is your average day?",
            "How often do you eat during the day?"
    };

    private String mChoices [][] ={
            {"0 - 18","19 - 35","36 +"},
            {"None","1 -2 times a week","more than that"},
            {"At the office","Have no time to sit and rest","All day at home"},
            {"1 -2 times","3 time and maybe more","I don't have fixed schedule"}

    };

    private String mAnswers [] = {"","","",""};

    public String getQuestion(int a){

        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){

        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a){

        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a){

        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getAnswer(int a){

        String answer = mAnswers[a];
        return answer;
    }
}
