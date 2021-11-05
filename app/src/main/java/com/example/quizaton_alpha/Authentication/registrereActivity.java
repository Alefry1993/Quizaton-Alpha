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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class registrereActivity extends AppCompatActivity {
    Intent recievedIntent = getIntent();

    private FirebaseAuth mAuth;
    private ImageView regLogo;
    private EditText regName, regPass, regEmail, regTlf;
    private Button regButton;
    private ProgressBar regProg;
    private TextView regLoggInn;
    private FirebaseAuth fAuth = FirebaseAuth.getInstance();

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

        if (mAuth.getCurrentUser() != null) {
            Intent userIntent = new Intent(getApplicationContext(), velkommenActivity.class);
            startActivity(userIntent);
            finish();
        }

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

                private DatabaseReference mDatabase, newUser;
                private FirebaseUser mCurrentUser;
                mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
                auth.createUserWithEmailAndPassword(email, passord)
                        .addOnCompleteListener(registrereActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText( registrereActivity.this,"creation of account was: " + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                                if (!task.isSuccessful()) {
                                    Toast.makeText(registrereActivity.this, "Authentication failed: " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                } else {
                                    mCurrentUser= task.getResult().getUser();
                                            newUser=mDatabase.child(mCurrentUser.getUid());


                                    newUser.child("").setValue(navn);
                                    newUser.child("Passord").setValue(passord);
                                    newUser.child("email").setValue(email);
                                    newUser.child("Telefon").setValue(telefon)



                                }
                            });
            }
        });
    }
}


