package com.mobile.depressiontest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.mobile.depressiontest.R;
import com.mobile.depressiontest.global.Util;
import com.mobile.depressiontest.models.History;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnStart, btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnStart = findViewById(R.id.btnStart);
        btnHistory = findViewById(R.id.btnHistory);

        btnStart.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), DepressionTestActivity.class)));

        btnHistory.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
        });
    }
}