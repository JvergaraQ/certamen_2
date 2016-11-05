package com.example.labtel.certamen2.Presenters;

import com.example.labtel.certamen2.Data;
import com.example.labtel.certamen2.Interactors.ListaInteractorImpl;
import com.example.labtel.certamen2.Interfaces.Lista.ListaInteractor;
import com.example.labtel.certamen2.Interfaces.Lista.ListaPresenter;
import com.example.labtel.certamen2.Interfaces.Lista.ListaView;
import com.example.labtel.certamen2.Interfaces.Lista.OnListaFinishListener;

import java.util.List;

/**
 * Created by jvquiroga on 04-11-2016.
 */
public class ListaPresenterImpl implements ListaPresenter,OnListaFinishListener {
    private ListaView view;
    private ListaInteractor interactor;
    public ListaPresenterImpl(ListaView view){
        this.view = view;
        interactor = new ListaInteractorImpl();

    }

    @Override
    public void Obtenerdatos(String user) {
        if(view != null)
        {
            interactor.get_information(user,this);
        }

    }
    @Override
    public void succesful_conn() {
        if (view != null){
            view.conn_exitosa();
        }
    }

    @Override
    public void get_succesful(List<Data> lista) {
        if (view != null){
            view.get_exitoso(lista);
        }
    }

    @Override
    public void cancel_conn() {
        if (view != null){
            view.conn_cancel();
        }
    }
}
