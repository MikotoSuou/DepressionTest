package com.mobile.depressiontest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mobile.depressiontest.R;
import com.mobile.depressiontest.models.ResultInterface;

public class ResultActivity extends AppCompatActivity implements ResultInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

    }

    @Override
    public void displayResult() {
        int score = getIntent().getExtras().getInt("score");
        if (score != 0 && score <= 10)
        {
            System.out.println("\nThese ups and downs are considered normal");
        }
        else if (score >= 11 && score <= 16)
        {
            System.out.println("\nMild mood disturbance");
        }
        else if (score >= 17 && score <= 20)
        {
            System.out.println("\nBorderline clinical depression");
        }
        else if (score >= 21 && score <= 30)
        {
            System.out.println("\nModerate depression");
        }
        else if (score >= 31 && score <= 40)
        {
            System.out.println("\nSevere depression");
        }
        else if (score >= 40)
        {
            System.out.println("\nExtreme depression");
        }
        else {
            System.out.println("\nNot Depressed - .0");
        }

    }
}