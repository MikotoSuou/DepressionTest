package com.mobile.depressiontest.models;

public class Score {

    private int score = 0;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
