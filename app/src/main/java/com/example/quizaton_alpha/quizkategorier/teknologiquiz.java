package com.example.quizaton_alpha.quizkategorier;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.Activities.ResultActivity;
import com.example.quizaton_alpha.Activities.forsideActivity;
import com.example.quizaton_alpha.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class teknologiquiz extends AppCompatActivity {
    private TextView sporsmalsrunde, sporsmal;
    private Button svar1, svar2, svar3, svar4, tilbake;
    private String riktigSvar;
    private int riktigSvarAntall = 0;
    private int quizAntall = 1;
    static final private int QUIZ_Antall = 5;



    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();


    String quizData[][] = {
            {"En av verdens mest populære mobilapplikasjoner er utviklet av kinesiske ByteDance. Hva heter denne appen?", "Tik Tok", "Instagram", "Snapchat", "Twitter"},
            {"Hva står forkortelsen DOS for?", "Disk Operating System", "Data Operating System", "Domain Operating System", "Digital Operating System"},
            {"Hva heter tekstbehandlingsprogrammet i Apples iWork-pakke?", "Pages", "Notes", "Text", "Paper"},
            {"Bilderedigeringsprogrammet til Adobe er holdt for å være det beste på markedet. Hva heter dette programmet?", "Adobe Photoshop", "Adobe Premier Pro", "Adobe Dreamweaver", "Adobe Flash"},
            {"Hvilket operativsystem etterfulgte Windows 95?", "Windows 98", "Windows 2000", "Windows Vista", "Windows XP"},
            {"Hvilket kjent programmeringsspråk er utviklet av danske Bjarne Stroustrup?", "C++", "Java", "Javascript", "Phyton"},
            {"Hva er spillkonsollnavnet NES en forkortelse for?", "Nintendo Entertainment System", "Nintendo Enterprise System", "Nintendo Entertainment Spillkonsoll", "National Electrical System"},
            {"Hva heter operativsystemet som både iPhone og iPad kjører på?", "iOS", "Android", "Linux", "Windows"},
            {"Hvem står bak frontend rammeverket React?", "Facebook", "IBM", "Microsoft", "Google"},
            {"Hvilket dataspill ble det nylig funnet en alvorlig sårbarhet i?", "Fortnite", "League of legends", "Minecraft", "World of warcraft"}
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thequiz);

        sporsmalsrunde = findViewById(R.id.antallSporsmal);
        sporsmal = findViewById(R.id.sporsmal);
        svar1 = findViewById(R.id.svar1);
        svar2 = findViewById(R.id.svar2);
        svar3 = findViewById(R.id.svar3);
        svar4 = findViewById(R.id.svar4);
        tilbake = findViewById(R.id.tilbake);

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
        sporsmalsrunde.setText("Spørsmål " + quizAntall);


        Random random = new Random();
        int randomTall = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomTall);

        sporsmal.setText(quiz.get(0));
        riktigSvar = quiz.get(1);


        quiz.remove(0);
        Collections.shuffle(quiz);


        svar1.setText(quiz.get(0));
        svar2.setText(quiz.get(1));
        svar3.setText(quiz.get(2));
        svar4.setText(quiz.get(3));

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
                    Intent intent = new Intent(getApplicationContext(), com.example.quizaton_alpha.Activities.resultatActivity.class);
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

        tilbake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tilbakeIntent = new Intent(getApplicationContext(), forsideActivity.class);
                startActivity(tilbakeIntent);
            }
        });
}}
