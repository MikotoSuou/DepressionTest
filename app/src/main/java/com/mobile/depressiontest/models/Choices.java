package com.mobile.depressiontest.models;

public class Choices {

    private String questionList[][] = {
            {"I do not feel sad", "I feel sad ", "I am sad all the time and I can't snap out of it", "I am so sad and unhappy that I can't stand it. "},
            {"I am not particularly discouraged about the future. ", "I feel discouraged about the future. ", "I feel discouraged about the future. ", "I feel discouraged about the future. "}
    };

    private int indexCount = 0;

    public void incrementCount() {
        indexCount++;
    }

    public int getIndexCount() {
        return indexCount;
    }

    public String getChoice1() {
        return questionList[indexCount][0];
    }

    public String getChoice2() {
        return questionList[indexCount][1];
    }

    public String getChoice3() {
        return questionList[indexCount][2];
    }

    public String getChoice4() {
        return questionList[indexCount][3];
    }
}
