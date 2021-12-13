package com.example.quizaton_alpha.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.R;

public class resultatActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultat);

        TextView resultatLabel = findViewById(R.id.resultatLabel);
        TextView sumScoreLabel = findViewById(R.id.sumScoreLabel);
        TextView kommentar = findViewById(R.id.kommentar);

        int score = getIntent().getIntExtra("RIKTIG_SVAR_ANTALL", 0);

        SharedPreferences sharedPreferences = getSharedPreferences("QUIZ_DATA", Context.MODE_PRIVATE);
        int totalScore = sharedPreferences.getInt("TOTAL_SCORE", 0);
        totalScore = score;

        resultatLabel.setText(score + " / 5");
        sumScoreLabel.setText("Sum poeng: " + totalScore);

        if(totalScore <= 2){
            kommentar.setText("Bedre lykke til neste gang!");

        }else if (totalScore == 3){
            kommentar.setText("Godt forsøk. Godt på vei til å bli en verdig Quizmester!");

        }else if (totalScore >= 4) {
            kommentar.setText("Bra jobbet. Du er en verdig Quizmester!");

        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("TOTAL_SCORE", totalScore);
        editor.apply();

    }

    public void tilbake(View view) {
        startActivity(new Intent(getApplicationContext(), forsideActivity.class));
    }

}
