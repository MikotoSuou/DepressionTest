package com.mobile.depressiontest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobile.depressiontest.R;
import com.mobile.depressiontest.global.Constants;
import com.mobile.depressiontest.global.Util;
import com.mobile.depressiontest.models.History;
import com.mobile.depressiontest.models.ResultInterface;

import java.lang.reflect.Array;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ResultActivity extends AppCompatActivity implements ResultInterface {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";

    Button btnRetakeTest, btnHomeScreen;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        displayValues();
        saveResult();
        btnHomeScreen = findViewById(R.id.btnHomeScreen);

        btnHomeScreen.setOnClickListener(v -> finish());
    }

    @Override
    public void displayValues() {

        tvResults = findViewById(R.id.tvResults);

        int score = getIntent().getExtras().getInt("score");
        if (score != 0 && score <= 10)
        {
            tvResults.setText(Constants.NORMAL);
        }
        else if (score >= 11 && score <= 16)
        {
            tvResults.setText(Constants.MILD_MOOD_DISTURBANCE);
        }
        else if (score >= 17 && score <= 20)
        {
            tvResults.setText(Constants.BORDERLINE_DEPRESSION);
        }
        else if (score >= 21 && score <= 30)
        {
            tvResults.setText(Constants.MODERATE_DEPRESSION);
        }
        else if (score >= 31 && score <= 40)
        {
            tvResults.setText(Constants.SEVERE_DEPRESSION);
        }
        else if (score >= 40)
        {
            tvResults.setText(Constants.Extreme_DEPRESSION);
        }
        else {
            tvResults.setText(Constants.NOT_DEPRESSED);
        }
    }

    private void saveResult() {
        int score = getIntent().getExtras().getInt("score");
        List<History> historyList = Util.getHistoryList(getApplicationContext());

        ArrayList<History> list;
        if(historyList != null) {
            list = (ArrayList<History>) historyList;
        } else {
            list = new ArrayList<>();
        }


        if (score != 0 && score <= 10)
        {
            list.add(new History(String.valueOf(score), Constants.NORMAL, formattedDate(), formattedTime()));
        }
        else if (score >= 11 && score <= 16)
        {
            list.add(new History(String.valueOf(score), Constants.MILD_MOOD_DISTURBANCE, formattedDate(), formattedTime()));
        }
        else if (score >= 17 && score <= 20)
        {
            list.add(new History(String.valueOf(score), Constants.BORDERLINE_DEPRESSION, formattedDate(), formattedTime()));
        }
        else if (score >= 21 && score <= 30)
        {
            list.add(new History(String.valueOf(score), Constants.MODERATE_DEPRESSION, formattedDate(), formattedTime()));
        }
        else if (score >= 31 && score <= 40)
        {
            list.add(new History(String.valueOf(score), Constants.SEVERE_DEPRESSION, formattedDate(), formattedTime()));
        }
        else if (score >= 40)
        {
            list.add(new History(String.valueOf(score), Constants.Extreme_DEPRESSION, formattedDate(), formattedTime()));
        }
        else {
            list.add(new History(String.valueOf(score), Constants.NOT_DEPRESSED, formattedDate(), formattedTime()));
        }

        Util.setObjectList(getApplicationContext(), list);
    }

    @SuppressLint("SimpleDateFormat")
    private String currentDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(cal.getTime());
    }

    @SuppressLint("SimpleDateFormat")
    private String currentTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        return sdf.format(cal.getTime());
    }

    private String formattedDate() {
        String date = currentDate();
        String year = date.split("-")[0];
        int month = Integer.parseInt(date.split("-")[1]);
        String day = date.split("-")[2];
        String formattedMonth = new DateFormatSymbols().getShortMonths()[month-1];

        return formattedMonth + " " + day + ", " + year;
    }

    private String formattedTime() {
        String time = currentTime();
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];

        if(Integer.parseInt(hour) > 12) {
            time = (Integer.parseInt(hour) - 12)+ ":" + minute + " PM";
        } else {
            time = hour + ":" + minute + " AM";
        }

        return time;
    }
}
