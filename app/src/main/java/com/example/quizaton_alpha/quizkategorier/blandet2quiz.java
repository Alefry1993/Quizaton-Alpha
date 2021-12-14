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

import com.example.quizaton_alpha.Activities.forsideActivity;
import com.example.quizaton_alpha.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class blandet2quiz extends AppCompatActivity {
    private TextView sporsmalsrunde, sporsmal;
    private Button svar1, svar2, svar3, svar4, tilbake;
    private String riktigSvar;
    private int riktigSvarAntall = 0;
    private int quizAntall = 1;
    static final private int QUIZ_Antall = 10;



    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();


    String quizData[][] = {
            {"Hva het den italienske vitenskapsmannen som oppfant batteriet en gang på 1700-tallet?", "Alessandro Volta", "Luigi Galvani", "Andre Ampere", "Georg Simon Ohm"},
            {"Hvor ble Asialekene først holdt?", "New Dehli", "Bangkok", "Jakarta", "Hangzhou"},
            {"En av verdens mest populære mobilapplikasjoner er utviklet av kinesiske ByteDance. Hva heter denne appen?", "Tik Tok", "Instagram", "Snapchat", "Twitter"},
            {"Hvilken sport er den eneste som har blitt spilt på månen?", "Golf", "Fotball", "Basketball", "Boksing"},
            {"Hva står forkortelsen DOS for?", "Disk Operating System", "Data Operating System", "Domain Operating System", "Digital Operating System"},
            {"Hva heter det kinesiske bilmerket på tre bokstaver, som spesialiserer seg på elbiler?", "NIO", "VOT", "WAT", "NEO"},
            {"Hva kalles lagkapteinen på et curling-lag?", "Skip", "Vise-skip", "Lead", "Toer "},
            {"Hva heter tekstbehandlingsprogrammet i Apples iWork-pakke?", "Pages", "Notes", "Text", "Paper"},
            {"I hvilket stjernebilde ligger Polarstjernen?", "Lille bjørn", "Karlsvogna", "Store Bjørn", "Orion"},
            {"Hvilken sport hører Tour de France til?", "Sykling", "Roing", "Fotball", "Løping"},
            {"Bilderedigeringsprogrammet til Adobe er holdt for å være det beste på markedet. Hva heter dette programmet?", "Adobe Photoshop", "Adobe Premier Pro", "Adobe Dreamweaver", "Adobe Flash"},
            {"Hva heter den andre planeten fra Sola i vårt solsystem?", "Venus", "Merkur", "Jorda","Saturn"},
            {"Hvilken sport har et spillområde på 2.7×1.5m?", "Bordtennis", "Tennis", "Squash", "Innebandy"},
            {"Hvilket operativsystem etterfulgte Windows 95?", "Windows 98", "Windows 2000", "Windows Vista", "Windows XP"},
            {"Hva heter det største landbaserte pattedyret på jorden?", "Afrikansk savannelefant", "Asiatisk Neshorn", "Blåhval", "Sibirsk Tiger"},
            {"Hvilken formel 1 løper har vunnet flest formel 1 løp i historien (2021)?", "Lewis Hamilton", "Michael Schumacher", "Sebastian Vettel", "Fernando Alonso"},
            {"Hvilket kjent programmeringsspråk er utviklet av danske Bjarne Stroustrup?", "C++", "Java", "Javascript", "Phyton"},
            {"Hvilket pattedyr er det eneste som kan fly?", "Flaggermus", "Ørn", "Måke", "Pingvin"},
            {"Hvem oppfant basketball?", "James Naismith", "Kevin Durant", "LeBron James", "Frank Mahan"},
            {"Hva er spillkonsollnavnet NES en forkortelse for?", "Nintendo Entertainment System", "Nintendo Enterprise System", "Nintendo Entertainment Spillkonsoll", "National Electrical System"},
            {"Hva slags stoff fylles i hjulene på fly i stedet for vanlig luft?", "Nitrogen", "Helium", "Hydrogen", "Karbodioksid"},
            {" Hvilken idrettsutøver var den første til å vinne fem Wimbledon titler på rad?", "Bjørn Borg", "Pete Sampras", "Roger Federer", "Rafael Nadal"},
            {"Hva heter operativsystemet som både iPhone og iPad kjører på?", "iOS", "Android", "Linux", "Windows"},
            {"Hva heter den kinesiske millionbyen hvor en ny type coronavirus ble påvist i desember 2019?", "Wuhan", "Beijing", "Shanghai", "Hong Kong "},
            {"Hva heter hjemmebanen til Manchester United?", "Old Trafford", "Anfield", "Emirates Stadium", "Camp Nou"},
            {"Hvem står bak frontend rammeverket React?", "Facebook", "IBM", "Microsoft", "Google"},
            {"Hvilken sport er den eneste som har blitt spilt på månen?", "Golf", "Fotball", "Basketball", "Boksing"},
            {"Hvor mange OL gull har Marit Bjørgen?", "8 Gull", "13 Gull", "3 Gull", "Ingen Gull"},
            {"Hvilket dataspill ble det nylig funnet en alvorlig sårbarhet i?", "Fortnite", "League of legends", "Minecraft", "World of warcraft"},
            {"Hva er hakket under orkan på Beaufortskalaen?", "Sterk storm", "Full storm", "Sterk kuling", "Ekstrem kuling"}
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
