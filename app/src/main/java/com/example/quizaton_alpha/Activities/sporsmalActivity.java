package com.example.quizaton_alpha.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.R;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class sporsmalActivity extends AppCompatActivity {

    private TextView antallView;
    private Button fiveButton;
    private Button tenButton;
    private Button twentyButton;
    private ArrayList sporsmalList;

    private FirebaseFirestore firestoreDb;
    private CollectionReference spørsmålCollectionReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.antallsporsmal);
        Intent recievedIntent = getIntent();
        antallView = findViewById(R.id.antallView);
        fiveButton = findViewById(R.id.fiveButton);
        tenButton = findViewById(R.id.tenButton);
        twentyButton = findViewById(R.id.twentyButton);

        firestoreDb = FirebaseFirestore.getInstance();
        sporsmalList = new ArrayList<>();

        spørsmålCollectionReference = firestoreDb.collection("spørsmål");


        fiveButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent lettIntent = new Intent(getApplicationContext(),kategoriActivity.class);
            startActivity(lettIntent);
        }
    });





        tenButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent middelsIntent = new Intent(getApplicationContext(),kategoriActivity.class);
            startActivity(middelsIntent);
        }
    });

        twentyButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent vanskeligIntent = new Intent(getApplicationContext(),kategoriActivity.class);
            startActivity(vanskeligIntent);
        }
    });
}


private void createFireStoreReadListener(){
        spørsmålCollectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        Spørsmål spørsmål = documentSnapshot.toObject(Spørsmål.class);
                        spørsmål.setSpørsmålet(documentSnapshot.getId());
                        sporsmalList.add(spørsmål);

                    }
                }
            }
        });
}

    @Override
    protected void onResume() {
        super.onResume();
        createFireStoreReadListener();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}
