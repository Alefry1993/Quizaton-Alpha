package com.example.quizaton_alpha.quizkategorier;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
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

public class blandet1quiz extends AppCompatActivity {
    private TextView sporsmalsrunde, sporsmal;
    private Button svar1, svar2, svar3, svar4, tilbake;
    private String riktigSvar;
    private int riktigSvarAntall = 0;
    private int quizAntall = 1;
    static final private int QUIZ_Antall = 10;



    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();


    String quizData[][] = {
            {"I hvilket land ligger hotellet hvor handlingen i Paradise Hotel foregår?", "Mexico", "Spania", "Portugal", "Gran Canaria"},
            {"Hva er hovedstaden i Spania?", "Madrid", "Zaragoza", "Bilbao", "Salamanca"},
            {"Når foregikk den Første verdenskrig (årstall start-slutt)?", "1914 til 1918", "1910 til 1914", "1918 til 1925", "1900 til 1910"},
            {"Hva er hovedstaden i Moldova?", "Chișinău", "Tiraspol", "Balti", "Riscani"},
            {"Hvilken Nordmann ble tildelt Nobels fredspris i 1922?", "Fridtjof Nansen", "Roald Amundsen", "Thor Heierdal", "Bjørnstjerne Bjørnson"},
            {"Hva heter Supermanns hjemplanet?", "Krypton", "Origon", "Helios", "Jorden"},
            {"Hva er hovedstaden i Sverige?", "Stockholm", "Göteborg", "Malmö", "Uppsala"},
            {"Hvilket århundre startet 'Hundreårskrigen'?", "1300-tallet", "1400-tallet", "1500-tallet", "1600-tallet"},
            {"Hvilken avis jobber Peter Parker (aka Spider-Man) for?", "The Daily Bugle", "The Daily Planet", "The Daily Paper", "The Daily News"},
            {"Hva er hovedstaden i Norge?", "Oslo", "Bergen", "Trondheim", "Fredrikstad"},
            {"I hvilket år var Berlinmurens fall?", "1989", "1990", "1987", "1980"},
            {"Hvilken barnelek med dødelig utgang for mange av spillerne, finner sted allerede i første episode av Squid Game?", "Rødt lys", "Gjemsel", "Sisten", "Haien kommer"},
            {"Hva er hovedstaden i Surinam?", "Paramaribo", "Afobakka", "Kwamalasamutu", "Peleloetepu"},
            {"I hvilket år sank Titanic?", "1912", "1915", "1910", "1914"},
            {"Hvem spiller den grønne helten i filmen The Mask fra 1994?", "Jim Carrey", "Bruce Willis", "Tom Cruise", "Zac Efron"},
            {"Hva er hovedstaden i Mexico?", "Mexico City", "Monterrey", "Matamoros", "Guadalajara"},
            {"Hvilken by var det nordmennene kalte Jorsal på Sigurd Jorsalfares tid?", "Jerusalem", "Betlehem", "Sarajevo", "Jordan"},
            {"Hva heter Batman når han ikke har på seg masken?", "Bruce Wayne", "Bruce Banner", "Clark Kent", "Barry Allen"},
            {"Hva er hovedstaden i Argentina?", "Buenos Aires", "San Rafael", "Bahia Blanca", "Mendoza"},
            {"Hvilken nobelspris mottok Winston Churchill i 1953?", "Litteratur", "Fysikk", "Kjemi", "Fred"},
            {"I hvilken stor-film fra 1997 ser vi at Jack og Rose forelsker seg?", "Titanic", "Armageddon", "Tomorrow Neved Dies", "Den Tapte Verden"},
            {"Hva er hovedstaden i Canada?", "Ottawa", "Vancouver", "Calgary", "Winnipeg"},
            {"Hvem var USAs aller første president?", "George Washington", "Abraham Lincoln", "Richard Nixon", "Barrack Obama"},
            {"I hvilken film møter vi Tony Montana?", "Scarface", "Gudfaren", "Die Hard", "Goodfellas"},
            {"Hva er hovedstaden i Danmark?", "København", "Århus", "Odense", "Ålborg"},
            {"Hvilken by i USA ble særlig hardt rammet av orkanen Katrina i 2005?", "New Orleans", "Chicago", "Kentucky", "Florida"},
            {"Hva heter Tom Cruise sin rollekarakter i Mission impossible filmserien?", "Ethan Hunt", "Ethan Hawk", "Brian Hunt", "Barry Hunt"},
            {"Hvor gammel var Napoleon da han døde?", "51", "60", "58", "53"},
            {"Hvilken Tv-serie handler om karakterer som Jon Snow og Aria Stark?", "Games of thrones", "Vikings", "Peaky Blinders", "Black Sails"},
            {"Hva er hovedstaden i Guyana?", "Georgetown", "Toka", "Corriverton", "Noitgedacht"}
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
