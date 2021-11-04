package com.example.quizaton_alpha.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

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

        regLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regLogoIntent = new Intent(getApplicationContext(),velkommenActivity.class);
                startActivity(regLogoIntent);
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regButton:
                registrerBruker();
        }
    }

    private void registrerBruker(){
        String navn = regName.getText().toString().trim();
        String email = regEmail.getText().toString().trim();
        String passord = regPass.getText().toString().trim();

        if (navn.isEmpty()){
            regName.setError("Navn er påkrevd");
            regName.requestFocus();
            return;
        }

        if (email.isEmpty()){
            regEmail.setError("Email er påkrevd");
            regEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            regEmail.setError("Vennligst skriv en gyldig Email adresse");
            regEmail.requestFocus();
            return;

        }

        if (passord.isEmpty()){
            regPass.setError("Passord er påkrevd");
            regPass.requestFocus();
            return;
        }

        if(passord.length() < 6){
            regPass.setError("Passord må være lengre enn 6 karakterer");
            regPass.requestFocus();
            return;
        }

        regProg.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, passord)
                .addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            brukerActivity bruker = new brukerActivity(navn,email);
                           // Push this

                            FirebaseDatabase.getInstance().getReference("Brukere")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(bruker).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(registrereActivity.this, "Ny Bruker har blitt registrert!", Toast.LENGTH_LONG).show();
                                        regProg.setVisibility(View.VISIBLE);
                                    }else{
                                        Toast.makeText(registrereActivity.this, "Ny Bruker ble ikke registrert. Prøv på nytt!", Toast.LENGTH_LONG).show();
                                        regProg.setVisibility(View.GONE);
                                    }
                                }
                            });

                        }else {
                            Toast.makeText(registrereActivity.this, "Ny Bruker ble ikke registrert!", Toast.LENGTH_LONG).show();
                            regProg.setVisibility(View.GONE);




                        }
                    }
                });

    }
}
