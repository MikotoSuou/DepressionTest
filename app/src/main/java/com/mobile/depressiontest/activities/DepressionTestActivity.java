package com.mobile.depressiontest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

import com.mobile.depressiontest.R;
import com.mobile.depressiontest.models.Choices;
import com.mobile.depressiontest.models.Score;
import com.mobile.depressiontest.models.ScoreInterface;

public class DepressionTestActivity extends AppCompatActivity implements ScoreInterface {
    Button buttonChoice1, buttonChoice2, buttonChoice3, buttonChoice4;
    Score score = new Score();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depression_test);

        buttonChoice1 = findViewById(R.id.btnChoice1);
        buttonChoice2 = findViewById(R.id.btnChoice2);
        buttonChoice3 = findViewById(R.id.btnChoice3);
        buttonChoice4 = findViewById(R.id.btnChoice4);

        Choices choices = new Choices();
        buttonChoice1.setText(choices.getChoice1());
        buttonChoice2.setText(choices.getChoice2());
        buttonChoice3.setText(choices.getChoice3());
        buttonChoice4.setText(choices.getChoice4());

        buttonChoice1.setOnClickListener(v -> {
            calculateScore(0);
            if (choices.getIndexCount() == choices.getQuestionListSize() - 1){
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("score", score.getScore());
                startActivity(intent);
                finish();
                return;
            }
            choices.incrementCount();
            buttonChoice1.setText(choices.getChoice1());
            buttonChoice2.setText(choices.getChoice2());
            buttonChoice3.setText(choices.getChoice3());
            buttonChoice4.setText(choices.getChoice4());
        });

        buttonChoice2.setOnClickListener(v -> {
            calculateScore(1);
            if (choices.getIndexCount() == choices.getQuestionListSize() - 1){
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("score", score.getScore());
                startActivity(intent);
                finish();
                return;
            }
            choices.incrementCount();
            buttonChoice1.setText(choices.getChoice1());
            buttonChoice2.setText(choices.getChoice2());
            buttonChoice3.setText(choices.getChoice3());
            buttonChoice4.setText(choices.getChoice4());
        });

        buttonChoice3.setOnClickListener(v -> {
            calculateScore(2);
            if (choices.getIndexCount() == choices.getQuestionListSize() - 1){
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("score", score.getScore());
                startActivity(intent);
                finish();
                return;
            }
            choices.incrementCount();
            buttonChoice1.setText(choices.getChoice1());
            buttonChoice2.setText(choices.getChoice2());
            buttonChoice3.setText(choices.getChoice3());
            buttonChoice4.setText(choices.getChoice4());
        });

        buttonChoice4.setOnClickListener(v -> {
            calculateScore(3);
            if (choices.getIndexCount() == choices.getQuestionListSize() - 1){
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("score", score.getScore());
                startActivity(intent);
                finish();
                return;
            }
            choices.incrementCount();
            buttonChoice1.setText(choices.getChoice1());
            buttonChoice2.setText(choices.getChoice2());
            buttonChoice3.setText(choices.getChoice3());
            buttonChoice4.setText(choices.getChoice4());
        });
    }


    @Override
    public void calculateScore(int btnID) {
        switch (btnID){
            case 0 : score.setScore(score.getScore());
                     score.addZero();
                     break;
            case 1 : score.setScore(score.getScore());
                     score.addOne();
                     break;
            case 2 : score.setScore(score.getScore());
                     score.addTwo();
                     break;
            case 3 : score.setScore(score.getScore());
                     score.addThree();
                     break;
        }

    }
}