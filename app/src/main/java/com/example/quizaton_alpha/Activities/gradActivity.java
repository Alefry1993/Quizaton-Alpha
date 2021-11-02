package com.example.quizaton_alpha.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.R;

public class gradActivity extends AppCompatActivity {

    private TextView gradTittel;
    private Button lettButton;
    private Button middelsButton;
    private Button vanskeligButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vanskelighetsgrad);

        Intent recievedIntent = getIntent();
        gradTittel = findViewById(R.id.gradTittel);
        lettButton = findViewById(R.id.lettButton);
        middelsButton = findViewById(R.id.middelsButton);
        vanskeligButton = findViewById(R.id.vanskeligButton);


        lettButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lettButtonActivity();
            }
        });

        middelsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                middelsButtonActivity();
            }
        });

        vanskeligButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vanskeligButtonActivity();
            }
        });

    }

    private void lettButtonActivity() {
        Intent lettIntent = new Intent(getApplicationContext(),sporsmalActivity.class);
        startActivity(lettIntent);
    }

    private void middelsButtonActivity() {
        Intent middelsIntent = new Intent(getApplicationContext(),sporsmalActivity.class);
        startActivity(middelsIntent);
    }

    private void vanskeligButtonActivity() {
        Intent vanskeligIntent = new Intent(getApplicationContext(),sporsmalActivity.class);
        startActivity(vanskeligIntent);
    }
}
