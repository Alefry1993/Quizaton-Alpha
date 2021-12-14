package com.example.quizaton_alpha.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.quizaton_alpha.R;
import com.example.quizaton_alpha.quizkategorier.naturVitenskapquiz;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class kategoriActivity extends AppCompatActivity {

    private TextView kategoriView;
    private Button geoButton, sportButton, naturVitenskapButton, filmtvButton, tekButton, historieButton, blandet1Button, blandet2Button;
    private BottomNavigationView bottomNavigation;
    private NavController controller;



    private static final String TAG = "DocSnippets";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kategori);
        Intent recievedIntent = getIntent();

        kategoriView = findViewById(R.id.kategoriView);
        geoButton = findViewById(R.id.geoButton);
        sportButton = findViewById(R.id.sportButton);
        naturVitenskapButton = findViewById(R.id.naturVitenskapButton);
        filmtvButton = findViewById(R.id.filmtvButton);
        tekButton = findViewById(R.id.tekButton);
        historieButton = findViewById(R.id.historieButton);
        blandet1Button = findViewById(R.id.blandet1Button);
        blandet2Button = findViewById(R.id.blandet2Button);

        //Bottom navigation
        bottomNavigation = findViewById(R.id.bottom_navigation);
        controller = Navigation.findNavController(this, R.id.fragmentis);
        NavigationUI.setupWithNavController(bottomNavigation, controller);

        geoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.quizaton_alpha.quizkategorier.geoquiz.class);
                startActivity(intent);
            }
        });



        sportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),com.example.quizaton_alpha.quizkategorier.sportquiz.class);
                startActivity(startintent);
            }
        });

        naturVitenskapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(), naturVitenskapquiz.class);
                startActivity(startintent);
            }
        });

        filmtvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),com.example.quizaton_alpha.quizkategorier.filmtvquiz.class);
                startActivity(startintent);
            }
        });

        tekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),com.example.quizaton_alpha.quizkategorier.teknologiquiz.class);
                startActivity(startintent);
            }
        });

        historieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),com.example.quizaton_alpha.quizkategorier.historiequiz.class);
                startActivity(startintent);
            }
        });

        blandet1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),com.example.quizaton_alpha.quizkategorier.blandet1quiz.class);
                startActivity(startintent);
            }
        });

        blandet2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),com.example.quizaton_alpha.quizkategorier.blandet2quiz.class);
                startActivity(startintent);
            }
        });

    }
}
