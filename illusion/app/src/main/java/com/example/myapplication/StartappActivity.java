package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartappActivity extends AppCompatActivity {
    private ConstraintLayout startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startappmain);
        startButton = findViewById(R.id.startConLayout);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(StartappActivity.this,main));
                Intent intent = new Intent(StartappActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}