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

import com.example.quizaton_alpha.Activities.forsideActivity;
import com.example.quizaton_alpha.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registrereActivity extends AppCompatActivity {
    Intent recievedIntent = getIntent();

    private FirebaseAuth mAuth;
    private ImageView regLogo;
    private EditText regName, regPass, regEmail, regTlf;
    private Button regButton;
    private ProgressBar regProg;
    private TextView regLoggInn;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrer);
        fAuth = FirebaseAuth.getInstance();

        regLogo = (ImageView) findViewById(R.id.regLogo);
        regName = (EditText) findViewById(R.id.regName);
        regPass = (EditText) findViewById(R.id.regPass);
        regEmail = (EditText) findViewById(R.id.regEmail);
        regTlf = (EditText) findViewById(R.id.regTlf);
        regButton = (Button) findViewById(R.id.regButton);
        regProg = (ProgressBar) findViewById(R.id.regProg);
        regLoggInn = (TextView) findViewById(R.id.regLoggInn);

        regLoggInn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regLoggInnIntent = new Intent(getApplicationContext(), logInActivity.class);
                startActivity(regLoggInnIntent);
            }
        });

        regLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regLogoIntent = new Intent(getApplicationContext(), velkommenActivity.class);
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

                if (TextUtils.isEmpty(navn)) {
                    regName.setError("Navn er påkrevd");
                    regName.requestFocus();
                    return;
                } else if (TextUtils.isEmpty(telefon)) {
                    regTlf.setError("Telefon er påkrevd");
                    regTlf.requestFocus();
                    return;
                } else if (telefon.length() != 8) {
                    regTlf.setError("Telefonnummer må bestå av 8 siffer");
                    regTlf.requestFocus();
                    return;
                } else if (TextUtils.isEmpty(email)) {
                    regEmail.setError("Email er påkrevd");
                    regEmail.requestFocus();
                    return;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    regEmail.setError("Skriv inn en gyldig Email adresse");
                    regEmail.requestFocus();
                    return;
                } else if (TextUtils.isEmpty(passord)) {
                    regPass.setError("Passord er påkrevd");
                    regPass.requestFocus();
                    return;
                } else if (passord.length() < 6) {
                    regPass.setError("Passord må være lengre enn 6 karakterer");
                    regPass.requestFocus();
                    return;
                }
                regProg.setVisibility(View.VISIBLE);
                DatabaseReference mDatabase;
                final DatabaseReference[] newUser = new DatabaseReference[1];
                final FirebaseUser[] mCurrentUser = new FirebaseUser[1];
                mDatabase = FirebaseDatabase.getInstance().getReference().child("Brukere");

                fAuth.createUserWithEmailAndPassword(email, passord)
                        .addOnCompleteListener(registrereActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                            if (task.isSuccessful()){
                                                Toast.makeText( registrereActivity.this,"Ny bruker er registrert. Velkommen Quizmaster: "+ navn, Toast.LENGTH_SHORT).show();

                                                mCurrentUser[0] = task.getResult().getUser();
                                                newUser[0] =mDatabase.child(mCurrentUser[0].getUid());


                                                mDatabase.child("Brukere").child("Navn").setValue(navn);
                                                mDatabase.child("Brukere").child("Passord").setValue(passord);
                                                mDatabase.child("Brukere").child("email").setValue(email);
                                                mDatabase.child("Brukere").child("Telefon").setValue(telefon);


                                                Intent regIntent = new Intent(getApplicationContext(), forsideActivity.class);
                                                startActivity(regIntent);

                                            }else {
                                                Toast.makeText(registrereActivity.this, "Registrering feilet: " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                                regProg.setVisibility(View.GONE);
                                            }

                                        }
                        });
            }
        });
    }
}




