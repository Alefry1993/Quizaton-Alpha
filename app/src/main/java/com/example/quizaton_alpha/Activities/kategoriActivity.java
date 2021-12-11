package com.example.quizaton_alpha.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.quizaton_alpha.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

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

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //Bottom navigation

        BottomNavigationView navView = findViewById(R.id.bottom_navigation);
        NavController navController = Navigation.findNavController(this, R.id.fragments);
        NavigationUI.setupWithNavController(bottomNavigation, navController);


        geoButton.setOnClickListener(new View.OnClickListener() {
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
