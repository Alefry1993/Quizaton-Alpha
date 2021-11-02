package com.example.quizaton_alpha.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.R;

public class sporsmalActivity extends AppCompatActivity {

    private TextView antallView;
    private Button fiveButton;
    private Button tenButton;
    private Button twentyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.antallsporsmal);
        Intent recievedIntent = getIntent();
        antallView = findViewById(R.id.antallView);
        fiveButton = findViewById(R.id.fiveButton);
        tenButton = findViewById(R.id.tenButton);
        twentyButton = findViewById(R.id.twentyButton);

        fiveButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent lettIntent = new Intent(getApplicationContext(),kategoriActivity.class);
            startActivity(lettIntent);
        }
    });

        tenButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent middelsIntent = new Intent(getApplicationContext(),kategoriActivity.class);
            startActivity(middelsIntent);
        }
    });

        twentyButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent vanskeligIntent = new Intent(getApplicationContext(),kategoriActivity.class);
            startActivity(vanskeligIntent);
        }
    });
}}
