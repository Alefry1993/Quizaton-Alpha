package com.example.quizaton_alpha.Authentication;

import android.content.Intent;
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

import com.example.quizaton_alpha.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class registrereActivity extends AppCompatActivity {
    Intent recievedIntent = getIntent();

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("User"); //https://quizaton-8c937-default-rtdb.europe-west1.firebasedatabase.app/

    private FirebaseAuth mAuth;
    private ImageView regLogo;
    private EditText regName, regPass, regEmail, regTlf;
    private Button regButton;
    private ProgressBar regProg;
    private TextView regLoggInn;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrer);
        mAuth = FirebaseAuth.getInstance();

        regLogo = (ImageView) findViewById(R.id.regLogo);
        regName = (EditText) findViewById(R.id.regName);
        regPass = (EditText) findViewById(R.id.regPass);
        regEmail = (EditText) findViewById(R.id.regEmail);
        regTlf = (EditText) findViewById(R.id.regTlf);
        regButton = (Button) findViewById(R.id.regButton);
        regProg = (ProgressBar) findViewById(R.id.regProg);
        regLoggInn = (TextView) findViewById(R.id.regLoggInn);

        if (mAuth.getCurrentUser() != null){
            Intent userIntent = new Intent(getApplicationContext(),velkommenActivity.class);
            startActivity(userIntent);
            finish();
        }

        regLoggInn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regLoggInnIntent = new Intent(getApplicationContext(),logInActivity.class);
                startActivity(regLoggInnIntent);
            }
        });

        regLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regLogoIntent = new Intent(getApplicationContext(),velkommenActivity.class);
                startActivity(regLogoIntent);
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String navn = regName.getText().toString().trim();
                String passord = regPass.getText().toString().trim();
                String email = regEmail.getText().toString().trim();
                String telefon = regTlf.getText().toString().trim();

                if(navn.isEmpty()||passord.isEmpty()||email.isEmpty()){
                    Toast.makeText(registrereActivity.this,"Fyll ut alle feltene!",Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(navn)){
                    regName.setError("Navn er påkrevd");
                    regName.requestFocus();
                    return;
                }

                else if (TextUtils.isEmpty(email)){
                    regEmail.setError("Email er påkrevd");
                    regEmail.requestFocus();
                    return;
                }

                else if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    regEmail.setError("Skriv en gyldig Email adresse");
                    regEmail.requestFocus();
                    return;
                }

                else if (TextUtils.isEmpty(passord)){
                    regPass.setError("Passord er påkrevd");
                    regPass.requestFocus();
                    return;
                }

                else if(passord.length() < 6){
                    regPass.setError("Passord må være lengre enn 6 karakterer");
                    regPass.requestFocus();
                    return;
                }

                else{
                    databaseReference.child("users").child(telefon).child("Navn:").child(navn);
                    databaseReference.child("users").child(telefon).child("Email:").child(email);
                    databaseReference.child("users").child(telefon).child("Passord:").child(passord);

                    Toast.makeText(registrereActivity.this,"")
                }


            }
        });
    }
}

