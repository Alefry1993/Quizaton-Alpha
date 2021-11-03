package com.example.quizaton_alpha.Activities;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizaton_alpha.R;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.firebase.firestore.FirebaseFirestore;

public class thequiz extends AppCompatActivity {

    FirebaseFirestore db;

    static final String TAG = "Read Data Activity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thequiz);
}}
