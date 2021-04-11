package com.h.hodu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CMainActivity extends AppCompatActivity {
    CustomCalendarView customCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCalendarView =(CustomCalendarView)findViewById(R.id.custom_calendar_view);

    }
}
