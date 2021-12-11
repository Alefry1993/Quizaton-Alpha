package com.example.quizaton_alpha.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.Activities.sporsmalActivity;
import com.example.quizaton_alpha.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

public class profileActivity extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    private Button logOut;
    private EditText navnText,emailText,tlfText;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        logOut = (Button) findViewById(R.id.logOutButton);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent logOutIntent = new Intent(getApplicationContext(), velkommenActivity.class);
                startActivity(logOutIntent);
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Brukere");
        userID = user.getUid();

        navnText = findViewById(R.id.profNavn);
        emailText = findViewById(R.id.profEmail);
        tlfText = findViewById(R.id.profTlf);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                bruker brukerProfil = snapshot.getValue(bruker.class);

                if (brukerProfil != null){
                    String navn = brukerProfil.navn;
                    String email = brukerProfil.email;
                    String telefon = brukerProfil.tlf;

                    navnText.setText(navn);
                    emailText.setText(email);
                    tlfText.setText(telefon);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(profileActivity.this,"")

            }
        });



    }
}
