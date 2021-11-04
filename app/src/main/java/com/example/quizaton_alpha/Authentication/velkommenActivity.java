package com.example.quizaton_alpha.Authentication;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.R;

public class velkommenActivity extends AppCompatActivity {
    private ImageView logo;
    private Button loggInn, regBruker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.useroptions);

        logo = (ImageView) findViewById(R.id.frontLogo);
        loggInn = (Button) findViewById(R.id.loggInn);
        regBruker = (Button) findViewById(R.id.regBruker);

        loggInn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loggIntent = new Intent(getApplicationContext(),logInActivity.class);
                startActivity(loggIntent);
            }
        });

        regBruker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(getApplicationContext(),registrereActivity.class);
                startActivity(regIntent);
            }
        });
    }
}
