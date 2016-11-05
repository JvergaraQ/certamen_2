package com.example.labtel.certamen2.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.labtel.certamen2.R;

public class Mensaje extends AppCompatActivity {
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensaje);
        texto = (TextView) findViewById(R.id.texto);

        texto.setText("No existe el usuario ingresado");

    }
}
