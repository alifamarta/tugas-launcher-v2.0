package com.helloworld;

import android.content.Intent;
import android.net.Uri;
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

        clickListener();
    }

    public void clickListener() {
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helloIntent = new Intent(ActivityHomepage.this, MainActivity.class);
                startActivity(helloIntent);
            }
        });

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent countIntent = new Intent(ActivityHomepage.this, CountActivity.class);
                startActivity(countIntent);
            }
        });

        btnScrollice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scrolliceIntent = new Intent(ActivityHomepage.this, ScrollingActivity.class);
                startActivity(scrolliceIntent);
            }
        });

        btnTwoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent twoIntent = new Intent(ActivityHomepage.this, FirstActivity.class);
                startActivity(twoIntent);
            }
        });

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AlarmIntent = new Intent(ActivityHomepage.this, AlarmActivity.class);
                startActivity(AlarmIntent);
            }
        });
    }
}
