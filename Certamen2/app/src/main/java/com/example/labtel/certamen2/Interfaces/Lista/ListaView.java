package com.example.labtel.certamen2.Interfaces.Lista;

import android.support.v7.widget.RecyclerView;

import com.example.labtel.certamen2.Data;

import java.util.List;

/**
 * Created by jvquiroga on 04-11-2016.
 */
public interface ListaView {

    void conn_exitosa();
    void get_exitoso(List<Data> lista);
    void conn_cancel();
}
