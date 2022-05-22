package com.mobile.depressiontest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.mobile.depressiontest.R;

public class MainActivity extends AppCompatActivity {

    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), DepressionTestActivity.class)));
    }
}