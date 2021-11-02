package com.example.quizaton_alpha.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.R;

public class popupActivity extends AppCompatActivity {

    private Button menyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lagringpopup);

        menyButton = findViewById(R.id.menyButton);

        menyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menyIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(menyIntent);
            }
        });
}}
