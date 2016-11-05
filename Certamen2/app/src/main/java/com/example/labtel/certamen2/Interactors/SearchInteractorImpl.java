package com.example.labtel.certamen2.Interactors;

import android.os.AsyncTask;
import android.widget.Toast;

import com.example.labtel.certamen2.ConectionHttp;
import com.example.labtel.certamen2.Interfaces.Search.SearchInteractor;
import com.example.labtel.certamen2.Interfaces.Search.OnSearchFinishListener;
import com.example.labtel.certamen2.Myadapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by jvquiroga on 03-11-2016.
 */
public class SearchInteractorImpl implements SearchInteractor {

    @Override
    public void user_search(final String user, final OnSearchFinishListener listener) {

        if(!user.equals(""))
        {
            AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... params) {

                    URL url = null;
                    HttpURLConnection conn = null;
                    String result="";
                    try {
                        url = new URL("https://api.github.com/users/"+user+"/repos");

                        conn = (HttpURLConnection) url.openConnection();
                        conn.setConnectTimeout(15000);
                        conn.setRequestMethod("GET");
                        conn.setDoInput(true);
                        conn.connect();
                        InputStream is = conn.getInputStream();

                        Reader reader = null;
                        StringBuilder inputStringBuilder = new StringBuilder();

                        reader = new InputStreamReader(is, "UTF-8");
                        BufferedReader bufferedReader = new BufferedReader(reader);

                        String line = bufferedReader.readLine();
                        while(line != null){
                            inputStringBuilder.append(line);
                            inputStringBuilder.append('\n');
                            line = bufferedReader.readLine();
                        }
                       result = inputStringBuilder.toString();
                        System.out.println(result);
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    }catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                    e.printStackTrace();
                    }

                    //String resultado = new ConectionHttp().connectToServer("https://api.github.com/users/"+user+"/repos", 15000);
                    //return resultado;
                    return result;
                }

                @Override
                protected void onPostExecute(String result) {
                    if(!result.equals("")){
                        listener.exitoOperacion();
                    }
                    else{
                        System.out.println("result es null");
                        listener.errorOperacion();
                    }

                }
                @Override
                protected void onCancelled(){
                    listener.search_error_conn();
                }
            };

            task.execute();
        }
        else {
            listener.mensaje_error();
        }

    }
}
