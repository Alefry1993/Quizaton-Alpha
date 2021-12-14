package com.example.quizaton_alpha.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quizaton_alpha.Authentication.logInActivity;
import com.example.quizaton_alpha.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class forsideActivity extends AppCompatActivity {
    public static final String KEY_NAME = "name";
    private Button startButton, egneButton, scoreboardButton, logOutButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent recievedIntent = getIntent();
        setContentView(R.layout.forside);

        startButton = (Button) findViewById(R.id.startButton);
        egneButton = (Button) findViewById(R.id.egneButton);
        scoreboardButton = (Button) findViewById(R.id.scoreboardButton);
        logOutButton = (Button) findViewById(R.id.logOutButton);

        MediaPlayer ring= MediaPlayer.create(forsideActivity.this,R.raw.ring);




        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),kategoriActivity.class);
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
                Intent scoreboardIntent = new Intent(getApplicationContext(),resultatActivity.class);
                startActivity(scoreboardIntent);
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ring.stop();

                Intent logOutIntent = new Intent(getApplicationContext(),com.example.quizaton_alpha.Authentication.velkommenActivity.class);
                startActivity(logOutIntent);
            }
        });
    }


}


