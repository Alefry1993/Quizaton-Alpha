package com.example.quizaton_alpha.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.Activities.MainActivity;
import com.example.quizaton_alpha.R;

public class logInActivity extends AppCompatActivity {
    private ImageView logo;
    private EditText email;
    private EditText pass;
    private Button signIn;
    private TextView glemtPass;
    private TextView registrer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        logo = (ImageView) findViewById(R.id.logo);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        signIn = (Button) findViewById(R.id.signIn);
        glemtPass = (TextView) findViewById(R.id.glemtPass);
        registrer = (TextView) findViewById(R.id.register);

        registrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regIntent = new Intent(getApplicationContext(),registrereActivity.class);
                startActivity(regIntent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(signIntent);
            }
        });

    }
}
