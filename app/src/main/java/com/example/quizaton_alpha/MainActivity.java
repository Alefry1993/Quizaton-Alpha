package com.example.quizaton_alpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_NAME = "name";
    private TextView introView;
    private Button startButton;
    private Button egneButton;
    private Button scoreboardButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frontpage);


        introView = (TextView) findViewById(R.id.introTittel);
        startButton = (Button) findViewById(R.id.startButton);
        egneButton = (Button) findViewById(R.id.egneButton);
        scoreboardButton = (Button) findViewById(R.id.scoreboardButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),gradActivity.class);
                startActivity(startintent);
            }
        });

        egneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent egneIntent = new Intent (getApplicationContext(),lagActivity.class);
                startActivity(egneIntent);
            }
        });

        scoreboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scoreboardIntent = new Intent(getApplicationContext(),scoreboardActivity.class);
                startActivity(scoreboardIntent);
            }
        });
    }}
