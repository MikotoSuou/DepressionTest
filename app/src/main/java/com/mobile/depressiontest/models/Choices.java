package com.mobile.depressiontest.models;

import com.mobile.depressiontest.global.Constants;

public class Choices {

    private String questionList[][] = Constants.QUESTIONS_LIST;

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
