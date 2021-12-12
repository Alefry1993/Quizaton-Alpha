package com.example.quizaton_alpha.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.example.quizaton_alpha.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultLabel = findViewById(R.id.resultLabel);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel);
        Button button = findViewById(R.id.tilbakeQuiz);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        SharedPreferences sharedPreferences = getSharedPreferences("QUIZ_DATA", Context.MODE_PRIVATE);
        int totalScore = sharedPreferences.getInt("TOTAL_SCORE", 0);
        totalScore += score;

        resultLabel.setText(score + " / 5");
        totalScoreLabel.setText("Total Score : " + totalScore);

        // Update total score.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("TOTAL_SCORE", totalScore);
        editor.apply();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(), kategoriActivity.class);
                startActivity(startintent);
            }
        });
    }


}