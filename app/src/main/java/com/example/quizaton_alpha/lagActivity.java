package com.example.quizaton_alpha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lagActivity extends AppCompatActivity {

    private Button sendSporsmalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lagsporsmal);

        sendSporsmalButton = findViewById(R.id.sendButton);

        sendSporsmalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(getApplicationContext(),popupActivity.class);
                startActivity(sendIntent);
            }
        });
    }}