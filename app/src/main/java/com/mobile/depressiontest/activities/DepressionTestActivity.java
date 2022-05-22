package com.mobile.depressiontest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobile.depressiontest.R;
import com.mobile.depressiontest.models.Choices;

public class DepressionTestActivity extends AppCompatActivity {
    Button buttonChoice1, buttonChoice2, buttonChoice3, buttonChoice4;

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
            choices.incrementCount();
            buttonChoice1.setText(choices.getChoice1());
            buttonChoice2.setText(choices.getChoice2());
            buttonChoice3.setText(choices.getChoice3());
            buttonChoice4.setText(choices.getChoice4());
        });

        buttonChoice2.setOnClickListener(v -> {
            choices.incrementCount();
            buttonChoice1.setText(choices.getChoice1());
            buttonChoice2.setText(choices.getChoice2());
            buttonChoice3.setText(choices.getChoice3());
            buttonChoice4.setText(choices.getChoice4());
        });

        buttonChoice3.setOnClickListener(v -> {
            choices.incrementCount();
            buttonChoice1.setText(choices.getChoice1());
            buttonChoice2.setText(choices.getChoice2());
            buttonChoice3.setText(choices.getChoice3());
            buttonChoice4.setText(choices.getChoice4());
        });

        buttonChoice4.setOnClickListener(v -> {
            choices.incrementCount();
            buttonChoice1.setText(choices.getChoice1());
            buttonChoice2.setText(choices.getChoice2());
            buttonChoice3.setText(choices.getChoice3());
            buttonChoice4.setText(choices.getChoice4());
        });
    }

}