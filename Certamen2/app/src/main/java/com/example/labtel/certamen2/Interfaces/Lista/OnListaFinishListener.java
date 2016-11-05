package com.example.labtel.certamen2.Interfaces.Lista;

import android.support.v7.widget.RecyclerView;

import com.example.labtel.certamen2.Data;
import com.example.labtel.certamen2.Views.Lista;

import java.util.List;

/**
 * Created by jvquiroga on 04-11-2016.
 */
public interface OnListaFinishListener {
    void succesful_conn();
    void get_succesful(List<Data> lista);
    void cancel_conn();
}
