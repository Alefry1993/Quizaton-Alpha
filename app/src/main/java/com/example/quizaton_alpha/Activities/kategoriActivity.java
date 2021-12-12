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
import com.google.android.material.bottomnavigation.BottomNavigationView;

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
        vitenskapButton = findViewById(R.id.vitenskapButton);
        filmtvButton = findViewById(R.id.filmtvButton);
        tekButton = findViewById(R.id.tekButton);
        historieButton = findViewById(R.id.historieButton);
        blandet1Button = findViewById(R.id.blandet1Button);
        blandet2Button = findViewById(R.id.blandet2Button);

        //Bottom navigation
        bottomNavigation = findViewById(R.id.bottom_navigation);
        controller = Navigation.findNavController(this, R.id.fragmentis);
        NavigationUI.setupWithNavController(bottomNavigation, controller);


        /*geoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),thequiz.class);
                startActivity(startintent);

                DocumentReference docRef = db.collection("Kategori").document("Geografi");
                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Log.d(TAG, "DocumentSnapshot: " + document.getData());
                            } else {
                                Log.d(TAG, "No such document");
                            }
                        } else {
                            Log.d(TAG, "get failed with ", task.getException());
                        }
                    }
                });


            }
        });*/

        geoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinner = findViewById(R.id.geoSpinner);
                int quizKategori = spinner.getSelectedItemPosition();

                // Start Quiz
                Intent intent = new Intent(getApplicationContext(), com.example.quizaton_alpha.quizkategorier.geoquiz.class);
                intent.putExtra("QUIZ_KATEGORI", quizKategori);
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

        vitenskapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),com.example.quizaton_alpha.quizkategorier.vitenskapquiz.class);
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
