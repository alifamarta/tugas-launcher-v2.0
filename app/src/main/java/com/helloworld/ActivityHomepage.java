package com.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityHomepage extends AppCompatActivity {
    Button btnHello;
    Button btnCount;
    Button btnScrollice;
    Button btnTwoActivity;
    Button btnAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        btnHello = findViewById(R.id.btnHello);
        btnCount = findViewById(R.id.btnCount);
        btnScrollice = findViewById(R.id.btnScrollice);
        btnTwoActivity = findViewById(R.id.btnTwoActivity);
        btnAlarm = findViewById(R.id.btnAlarm);

        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHomepage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHomepage.this, CountActivity.class);
                startActivity(intent);
            }
        });

        btnScrollice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHomepage.this, ScrollingActivity.class);
                startActivity(intent);
            }
        });

        btnTwoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHomepage.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHomepage.this, AlarmActivity.class);
                startActivity(intent);
            }
        });
    }
}
