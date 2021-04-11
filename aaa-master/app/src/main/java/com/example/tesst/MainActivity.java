package com.example.tesst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Button ther_btn;
    Button heart_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ther_btn = findViewById(R.id.thermo);
        heart_btn = findViewById(R.id.hbeat);
        ther_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트 선언 -> 현재 액티비티에서 넘어갈 액티비티
                Intent intent = new Intent(MainActivity.this,ThermoActivity.class);
                startActivity(intent);
            }
        });
        heart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트 선언 -> 현재 액티비티에서 넘어갈 액티비티
                Intent intent = new Intent(MainActivity.this,Heartbeat.class);
                startActivity(intent);
            }
        });
    }
}
