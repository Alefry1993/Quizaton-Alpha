package com.example.quizaton_alpha.Activities;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class thequiz extends AppCompatActivity {

    //FirebaseFirestore db;

    //static final String TAG = "Read Data Activity";


    private TextView sporsmalsrunde, sporsmal;
    private Button svar1, svar2, svar3, svar4;
    private String riktigSvar;
    private int riktigSvarAntall = 0;
    private int quizAntall = 1;
    static final private int QUIZ_Antall = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();


    String quizData[][] = {
            {"Norge", "Oslo", "Bergen", "Trondheim", "Fredrikstad"},
            {"Sverige", "Stockholm", "Gøteborg", "Malmø", "Uppsala"},
            {"Danmark", "København", "Århus", "Odense", "Ålborg"}
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thequiz);

        sporsmalsrunde = findViewById(R.id.sporsmalsrunde);
        sporsmal = findViewById(R.id.sporsmal);
        svar1 = findViewById(R.id.svar1);
        svar2 = findViewById(R.id.svar2);
        svar3 = findViewById(R.id.svar3);
        svar4 = findViewById(R.id.svar4);

        int quizKategori = getIntent().getIntExtra("QUIZ_KATEGORI", 0);
        Log.v("KATEGORI", quizKategori + "");


        for (int i = 0; i < quizData.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            quizArray.add(tmpArray);

        }
        showNextQuiz();



    }


    public void showNextQuiz() {
        sporsmalsrunde.setText("Q" + sporsmal);


        Random random = new Random();
        int randomTall = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomTall);

        sporsmal.setText(quiz.get(0));
        riktigSvar = quiz.get(1);


        quiz.remove(0);
        Collections.shuffle(quiz);


        svar1.setText(quiz.get(0));
        svar1.setText(quiz.get(1));
        svar1.setText(quiz.get(2));
        svar1.setText(quiz.get(3));

        quizArray.remove(randomTall);
    }


    public void sjekkSvar (View view) {
        Button svarButton = findViewById(view.getId());
        String buttonText = svarButton.getText().toString();


        String beskjedTittel;

        if (buttonText.equals(riktigSvar)) {
            beskjedTittel = "Riktig!";
            riktigSvarAntall++;
        }else {
            beskjedTittel = "Feil";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(beskjedTittel);
        builder.setMessage("Svaret er: " + riktigSvar);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizAntall == QUIZ_Antall) {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIKTIG_SVAR_ANTALL", riktigSvarAntall);
                    startActivity(intent);
                }else {
                    quizAntall++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();







    }





    /*public void customObject() {
        DocumentReference docRef = db.collection("Kategori").document("Geografi/Spørsmål");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Spørsmål spørsmål = documentSnapshot.toObject(Spørsmål.class);
            }
        });
    }*/



}
