package com.example.labtel.certamen2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private EditText usuario;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        texto = (TextView) findViewById(R.id.Titulo);
        usuario = (EditText) findViewById(R.id.Usuario);
        btn = (Button) findViewById(R.id.Btn);

        texto.setText("Git Fider");

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, Activity_List.class);
                intent.putExtra("usuario",usuario.getText().toString());
                startActivity(intent);

            }
        });


    }

}

