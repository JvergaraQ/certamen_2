package com.example.labtel.certamen2.Interactors;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.labtel.certamen2.ConectionHttp;
import com.example.labtel.certamen2.Data;
import com.example.labtel.certamen2.Interfaces.Lista.ListaInteractor;
import com.example.labtel.certamen2.Interfaces.Lista.OnListaFinishListener;
import com.example.labtel.certamen2.Myadapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jvquiroga on 04-11-2016.
 */
public class ListaInteractorImpl  implements ListaInteractor {


    @Override
    public void get_information(final String user, final OnListaFinishListener listener) {

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPreExecute(){
            }

            @Override
            protected String doInBackground(Void... params) {
                String resultado = new ConectionHttp().connectToServer("https://api.github.com/users/"+user+"/repos", 15000);
                return resultado;
            }

            @Override
            protected void onPostExecute(String result) {
                if(result != null){
                    listener.get_succesful(getLista(result));

                }
            }
            @Override
            protected void onCancelled(){
                listener.cancel_conn();

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
            e.printStackTrace();
            return listaDatos;
        }
    }

}
