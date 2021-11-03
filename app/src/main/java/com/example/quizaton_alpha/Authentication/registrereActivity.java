package com.example.quizaton_alpha.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.R;
import com.google.firebase.auth.FirebaseAuth;

public class registrereActivity extends AppCompatActivity {
    Intent recievedIntent = getIntent();
    private FirebaseAuth mAuth;
    private ImageView logo;
    private EditText regName, regPass, regEmail;
    private Button regButton;
    private ProgressBar regProg;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrer);
        mAuth = FirebaseAuth.getInstance();

        logo = (ImageView) findViewById(R.id.logo);
        regEmail = (EditText) findViewById(R.id.email);
        regEmail = (EditText) findViewById(R.id.email);
        regEmail = (EditText) findViewById(R.id.email);
    }
}
