package com.example.quizaton_alpha.quizkategorier;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
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

public class geoquiz extends AppCompatActivity {
    private TextView sporsmalsrunde, sporsmal;
    private Button svar1, svar2, svar3, svar4, tilbake;
    private String riktigSvar;
    private int riktigSvarAntall = 0;
    private int quizAntall = 1;
    static final private int QUIZ_ANTALL = 5;



    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();


    String quizData[][] = {
            //Europa
            {"Hva er hovedstaden i Norge?", "Oslo", "Bergen", "Trondheim", "Fredrikstad"},
            {"Hva er hovedstaden i Sverige?", "Stockholm", "Göteborg", "Malmö", "Uppsala"},
            {"Hva er hovedstaden i Danmark?", "København", "Århus", "Odense", "Ålborg"},
            {"Hva er hovedstaden i Spania?", "Madrid", "Zaragoza", "Bilbao", "Salamanca"},
            {"Hva er hovedstaden i Moldova?", "Chișinău", "Tiraspol", "Balti", "Riscani"},

            //Amerika
            {"Hva er hovedstaden i Guyana?", "Georgetown", "Toka", "Corriverton", "Noitgedacht"},
            {"Hva er hovedstaden i Canada?", "Ottawa", "Vancouver", "Calgary", "Winnipeg"},
            {"Hva er hovedstaden i Argentina?", "Buenos Aires", "San Rafael", "Bahia Blanca", "Mendoza"},
            {"Hva er hovedstaden i Mexico?", "Mexico City", "Monterrey", "Matamoros", "Guadalajara"},
            {"Hva er hovedstaden i Surinam?", "Paramaribo", "Afobakka", "Kwamalasamutu", "Peleloetepu"},

            //Asia
            {"Hva er hovedstaden i Kina?", "Beijing", "Chengdu", "Chongqing", "Wuhan"},
            {"Hva er hovedstaden i Sør-korea?", "Seoul", "Busan", "Daejeon", "Daegu"},
            {"Hva er hovedstaden i Pakistan?", "Islamabad", "Faisalabad", "Lahore", "Multan"},
            {"Hva er hovedstaden i India?", "New Delhi", "Jaipur", "Indore", "Ahmedabad"},
            {"Hva er hovedstaden i Bangladesh?", "Dhaka", "Bogra", "Mymensingh", "Chittagong"},

            //Afrika
            {"Hva er hovedstaden i Botswana?", "Georgetown", "Toka", "Corriverton", "Noitgedacht"},
            {"Hva er hovedstaden i Egypt?", "Kairo", "Alexandria", "Luxor", "Sohag"},
            {"Hva er hovedstaden i Sør-afrika?", "Cape Town", "Kimberly", "Port Elizabeth", "George"},
            {"Hva er hovedstaden i Mali?", "Bamako", "Gao", "Segou", "Timbuktu"},
            {"Hva er hovedstaden i Tsjad?", "N'Djamena", "Bahr El Ghazal", "Am Djemena", "Massakory"},

            //Oseania
            {"Hva er hovedstaden i Australia?", "Canberra", "Adelaide", "Melbourne", "Geraldton"},
            {"Hva er hovedstaden i New Zealand?", "Wellington", "Auckland", "Hamilton", "Hastings"},
            {"Hva er hovedstaden i Filippinene?", "Manila", "Iloilo", "Zamboanga", "Davao"},
            {"Hva er hovedstaden i Indonesia?", "Dili", "Kendari","Ambon", "Kupang"},
            {"Hva er hovedstaden i Papua new guinea?", "Port Moresby", "Madang", "Wewak", "Awara"}
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
            beskjedTittel = "Feil!";
            svarButton.setBackgroundColor(Color.RED);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(beskjedTittel);
        builder.setMessage("Svaret er: " + riktigSvar);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizAntall == QUIZ_ANTALL) {
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
