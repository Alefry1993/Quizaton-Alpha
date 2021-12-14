package com.example.quizaton_alpha.Authentication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.Activities.forsideActivity;
import com.example.quizaton_alpha.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class logInActivity extends AppCompatActivity {
    private ImageView logo;
    private EditText email;
    private EditText pass;
    private Button signIn;
    private TextView registrer;
    private ProgressBar signProg;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mAuth = FirebaseAuth.getInstance();
        logo = (ImageView) findViewById(R.id.logo);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        signIn = (Button) findViewById(R.id.signIn);
        registrer = (TextView) findViewById(R.id.register);
        signProg = (ProgressBar) findViewById(R.id.signProg);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoIntent = new Intent(getApplicationContext(),velkommenActivity.class);
                startActivity(logoIntent);
            }
        });

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
                String signEmail = email.getText().toString().trim();
                String passord = pass.getText().toString().trim();

                MediaPlayer music = MediaPlayer.create(logInActivity.this, R.raw.ring);

                if (TextUtils.isEmpty(signEmail)) {
                    email.setError("Email er påkrevd");
                    email.requestFocus();
                    return;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(signEmail).matches()){
                    email.setError("Skriv inn en gyldig Email adresse");
                    email.requestFocus();
                    return;
                } else if (TextUtils.isEmpty(passord)) {
                    pass.setError("Passord er påkrevd");
                    pass.requestFocus();
                    return;
                } else if (passord.length() < 6) {
                    pass.setError("Passord må være lengre enn 6 karakterer");
                    pass.requestFocus();
                    return;
                }
                signProg.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(signEmail, passord)
                        .addOnCompleteListener(logInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {


                                if (task.isSuccessful()) { ;
                                    Toast.makeText( logInActivity.this,"Du er logget inn. Velkommen tilbake Quizmaster!", Toast.LENGTH_SHORT).show();


                                    music.start();

                                    Intent signIntent = new Intent(getApplicationContext(), forsideActivity.class);
                                    startActivity(signIntent);
                                }else{
                                    Toast.makeText(logInActivity.this, "Logg inn feilet: " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                    signProg.setVisibility(View.GONE);

                                    music.stop();


                                }
                                }
                        });




            }
        });

    }
}
