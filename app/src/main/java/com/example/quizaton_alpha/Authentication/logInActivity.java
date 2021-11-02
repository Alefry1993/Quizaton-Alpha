package com.example.quizaton_alpha.Authentication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

    }
}
