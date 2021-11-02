package com.example.quizaton_alpha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class kategoriActivity extends AppCompatActivity {

    private TextView kategoriView;
    private Button geoButton;
    private Button sportButton;
    private Button vitenskapButton;
    private Button filmtvButton;
    private Button tekButton;
    private Button historieButton;
    private Button blandet1Button;
    private Button blandet2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kategori);
        Intent recievedIntent = getIntent();

        kategoriView = findViewById(R.id.kategoriView);
        geoButton = findViewById(R.id.geoButton);
        sportButton = findViewById(R.id.sportButton);
        vitenskapButton = findViewById(R.id.vitenskapButton);
        filmtvButton = findViewById(R.id.filmtvButton);
        tekButton = findViewById(R.id.tekButton);
        historieButton = findViewById(R.id.historieButton);
        blandet1Button = findViewById(R.id.blandet1Button);
        blandet2Button = findViewById(R.id.blandet2Button);

        geoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),thequiz.class);
                startActivity(startintent);
            }
        });

        sportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),thequiz.class);
                startActivity(startintent);
            }
        });

        vitenskapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),thequiz.class);
                startActivity(startintent);
            }
        });

        filmtvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),thequiz.class);
                startActivity(startintent);
            }
        });

        tekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),thequiz.class);
                startActivity(startintent);
            }
        });

        historieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),thequiz.class);
                startActivity(startintent);
            }
        });

        blandet1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),thequiz.class);
                startActivity(startintent);
            }
        });

        blandet2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),thequiz.class);
                startActivity(startintent);
            }
        });

    }
}
