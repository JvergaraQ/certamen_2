package com.example.labtel.certamen2;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private List<Data> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView descp;
        public TextView act;
        private ItemClickListener clickListener;

        public ViewHolder(View v) {
            super(v);
            //v.setTag(v);//
            //v.setOnClickListener(this);//
            name= (TextView) v.findViewById(R.id.nombre);
            descp = (TextView) v.findViewById(R.id.descripcion);
            act = (TextView) v.findViewById(R.id.actualizacion);
        }


    }

    public Myadapter(List<Data> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public Myadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         Data dato = mDataset.get(position);
        holder.name.setText(dato.getNombre());
        holder.descp.setText(dato.getDescripcion());
        String[] separado1= dato.getActualizacion().split("T");
        String[] separado2= separado1[0].split("-");
        holder.act.setText("Ultima Actualización: "+separado2[2]+"-"+separado2[1]+"-"+separado2[0]);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}