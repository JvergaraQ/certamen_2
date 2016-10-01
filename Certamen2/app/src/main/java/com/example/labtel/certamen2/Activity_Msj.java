package com.example.labtel.certamen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_Msj extends AppCompatActivity {
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__msj);
        texto = (TextView) findViewById(R.id.texto);

        String msj = getIntent().getStringExtra("Mensaje");
        texto.setText(msj);

    }
}
