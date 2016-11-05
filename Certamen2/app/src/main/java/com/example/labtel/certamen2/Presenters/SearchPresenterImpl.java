package com.example.labtel.certamen2.Presenters;

import com.example.labtel.certamen2.Interactors.SearchInteractorImpl;
import com.example.labtel.certamen2.Interfaces.Search.SearchInteractor;
import com.example.labtel.certamen2.Interfaces.Search.SearchPresenter;
import com.example.labtel.certamen2.Interfaces.Search.SearchView;
import com.example.labtel.certamen2.Interfaces.Search.OnSearchFinishListener;

/**
 * Created by jvquiroga on 03-11-2016.
 */
public class SearchPresenterImpl implements SearchPresenter, OnSearchFinishListener {

    private SearchView view;
    private SearchInteractor interactor;
    public SearchPresenterImpl(SearchView view){
        this.view = view;
        interactor = new SearchInteractorImpl();

    }


    @Override
    public void BuscarUsuario(String user) {
        interactor.user_search(user,this);
    }

    @Override
    public void mensaje_error() {
        if (view != null){
            view.Msg_error();
        }
    }

    @Override
    public void exitoOperacion() {
        if (view != null){
            view.Exito_busqueda();
        }

    }

    @Override
    public void errorOperacion() {
        if(view != null){
            view.Error_busqueda();
        }

    }

    @Override
    public void search_error_conn() {
        view.Error_conn();
    }
}
