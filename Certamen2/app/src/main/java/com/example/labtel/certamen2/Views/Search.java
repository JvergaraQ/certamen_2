package com.example.labtel.certamen2.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.labtel.certamen2.Interfaces.Search.SearchPresenter;
import com.example.labtel.certamen2.Interfaces.Search.SearchView;
import com.example.labtel.certamen2.Presenters.SearchPresenterImpl;
import com.example.labtel.certamen2.R;

public class Search extends AppCompatActivity implements SearchView {

    private EditText usuario;
    private SearchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        usuario = (EditText) findViewById(R.id.Usuario);
        presenter = new SearchPresenterImpl(this);
    }

    @Override
    public void Error_busqueda() {
        startActivity(new Intent(Search.this, Mensaje.class));
    }

    @Override
    public void Exito_busqueda() {
        startActivity(new Intent(Search.this, Lista.class).putExtra("usuario",usuario.getText().toString()));
    }

    @Override
    public void Msg_error() {
        usuario.setError("Campo Obligatorio");
    }

    @Override
    public void Error_conn() {
        Toast.makeText(this,"Conexion a consulta de usuario cancelada",Toast.LENGTH_SHORT).show();
    }

    public void buscar(View v){
        presenter.BuscarUsuario(usuario.getText().toString());
    }
}

