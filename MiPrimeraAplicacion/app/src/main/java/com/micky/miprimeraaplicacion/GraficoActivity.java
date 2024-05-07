package com.micky.miprimeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.micky.miprimeraaplicacion.backend.Grafico;

public class GraficoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_grafico);

        setContentView(new Grafico(GraficoActivity.this));
    }
}