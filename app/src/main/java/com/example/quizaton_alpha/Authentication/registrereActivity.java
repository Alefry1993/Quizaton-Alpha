package com.example.quizaton_alpha.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.R;
import com.google.firebase.auth.FirebaseAuth;

public class registrereActivity extends AppCompatActivity implements View.OnClickListener {
    Intent recievedIntent = getIntent();
    private FirebaseAuth mAuth;
    private ImageView regLogo;
    private EditText regName, regPass, regEmail;
    private Button regButton;
    private ProgressBar regProg;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrer);
        mAuth = FirebaseAuth.getInstance();

        regLogo = (ImageView) findViewById(R.id.regLogo);
        regName = (EditText) findViewById(R.id.regName);
        regPass = (EditText) findViewById(R.id.regPass);
        regEmail = (EditText) findViewById(R.id.regEmail);
        regButton = (Button) findViewById(R.id.regButton);
        regProg = (ProgressBar) findViewById(R.id.regProg);

        regButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regButton:
                registrerBruker();
        }
    }

    private void registrerBruker(){
        String name = regName.getText().toString().trim();
        String email = regEmail.getText().toString().trim();
        String password = regPass.getText().toString().trim();

        if (name.isEmpty()){
            regName.setError("");
        }



    }
}
