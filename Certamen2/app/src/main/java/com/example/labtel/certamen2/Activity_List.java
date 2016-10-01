package com.example.labtel.certamen2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Activity_List extends AppCompatActivity  {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String user;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__list);
        titulo = (TextView) findViewById(R.id.txt);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        user = getIntent().getStringExtra("usuario");

        titulo.setText("Lista de repositorios del usuario "+user);
        //titulo.setText("Lista de repositorios del usuario xkiver");

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPreExecute(){
            }

            @Override
            protected String doInBackground(Void... params) {
                String resultado = new ConectionHttp().connectToServer("https://api.github.com/users/"+user+"/repos", 15000);
                //String resultado = new ConectionHttp().connectToServer("http://www.mocky.io/v2/57eee3822600009324111202",15000);
                return resultado;
            }

            @Override
            protected void onPostExecute(String result) {
                if(result != null){
                    mAdapter = new Myadapter(getLista(result));
                    mRecyclerView.setAdapter(mAdapter);

                }
            }
            @Override
            protected void onCancelled(){
                Toast.makeText(getApplicationContext(),"Ha ocurrido un problema con la conexion",Toast.LENGTH_SHORT).show();
            }
        };

        task.execute();
    }

    private List<Data> getLista(String result){
        List<Data> listaDatos = new ArrayList<>();
        try {
            JSONArray lista = new JSONArray(result);

            int size = lista.length();
            for(int i = 0; i < size; i++){
                Data datos = new Data();
                JSONObject objeto = lista.getJSONObject(i);

                datos.setNombre(objeto.getString("name"));
                datos.setDescripcion(objeto.getString("description"));
                datos.setUrl(objeto.getString("html_url"));
                datos.setActualizacion(objeto.getString("updated_at"));

                listaDatos.add(datos);
            }
            return listaDatos;
        } catch (JSONException e) {
            //si no es una lista objetos
            Intent intent = new Intent(Activity_List.this, Activity_Msj.class);
            intent.putExtra("Mensaje","No existe el usuario ingresado");
            startActivity(intent);

            e.printStackTrace();
            return listaDatos;
        }
    }
}
