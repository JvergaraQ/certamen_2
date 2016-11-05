package com.example.labtel.certamen2.Views;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.labtel.certamen2.ConectionHttp;
import com.example.labtel.certamen2.Data;
import com.example.labtel.certamen2.Interfaces.Lista.ListaPresenter;
import com.example.labtel.certamen2.Interfaces.Lista.ListaView;
import com.example.labtel.certamen2.Myadapter;
import com.example.labtel.certamen2.Presenters.ListaPresenterImpl;
import com.example.labtel.certamen2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity implements ListaView {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String user;
    private TextView titulo;
    private ListaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        titulo = (TextView) findViewById(R.id.txt);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        user = getIntent().getStringExtra("usuario");
        presenter = new ListaPresenterImpl(this);

        titulo.setText("lista de repositorios del usuario " + user);

        presenter.Obtenerdatos(user);

    }


    @Override
    public void conn_exitosa() {
        Toast.makeText(this,"Conexion con servidor exitosa",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void get_exitoso(List<Data> list) {
        Toast.makeText(this,"Obtencion de datos exitosa",Toast.LENGTH_SHORT).show();
        mAdapter = new Myadapter(list);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void conn_cancel() {
        Toast.makeText(this,"Ha ocurrido un problema con la conexion",Toast.LENGTH_SHORT).show();
    }

}
