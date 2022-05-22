package com.mobile.depressiontest.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mobile.depressiontest.R;
import com.mobile.depressiontest.adapters.HistoryAdapter;
import com.mobile.depressiontest.global.Util;
import com.mobile.depressiontest.models.History;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView rvHistory;
    private ImageView ivBack;
    private HistoryAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initViews();
    }

    private void initViews() {
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> finish());

        rvHistory = findViewById(R.id.rvHistory);
        List<History> list = Util.getHistoryList(getApplicationContext());
        if(list != null) {
            rvHistory.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
            rvHistory.addItemDecoration(new DividerItemDecoration(rvHistory.getContext(), DividerItemDecoration.VERTICAL));
            Collections.reverse(list);
            historyAdapter = new HistoryAdapter(list, getApplicationContext());
            rvHistory.setAdapter(historyAdapter);
        }
    }
}