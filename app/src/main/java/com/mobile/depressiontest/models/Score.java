package com.mobile.depressiontest.models;

public class Score {
    private static int score = 0;


    public void addZero(){
        score += 0;
    }
    public void addOne(){
        score += 1;
    }
    public void addTwo(){
        score += 2;
    }
    public void addThree(){
        score += 3;
    }

    public static void setScore(int score) {
        Score.score = score;
    }

    public static int getScore() {
        return score;
    }
}
